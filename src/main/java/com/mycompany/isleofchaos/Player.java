package com.mycompany.isleofchaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    String userName;
    int coins;
    PlayerStats stats;
    List<Character> party;
    Inventory inventory;

    public Player() {
        userName = "John";
        coins = 0;
        party = new ArrayList<>();
        inventory = new Inventory();
        stats = new PlayerStats();
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    void printStats() {
        stats.printStats();
    }

    void increaseMoney(int val) {
        coins += val;
    }

    void resetParty() {
        party.clear();
    }

    void addToParty(Character character) {
        party.add(character);
    }

    void printParty() {
        for(int i = 0; i < party.size(); i++) {
            System.out.print(i+1 + ". ");
            party.get(i).printInfo();
        }
    }

    Character selectCharacter() {
        printParty();

        Scanner input = new Scanner(System. in);
        System.out.println("Select character: ");
        String  s = input. nextLine();
        int i = Integer.parseInt(s);

        return party.get(i-1);
    }

}
