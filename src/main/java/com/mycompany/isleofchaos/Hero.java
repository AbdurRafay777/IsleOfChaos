package com.mycompany.isleofchaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hero extends Character {
    List<Skill> skillList;

    public Hero(String name, String race, String phyWeak, String magWeak, int maxHP, int maxMP, int strength, int defense, int evade) {
        super(name, race, phyWeak, magWeak, maxHP, maxMP, strength, defense, evade);
        skillList = new ArrayList<>();
    }

    void addSkill(Skill skill) {
        skillList.add(skill);
    }

    void printSkillList() {
        for(int i = 0; i < skillList.size(); i++) {
            System.out.print(i+1+" . ");
            skillList.get(i).print();
        }
    }

    void attack() {
        Game game = Game.getInstance();
        Enemy e = game.currentLevel.selectEnemy();
        e.changeHP(-strength);
    }

    void useSkill() {
        //open skillList
        printSkillList();

        //choose skill
        Scanner input = new Scanner(System. in);
        System.out.println("Select skill: ");
        String  s = input. nextLine();
        int i = Integer.parseInt(s);

        if(i<=skillList.size() && i > 0) {
            //perform
            skillList.get(i-1).perform();
        }

        else {
            System.out.println("no such skill");
        }

    }

    void useItem() {
        //open Inventory
        Game game = Game.getInstance();
        Inventory inventory = game.player.inventory;

        //choose item
        Item item = inventory.selectItem();

        if(item != null) {
            //choose character to use it on
            Character c = game.player.selectCharacter();

            //use Item
            item.consume(c);
        }
    }
}
