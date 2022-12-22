package com.mycompany.isleofchaos;

import java.util.List;

public class MagicalAttack extends Skill {
    int damage;
    String element;

    public MagicalAttack(Character character, String name, String targetType, String description, int mpCost, String element,  int damage) {
        super(character, name, targetType, description, mpCost);
        this.element = element;
        this.damage = damage;
    }

    void perform(){
        Game game = Game.getInstance();

        if(this.character.currMP >= mpCost) {
            this.character.changeMP(-mpCost);

            if(targetType.equals("AllTarget")) {
                //perform skill on enemies/allies in battle
                for(Enemy e : game.currentLevel.getEnemyParty()) {
                    if(e.magWeak.equals(this.element))
                        e.changeHP((-2*damage*character.strength)+e.defense);
                    else
                        e.changeHP((-damage*character.strength)+e.defense);
                }
            }
            else if (targetType.equals("SingleTarget")) {
                //choose enemy/ally
                Enemy e = game.currentLevel.selectEnemy();

                //perform skill on enemy/ally
                if(e.magWeak.equals(this.element))
                    e.changeHP((-2*damage*character.strength)+e.defense);
                else
                    e.changeHP((-damage*character.strength)+e.defense);
            }
        }
        else {
            System.out.println("FAILED TO PERFORM SKILL");
        }
    }
}
