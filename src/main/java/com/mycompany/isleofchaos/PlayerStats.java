package com.mycompany.isleofchaos;

public class PlayerStats {
    int numOfWins;
    int numOfLosses;

    public PlayerStats() {
        this.numOfWins = 0;
        this.numOfLosses = 0;
    }

    void increaseNumOfWins() {
        numOfWins++;
    }

    void increaseNumOfLosses() {
        numOfLosses++;
    }

    void printStats() {
        System.out.println("Wins: " + numOfWins);
        System.out.println("Losses: " + numOfLosses);
    }
}
