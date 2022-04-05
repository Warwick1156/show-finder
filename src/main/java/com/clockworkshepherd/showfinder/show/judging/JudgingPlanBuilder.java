package com.clockworkshepherd.showfinder.show.judging;

import java.util.ArrayList;
import java.util.List;

public class JudgingPlanBuilder {
    private List<Classifier> classifiers = new ArrayList<>();
    private JudgingPlan judgingPlan = new JudgingPlan();
    private List<String> textLines;

    public JudgingPlanBuilder addClassifier(Classifier classifier) {
        classifiers.add(classifier);

        return this;
    }

    public JudgingPlanBuilder setInputText(List<String> inputText) {
        this.textLines = inputText;

        return this;
    }

    public JudgingPlan build() {
        textLines.forEach(line -> {
            classifiers.forEach(classifier -> classifier.process(line, judgingPlan));
        });

        return judgingPlan;
    }
}

