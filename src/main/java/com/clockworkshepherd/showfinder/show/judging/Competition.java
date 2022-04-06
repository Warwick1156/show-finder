package com.clockworkshepherd.showfinder.show.judging;

public class Competition {
    private final String name;
    private final int dogsInCompetition;
    private final int numbersFrom;
    private final int numbersTo;

    public Competition(String name, int dogsInCompetition, int numbersFrom, int numbersTo) {
        this.name = name;
        this.dogsInCompetition = dogsInCompetition;
        this.numbersFrom = numbersFrom;
        this.numbersTo = numbersTo;
    }

    public String getName() {
        return name;
    }

    public int getDogsInCompetition() {
        return dogsInCompetition;
    }

    public int getNumbersFrom() {
        return numbersFrom;
    }

    public int getNumbersTo() {
        return numbersTo;
    }
}
