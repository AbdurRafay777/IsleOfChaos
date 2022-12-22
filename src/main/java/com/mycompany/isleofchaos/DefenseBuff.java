package com.mycompany.isleofchaos;

public class DefenseBuff extends Skill{
    int value;

    public DefenseBuff(Character character, String name, String targetType, String description, int mpCost, int value) {
        super(character, name, targetType, description, mpCost);
        this.value = value;
    }

    void perform(){
        Game game = Game.getInstance();

        if(this.character.currMP >= mpCost) {
            this.character.changeMP(-mpCost);
            if (targetType.equals("AllTarget")) {
                //perform skill on allies in battle
                for (Character c : game.player.party) {
                    c.increaseDEF(value);
                }
            } else if (targetType.equals("SingleTarget")) {
                //choose ally
                Character c = game.player.selectCharacter();
                //perform skill on enemy/ally
                c.increaseDEF(value);
            }
        }
        else {
            System.out.println("FAILED TO BUFF DEFENSE");
        }
    }
}
