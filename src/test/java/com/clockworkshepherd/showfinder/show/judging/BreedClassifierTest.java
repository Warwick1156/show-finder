package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreedClassifierTest {

    @Test
    void process_shouldAddNewBreedToRingWhenInputContainsBreedName() {
        String input = "Kangal";
        JudgingPlan judgingPlan = new JudgingPlan();
        judgingPlan.addRing();
        BreedClassifier breedClassifier = new BreedClassifier(List.of("Kangal", "White Swiss Shepherd"));

        breedClassifier.process(input, judgingPlan);

        assertEquals(1, judgingPlan.getLastRing().getBreeds().size());
    }

    @Test
    void process_shouldNotAddNewBreedWhenInputDoesNotContainBreedName() {
        String input = "Sedzia: Anna Maria Jopek";
        JudgingPlan judgingPlan = new JudgingPlan();
        judgingPlan.addRing();
        BreedClassifier breedClassifier = new BreedClassifier(List.of("Kangal", "White Swiss Shepherd"));

        breedClassifier.process(input, judgingPlan);

        assertEquals(0, judgingPlan.getLastRing().getBreeds().size());
    }

    @Test
    void process_shouldAddBreedWithRightBreedName() {
        String input = "10.00 White Swiss Shepherd (48)";
        JudgingPlan judgingPlan = new JudgingPlan();
        judgingPlan.addRing();
        BreedClassifier breedClassifier = new BreedClassifier(List.of("Kangal", "White Swiss Shepherd"));

        breedClassifier.process(input, judgingPlan);

        assertEquals("White Swiss Shepherd", judgingPlan.getLastRing().getLastBreed().getBreedName());
    }
}