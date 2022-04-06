package com.clockworkshepherd.showfinder.show.judging;

import java.util.ArrayList;
import java.util.List;

public class Breed {
    private String breedName;
    private String judgingStartTime = "";
    private List<Sex> sexes = new ArrayList<>();

    public Breed(String breedName) {
        this.breedName = breedName;
    }

    public Breed() {}

    public String getBreedName() {
        return breedName;
    }

    public void addSex(String sex) {
        sexes.add(new Sex(sex));
    }

    public Sex getLastSex() {
        return sexes.get(sexes.size() - 1);
    }

    public List<Sex> getSexes() {
        return sexes;
    }

    public void setJudgingStartTime(String judgingStartTime) {
        this.judgingStartTime = judgingStartTime;
    }

    public String getJudgingStartTime() {
        return judgingStartTime;
    }
}
