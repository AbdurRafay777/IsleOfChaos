package com.mycompany.isleofchaos;
public class DefenseBuff_Item extends Item{
    int value;

    public DefenseBuff_Item(String name, int cost, String description, int value) {
        super(name, cost, description);
        this.value = value;
    }

    @Override
    void consume(Character c) {
        c.increaseDEF(value);
    }
}
