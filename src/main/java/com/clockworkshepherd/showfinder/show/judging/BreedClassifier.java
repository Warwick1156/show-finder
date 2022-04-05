package com.clockworkshepherd.showfinder.show.judging;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BreedClassifier {
    public final static Pattern pattern = Pattern.compile("([A-Z]?[a-z]+\\s?)+");

    private final List<String> breeds;

    public BreedClassifier(List<String> breeds) {
        this.breeds = breeds;
    }

    public void process(String input, JudgingPlan context) {
        if (containsBreed(input)) {
            context.getLastRing().addBreed(extractBreedName(input));
        }
    }

    private Boolean containsBreed(String input) {
        return breeds.stream().filter(input::contains).toList().size() > 0;
    }

    private String extractBreedName(String input) {
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        return matcher.group().strip();
    }
}
