package com.mycompany.isleofchaos;

public class HP_Item extends Item {
    int value;

    public HP_Item(String name, int cost, String description, int value) {
        super(name, cost, description);
        this.value = value;
    }

    @Override
    void consume(Character c) {
        c.changeHP(value);
    }
}
