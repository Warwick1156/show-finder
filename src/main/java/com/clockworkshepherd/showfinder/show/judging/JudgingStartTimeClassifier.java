package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JudgingStartTimeClassifier implements Classifier{
    public static final Pattern pattern = Pattern.compile("[0-9]{2}.[0-9]{2}");

    @Override
    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            context.getLastRing().getLastBreed().setJudgingStartTime(matcher.group());
        }
    }
}
