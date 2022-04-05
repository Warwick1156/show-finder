package com.clockworkshepherd.showfinder.show.judging;

import java.util.ArrayList;
import java.util.List;

public class JudgingPlan {
    List<Ring> rings = new ArrayList<>();

    public void addRing() { rings.add(new Ring()); }

    public void addRing(int ringNumber) { rings.add(new Ring(ringNumber)); }

    public List<Ring> getRings() {
        return rings;
    }

    public Ring getLastRing() {
        return rings.get(rings.size() - 1);
    }
}
