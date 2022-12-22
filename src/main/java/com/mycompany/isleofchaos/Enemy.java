package com.mycompany.isleofchaos;

import java.util.List;

public class Enemy extends Character implements  Cloneable{
    Skill skill;

    public Enemy(String name, String race, String phyWeak, String magWeak, int maxHP, int maxMP, int strength, int defense, int evade) {
        super(name, race, phyWeak, magWeak, maxHP, maxMP, strength, defense, evade);
    }

    public Enemy(Enemy e) {
        super(e);
        this.skill = e.skill;
    }

    void setSkill(Skill s) {
        skill = s;
    }
    void useSkill() {
        //perform Skill
        skill.perform();
    }

    void attack() {
        Game game = Game.getInstance();
        List<Character> party = game.player.party;

        int enemyChoice = (int)(Math.random()*(party.size()));

        Character c = party.get(enemyChoice);
        System.out.println(name + " attacked " + c.name);
        c.changeHP(-strength);
    }

    void useItem() {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Enemy clone = null;
        try
        {
            clone = (Enemy) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }
}
