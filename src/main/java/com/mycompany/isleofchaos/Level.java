package com.mycompany.isleofchaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level {
    List<Enemy> enemyList;
    List<Enemy> enemyParty;
    static int currentIndex = 0;

    Level() {
        enemyList = new ArrayList<>();
        enemyParty = new ArrayList<>();
    }

    void addToEnemyList(Enemy e) {
        enemyList.add(e);
    }

    void initEnemyParty() {
        for(int i = 0; i < enemyList.size(); i++) {
            if(currentIndex < enemyList.size())
                enemyParty.add(new Enemy(enemyList.get(currentIndex++)));
            else
                break;
        }
    }

    void playerTurn(int x) {
        System.out.println("PLAYER TURN");
        //get currentPlayerCharacter
        Game game = Game.getInstance();
        System.out.println("===========================PLAYER PARTY===========================");
        game.player.printParty();
        System.out.println("===========================ENEMY PARTY===========================");
        printEnemyParty();

        Character c = game.player.party.get(x);
        System.out.println(c.name + "'s Turn");

        //print 4 options
        printPlayerTurnMenu();

        //get option selected by player
        Scanner input = new Scanner(System. in);
        System.out.println("Select option: ");
        String  s = input. nextLine();
        int i = Integer.parseInt(s);

        switch (i) {
            case 1:
                c.attack();
                break;
            case 2:
                c.defend();
                break;
            case 3:
                c.useSkill();
                break;
            case 4:
                c.useItem();
                break;
            default:
                System.out.println("No such option");
        }
    }

    void printPlayerTurnMenu() {
        System.out.println("OPTIONS: ");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Use Skill");
        System.out.println("4. Use Item");
    }

    void enemyTurn(int x) {
        System.out.println("ENEMY TURN");

        Enemy e = enemyParty.get(x);
        int enemyAction = (int)(Math.random()*(2));
        if(enemyAction == 0) {
            e.attack();
        }
        else {
            e.useSkill();
        }

    }

    void startLevel() {
        while(currentIndex < enemyList.size()) {
            initEnemyParty();
            startBattle();
            System.out.println("Battle Finished.");
        }
        System.out.println("Level Complete!");
        currentIndex = 0;
        resetCharacterStats();
        Menu.getInstance().loadMainMenu();
    }

    void startBattle() {
        Player p = Game.getInstance().player;
        List<Character> playerParty = p.party;

        while(enemyParty.size() > 0 && playerParty.size() > 0) {

            for(int i = 0; i < playerParty.size(); i++){
                playerTurn(i);
                updateEnemyParty();
                if(enemyPartyEmpty()){
                    System.out.println("YOU WON!!");
                    p.stats.increaseNumOfWins();
                    break;
                }
            }

            for(int i = 0; i < enemyParty.size(); i++) {
                enemyTurn(i);
                updatePlayerParty();
                if(playerPartyEmpty()){
                    System.out.println("YOU LOST");
                    p.stats.increaseNumOfLosses();
                    break;
                };
            }
        }
    }

    Enemy selectEnemy() {
        printEnemyParty();
        Scanner input = new Scanner(System. in);
        System.out.println("Select enemy: ");
        String  s = input. nextLine();
        int i = Integer.parseInt(s);

        return enemyParty.get(i-1);
    }

    List<Enemy> getEnemyParty() {
        return enemyParty;
    }

    void printEnemyParty() {
        for (int i = 0; i < enemyParty.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.print(enemyParty.get(i).name + "\n HP: " + enemyParty.get(i).currHP + " /" + enemyParty.get(i).maxHP + "\n");
        }
    }

    void updateEnemyParty() {
        for(int i = 0 ; i < enemyParty.size(); i++) {
            if(enemyParty.get(i).isAlive() == false) {
                System.out.println(enemyParty.get(i).name + " DIED");
                Game.getInstance().player.coins += enemyParty.get(i).maxHP;
                enemyParty.remove(i);
                i--;
            }

        }

    }

    void updatePlayerParty() {
        List<Character> playerParty = Game.getInstance().player.party;
        for(int i = 0 ; i < playerParty.size(); i++) {
            if(playerParty.get(i).isAlive() == false) {
                System.out.println(playerParty.get(i).name + " DIED");
                playerParty.remove(i);
                i--;
            }
        }

    }

    boolean enemyPartyEmpty() {
        return enemyParty.isEmpty();
    }

    boolean playerPartyEmpty() {
        return Game.getInstance().player.party.isEmpty();
    }

    void resetCharacterStats(){
        List<Character> playerParty = Game.getInstance().player.party;
        for (Character c: playerParty) {
            c.currHP = c.maxHP;
            c.currMP = c.maxMP;
        }
    }


}
