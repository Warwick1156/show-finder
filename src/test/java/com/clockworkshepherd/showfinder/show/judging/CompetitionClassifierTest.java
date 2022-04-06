package com.clockworkshepherd.showfinder.show.judging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionClassifierTest {

    private static JudgingPlan judgingPlan;

    @BeforeEach
    public void setJudgingPlan() {
        judgingPlan = new JudgingPlan();

        judgingPlan.addRing();
        judgingPlan.getLastRing().addBreed();
        judgingPlan.getLastRing().getLastBreed().addSex("Males");
    }

    @Test
    void process_shouldAddCompetitionWithRightFieldsWhenPatternMatchesInput() {
        String input = "Klasa otwarta - Open Class 2 1325 - 1326";

        new CompetitionClassifier().process(input, judgingPlan);

        assertEquals("Open Class", getLastCompetition(judgingPlan).getName());
        assertEquals(2, getLastCompetition(judgingPlan).getDogsInCompetition());
        assertEquals(1325, getLastCompetition(judgingPlan).getNumbersFrom());
        assertEquals(1326, getLastCompetition(judgingPlan).getNumbersTo());
    }

    @Test
    void process_numbersToShouldEqualsNumbersFromWhenNumbersToIsNotPresentInPattern() {
        String input = "Klasa pośrednia - Intermediate Class 1 1324";

        new CompetitionClassifier().process(input, judgingPlan);

        assertEquals(1324, getLastCompetition(judgingPlan).getNumbersTo());
    }

    @Test
    void process_shouldNotAddCompetitionWhenInputDoesNotMatchPattern() {
        String input = "Suki - Females";

        new CompetitionClassifier().process(input, judgingPlan);

        assertEquals(0, judgingPlan.getLastRing().getLastBreed().getLastSex().getCompetitions().size());
    }

    Competition getLastCompetition(JudgingPlan judgingPlan) {
        List<Competition> competitions = judgingPlan.getLastRing().getLastBreed().getLastSex().getCompetitions();
        return competitions.get(competitions.size() - 1);
    }
}