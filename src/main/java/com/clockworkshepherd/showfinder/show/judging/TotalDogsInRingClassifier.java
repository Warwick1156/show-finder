package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalDogsInRingClassifier implements Classifier{
    public static final Pattern pattern = Pattern.compile("Razem:\\s(?<totalDogs>[0-9]{1,3})");

    @Override
    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            context.getLastRing().setTotalDogs(Integer.parseInt(matcher.group("totalDogs")));
        }
    }
}
