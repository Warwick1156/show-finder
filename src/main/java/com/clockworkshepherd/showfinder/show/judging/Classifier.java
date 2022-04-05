package com.clockworkshepherd.showfinder.show.judging;

public interface Classifier {
   void process(String input, JudgingPlan context);
}
