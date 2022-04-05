package com.clockworkshepherd.showfinder.show.judging;

public class Ring {
    private String judge;
    private int ringNumber;

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
}
