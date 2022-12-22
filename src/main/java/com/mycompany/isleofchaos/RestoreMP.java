package com.mycompany.isleofchaos;

public class RestoreMP extends Skill {
    int value;

    public RestoreMP(Character character, String name, String targetType, String description, int mpCost, int value) {
        super(character, name, targetType, description, mpCost);
        this.value = value;
    }

    void perform(){
        Game game = Game.getInstance();
        this.character.changeMP(-mpCost);

        if(targetType.equals("AllTarget")) {
            //perform skill on allies in battle
            for(Character c : game.player.party) {
                c.changeMP(value);
            }
        }
        else if (targetType.equals("SingleTarget")) {
            //choose ally
            Character c = game.player.selectCharacter();
            //perform skill on enemy/ally
            c.changeMP(value);
        }
    }
}
