package com.mycompany.isleofchaos;

public class AttackBuff_Item extends Item{
    int value;

    public AttackBuff_Item(String name, int cost, String description, int value) {
        super(name, cost, description);
        this.value = value;
    }

    @Override
    void consume(Character c) {
        c.increaseSTR(value);
    }
}
