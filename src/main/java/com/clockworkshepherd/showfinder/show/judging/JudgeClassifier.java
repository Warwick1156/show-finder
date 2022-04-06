package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JudgeClassifier implements Classifier{
    private static final Pattern pattern = Pattern.compile("(Sędzia:\\s)(?<judgeName>([\\p{IsAlphabetic}]+)\\s" +
            "([\\p{IsAlphabetic}]+\\s)?([\\p{IsAlphabetic}]*))");

    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            context.getLastRing()
                    .setJudge(matcher.group("judgeName").strip());
        }
    }
}
