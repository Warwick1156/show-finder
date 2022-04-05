package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RingClassifier implements Classifier{
    public static final Pattern pattern = Pattern.compile("Ring:\\s[0-9]+");
    public static final String term = "Ring: ";

    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            context.addRing(extractRingNumber(matcher.group()));
        }
    }

    private static int extractRingNumber(String input) {
        input = input.substring(term.length());
        return Integer.parseInt(input);
    }
}
