package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgingStartTimeClassifierTest {

    private static JudgingPlan judgingPlan;

    @BeforeEach
    public void setUp() {
        judgingPlan = new JudgingPlan();
        judgingPlan.addRing();
        judgingPlan.getLastRing().addBreed();
    }

    @Test
    void process_shouldSetRightJudgingStartTimeWhenInputMatchesPattern() {
        String input = "11.35 Staffordshire Bull Terrier (63)";

        new JudgingStartTimeClassifier().process(input, judgingPlan);

        assertEquals("11.35", judgingPlan.getLastRing().getLastBreed().getJudgingStartTime());
    }
}