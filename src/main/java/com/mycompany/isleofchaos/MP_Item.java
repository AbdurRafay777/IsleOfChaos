package com.mycompany.isleofchaos;

public class MP_Item extends Item{
    int value;

    public MP_Item(String name, int cost, String description, int value) {
        super(name, cost, description);
        this.value = value;
    }

    @Override
    void consume(Character c) {
        c.changeMP(value);
    }
}
