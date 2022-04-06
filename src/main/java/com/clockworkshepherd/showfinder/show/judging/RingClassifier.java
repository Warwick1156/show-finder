package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RingClassifier implements Classifier{
    public static final Pattern pattern = Pattern.compile("(Ring:\\s)(?<ringNumber>[0-9]+)");

    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            context.addRing(Integer.parseInt(matcher.group("ringNumber")));
        }
    }
}
