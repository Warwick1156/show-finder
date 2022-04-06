package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SexClassifierTest {

    private static JudgingPlan judgingPlan;

    @BeforeEach
    public void setJudgingPlan() {
        judgingPlan = new JudgingPlan();

        judgingPlan.addRing();
        judgingPlan.getLastRing().addBreed();
    }

    @Test
    void process_shouldAddSexWhenInputMatchesPattern() {
        String input = "Suki - Females";

        SexClassifier sexClassifier = new SexClassifier();
        sexClassifier.process(input, judgingPlan);

        assertEquals("Females", judgingPlan.getLastRing().getLastBreed().getLastSex().getName());
    }

    @Test
    void process_shouldNotAddSexWhenInputDoesNotMatchPattern() {
        String input = "Klasa młodszych szczeniąt - Minor Puppy 1 1289";

        SexClassifier sexClassifier = new SexClassifier();
        sexClassifier.process(input, judgingPlan);

        assertEquals(0, judgingPlan.getLastRing().getLastBreed().getSexes().size());
    }
}