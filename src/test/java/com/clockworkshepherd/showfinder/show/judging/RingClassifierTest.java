package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingClassifierTest {

    @Test
    void process_shouldAddRingWhenInputContainsKeyword() {
        JudgingPlan judgingPlan = new JudgingPlan();
        String input = "Ring: 1";

        RingClassifier.process(input, judgingPlan);

        Assertions.assertEquals(1, judgingPlan.getRings().size());
    }

    @Test
    void process_shouldNotAddRingWhenInputDoNotContainsKeyword() {
        JudgingPlan judgingPlan = new JudgingPlan();
        String input = "Sędzia: Selena Gomez";

        RingClassifier.process(input, judgingPlan);

        Assertions.assertEquals(0, judgingPlan.getRings().size());
    }

    @Test
    void process_shouldAddRingWithRightRingNumber() {
        JudgingPlan judgingPlan = new JudgingPlan();
        String input = "Ring: 5 Razem: 111";

        RingClassifier.process(input, judgingPlan);

        assertEquals(5, judgingPlan.getLastRing().getRingNumber());
    }

    @Test
    void extractRingNumber_shouldReturnRightIntegerValue() {
        String input = "Ring: 1";

        assertEquals(1, RingClassifier.extractRingNumber(input));
    }
}