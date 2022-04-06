package com.clockworkshepherd.showfinder.show.judging;

public class CompetitionBuilder {
    private String name = "";
    private int dogsInCompetition = -1;
    private int numbersFrom = -1;
    private int numbersTo = -1;

    public CompetitionBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public CompetitionBuilder setDogsInCompetition(String dogsInCompetition) {
        this.dogsInCompetition = Integer.parseInt(dogsInCompetition);

        return this;
    }

    public CompetitionBuilder setNumbersFrom(String numbersFrom) {
        this.numbersFrom = Integer.parseInt(numbersFrom);

        return this;
    }

    public CompetitionBuilder setNumbersTo(String numbersTo) {
        if (numbersTo != null) {
            this.numbersTo = Integer.parseInt(numbersTo);
        } else {
            this.numbersTo = this.numbersFrom;
        }

        return this;
    }

    public Competition build() {
        return new Competition(name, dogsInCompetition, numbersFrom, numbersTo);
    }
}
