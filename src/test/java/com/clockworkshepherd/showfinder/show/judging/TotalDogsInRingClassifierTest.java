package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalDogsInRingClassifierTest {

    private static JudgingPlan judgingPlan;

    @BeforeEach
    public void setUp() {
        judgingPlan = new JudgingPlan();
        judgingPlan.addRing();
    }

    @Test
    void process_shouldSetRightNumbersOfTotalDogsInRingWhenInputMatchesPattern() {
        String input = "Ring: 1 Sobota / Saturday Razem: 111";

        new TotalDogsInRingClassifier().process(input, judgingPlan);

        assertEquals(111, judgingPlan.getLastRing().getTotalDogs());
    }

    @Test
    void process_shouldNotSetNumbersOfTotalDogsInRingWhenInputDoesNotMatchesPattern() {
        String input = "Klasa pośrednia - Intermediate Class 8 1522 - 1529";

        new TotalDogsInRingClassifier().process(input, judgingPlan);

        assertEquals(0, judgingPlan.getLastRing().getTotalDogs());
    }
}