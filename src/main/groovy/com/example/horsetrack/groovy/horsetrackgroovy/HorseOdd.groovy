package com.example.horsetrack.groovy.horsetrackgroovy;

class HorseOdd {
    Integer horseNumber;
    String horseName;
    Integer odds;
    boolean win;

    HorseOdd(Integer horseNumber, String horseName, Integer odds, boolean win) {
        this.horseNumber = horseNumber;
        this.horseName = horseName;
        this.odds = odds;
        this.win = win;
    }

    @Override
    public String toString() {
        return horseNumber + ", " + horseName + ", " + odds +
                ", " + (win ? "won" : "lost");
    }
}
