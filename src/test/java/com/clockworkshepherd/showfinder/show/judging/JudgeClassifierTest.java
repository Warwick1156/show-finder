package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class JudgeClassifierTest {

    @Test
    void process_shouldSetJudgePropertyInLastRingInJudgingPlan(){
        JudgingPlan judgingPlan = new JudgingPlan();
        judgingPlan.addRing();

        String input = "Sędzia: Nenad Mtejevic (RS)";
        JudgeClassifier.process(input, judgingPlan);

        Assertions.assertEquals("Nenad Mtejevic", judgingPlan.getLastRing().getJudge());
    }
}