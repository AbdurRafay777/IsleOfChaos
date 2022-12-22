package com.mycompany.isleofchaos;

public abstract class Skill {
    Character character;
    String name;
    String targetType;
    String description;
    int mpCost;

    public Skill(Character character, String name, String targetType, String description, int mpCost) {
        this.character = character;
        this.name = name;
        this.targetType = targetType;
        this.description = description;
        this.mpCost = mpCost;
    }

    void print() {
        System.out.println(name + " - " + mpCost + "MP (" + description + ")");
    }

    void perform() {
        System.out.println(this.character.name + " used " + this.name);
    }
}
