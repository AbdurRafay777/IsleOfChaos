package com.mycompany.isleofchaos;

public class LifeSteal extends Skill {
    int damage;

    public LifeSteal(Character character, String name, String targetType, String description, int mpCost,  int damage) {
        super(character, name, targetType, description, mpCost);
        this.damage = damage;
    }

    void perform(){
        //choose enemy/ally
        Game game = Game.getInstance();
        Enemy enemy = game.currentLevel.selectEnemy();

        //perform skill on enemy/ally
        if(this.character.currMP >= mpCost) {
            this.character.changeMP(-mpCost);
            enemy.changeHP(-damage);
            this.character.changeHP(damage);
        }
        else {
            System.out.println("FAILED TO PERFORM SKILL");
        }

    }
}
