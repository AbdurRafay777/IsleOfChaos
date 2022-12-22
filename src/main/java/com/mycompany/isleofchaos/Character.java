package com.mycompany.isleofchaos;

public abstract class Character {
    Player player;
    String name;
    String race;
    String phyWeak;
    String magWeak;
    int maxHP;
    int maxMP;
    int currHP;
    int currMP;
    int strength;
    int defense;
    int evade;

    public Character(String name, String race, String phyWeak, String magWeak, int maxHP, int maxMP, int strength, int defense, int evade) {
        this.name = name;
        this.race = race;
        this.phyWeak = phyWeak;
        this.magWeak = magWeak;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.maxMP = maxMP;
        this.currMP = maxMP;
        this.strength = strength;
        this.defense = defense;
        this.evade = evade;
    }

    public Character(Character c) {
        this.name = c.name;
        this.race = c.race;
        this.phyWeak = c.phyWeak;
        this.magWeak = c.magWeak;
        this.maxHP = c.maxHP;
        this.currHP = c.maxHP;
        this.maxMP = c.maxMP;
        this.currMP = c.maxMP;
        this.strength = c.strength;
        this.defense = c.defense;
        this.evade = c.evade;
    }

    void changeHP(int x) {
        if(currHP + x > maxHP)
            currHP = maxHP;
        else if(currHP - x < 0)
            currHP = 0;
        else
            currHP += x;
    }

    void changeMP(int x) {
        if(currMP + x > maxMP)
            currMP = maxMP;
        else if(currMP - x < 0)
            currMP = 0;
        else
            currMP += x;
    }

    void increaseSTR(int x) {
        strength += x;
    }

    void increaseDEF(int x) {
        defense += x;
    }

    void increaseEVADE(int x) {
        evade += x;
    }

    boolean isAlive() {
        return currHP > 0;
    }

    void attack() {
    }

    void defend() {
        increaseDEF(2*defense);
    }

    void printInfo() {
        System.out.println(name + "\nHP: " + currHP + " / " + maxHP + "\nMP: " + currMP + " / " + maxMP );
    }

    abstract void useSkill();
    abstract void useItem();
}
