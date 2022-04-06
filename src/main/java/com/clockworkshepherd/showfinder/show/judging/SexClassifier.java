package com.clockworkshepherd.showfinder.show.judging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SexClassifier implements Classifier{
    public static final Pattern pattern = Pattern.compile("([a-zA-Z]{3,4}\\s-\\s)(?<sex>[a-zA-Z]{5,7})");

    @Override
    public void process(String input, JudgingPlan context) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String sex = matcher.group("sex");
            context.getLastRing().getLastBreed().addSex(sex);
        }
    }
}
