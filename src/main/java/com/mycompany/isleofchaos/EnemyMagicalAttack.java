package com.mycompany.isleofchaos;

import java.util.List;

public class EnemyMagicalAttack extends Skill {
    int damage;
    String element;

    public EnemyMagicalAttack(Character character, String name, String targetType, String description, int mpCost, String element, int damage) {
        super(character, name, targetType, description, mpCost);
        this.damage = damage;
        this.element = element;
    }

    @Override
    void perform() {
        Game game = Game.getInstance();
        List<Character> party = game.player.party;

        if(targetType.equals("SingleTarget")) {
            int enemyChoice = (int)(Math.random()*(party.size()));
            Character c = party.get(enemyChoice);
            System.out.println(character.name + " used " + this.name + " on " + c.name);

            if(c.magWeak.equals(element))
                c.changeHP((-2*damage*character.strength)+c.defense);
            else
                c.changeHP((-damage*character.strength)+c.defense);
        }
        else if(targetType.equals("AllTarget")) {
            System.out.println(character.name + " used " + this.name + " on Player Party");

            for(Character c : party) {
                if(c.magWeak.equals(element))
                    c.changeHP((-2*damage*character.strength)+c.defense);
                else
                    c.changeHP((-damage*character.strength)+c.defense);
            }
        }

    }
}
