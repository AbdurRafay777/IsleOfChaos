package com.mycompany.isleofchaos;

public abstract class Item {
    String name;
    String description;
    int cost;

    public Item(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    abstract void consume(Character c);

    void print() {
        System.out.println(this.name + "\tCost:" + this.cost +  "\tDescription:" + this.description);
    }
}
