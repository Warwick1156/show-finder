package com.clockworkshepherd.showfinder.show.judging;

import java.util.ArrayList;
import java.util.List;

public class Ring {
    private String judge;
    private int ringNumber;
    private List<Breed> breeds = new ArrayList<>();

    Ring() {}

    Ring(int ringNumber) {
        this.ringNumber = ringNumber;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public int getRingNumber() {
        return ringNumber;
    }

    public void setRingNumber(int ringNumber) {
        this.ringNumber = ringNumber;
    }

    public Breed getLastBreed() {
        return breeds.get(breeds.size() - 1);
    }

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void addBreed() {
        breeds.add(new Breed());
    }

    public void addBreed(String breedName) {
        breeds.add(new Breed(breedName));
    }
}
