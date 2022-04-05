package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgingPlanBuilderTest {

    static BreedClassifier breedClassifier;
    static List<String> textLines;
    static JudgingPlanBuilder judgingPlanBuilder;

    @BeforeAll
    public static void setUp() {
         breedClassifier = new BreedClassifier(List.of(
                "American Staffordshire Terrier",
                "Staffordshire Bull Terrier",
                "Airedale Terrier",
                "Australian Silky Terrier",
                "Bedlington Terrier"
        ));

         textLines = List.of(
                "Ring: 1 Sobota / Saturday Razem: 111",
                "Sędzia: Nenad Matejevic (RS) 111",
                "10.00 American Staffordshire Terrier (48)",
                "11.35 Staffordshire Bull Terrier (63)",

                "Ring: 2 Sobota / Saturday Razem: 107",
                "Sędzia: Andrzej Szutkiewicz (PL) 107",
                "10.00 Airedale Terrier (12)",
                "10.25 Australian Silky Terrier (2)",
                "10.30 Bedlington Terrier (15)"
        );
    }

    @BeforeEach
    public void setBuilder() {

         judgingPlanBuilder = new JudgingPlanBuilder()
                .addClassifier(new RingClassifier())
                .addClassifier(new JudgeClassifier())
                .addClassifier(breedClassifier)
                .setInputText(textLines);
    }

    @Test
    void build_shouldReturnJudgingPlanWithRightFields() {
        JudgingPlan judgingPlan = judgingPlanBuilder.build();

        assertEquals(1, judgingPlan.getRings().get(0).getRingNumber());
        assertEquals("Nenad Matejevic", judgingPlan.getRings().get(0).getJudge());
        assertEquals("American Staffordshire Terrier", judgingPlan.getRings().get(0).getBreeds().get(0).getBreedName());
        assertEquals("Staffordshire Bull Terrier", judgingPlan.getRings().get(0).getBreeds().get(1).getBreedName());

        assertEquals(2, judgingPlan.getRings().get(1).getRingNumber());
        assertEquals("Andrzej Szutkiewicz", judgingPlan.getRings().get(1).getJudge());
        assertEquals("Airedale Terrier", judgingPlan.getRings().get(1).getBreeds().get(0).getBreedName());
        assertEquals("Australian Silky Terrier", judgingPlan.getRings().get(1).getBreeds().get(1).getBreedName());
        assertEquals("Bedlington Terrier", judgingPlan.getRings().get(1).getBreeds().get(2).getBreedName());
    }

}