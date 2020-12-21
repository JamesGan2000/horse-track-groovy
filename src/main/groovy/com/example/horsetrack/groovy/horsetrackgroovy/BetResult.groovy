package com.example.horsetrack.groovy.horsetrackgroovy;

class BetResult {
    HorseOdd matchingHorse;
    Integer winningAmount;
    boolean horseFound;

    void setMatchingHorse(HorseOdd matchingHorse) {
        this.matchingHorse = matchingHorse;
        this.horseFound = (matchingHorse != null);
    }
}
