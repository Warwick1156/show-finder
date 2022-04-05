package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JudgeClassifier {
    private static final Pattern pattern = Pattern.compile("(Sędzia:\\s)([A-Z][a-z]+)(\\s[A-Z][a-z]+)?(\\s[A-Z][a-z]+)");
    private static final String term = "Sędzia: ";

    public void process(String textLine, JudgingPlan context) {
        Matcher matcher = pattern.matcher(textLine);
        if (matcher.find()) {
            context.getLastRing()
                    .setJudge(extractJudgeName(matcher.group()));
        }
    }

    public static String extractJudgeName(String input) {
        return input.substring(term.length());
    }
}
