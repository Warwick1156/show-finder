package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompetitionClassifier implements Classifier {
    private final static Pattern pattern = Pattern.compile("([\\p{IsAlphabetic}]+\\s)([\\p{IsAlphabetic}]+\\s)?" +
            "([\\p{IsAlphabetic}]+\\s)(-\\s)(?<competition>[A-z][a-z]+\\s[A-Z][a-z]+)\\s(?<dogsInCompetition>[0-9]+)\\s" +
            "(?<numberFrom>[0-9]+)(\\s-\\s)?(?<numberTo>[0-9]+)?");

    @Override
    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            context.getLastRing().getLastBreed().getLastSex().addCompetition(
                    new CompetitionBuilder()
                            .setName(matcher.group("competition"))
                            .setDogsInCompetition(matcher.group("dogsInCompetition"))
                            .setNumbersFrom(matcher.group("numberFrom"))
                            .setNumbersTo(matcher.group("numberTo"))
                            .build()
            );
        }
    }
}
