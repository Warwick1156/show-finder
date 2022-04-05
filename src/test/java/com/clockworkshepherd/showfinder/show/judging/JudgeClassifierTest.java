package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class JudgeClassifierTest {

    @Test
    void process_shouldSetJudgePropertyInLastRingInJudgingPlan(){
        JudgingPlan judgingPlan = new JudgingPlan();
        judgingPlan.addRing();
        JudgeClassifier judgeClassifier = new JudgeClassifier();

        String input = "Sędzia: Nenad Mtejevic (RS)";
        judgeClassifier.process(input, judgingPlan);

        Assertions.assertEquals("Nenad Mtejevic", judgingPlan.getLastRing().getJudge());
    }

    @Test
    void extractJudgeName_shouldReturnJudeFullName() {
        String input = "Sędzia: Nenad Mtejevic";

        Assertions.assertEquals("Nenad Mtejevic", JudgeClassifier.extractJudgeName(input));
    }
}