package com.clockworkshepherd.showfinder.show.judging;

import java.util.ArrayList;
import java.util.List;

public class Sex {
    private String name;
    private List<Competition> competitions = new ArrayList<>();

    public Sex(String name) {
        this.name = name;
    }

    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    public String getName() {
        return name;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }
}
