package com.mycompany.isleofchaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Game game = null;
    List<Level> levelList;
    Level currentLevel;
    Shop shop;
    Player player;
    List<String> savedUserList;

    private Game() {
        player = new Player();
        shop = Shop.getInstance();
        levelList = new ArrayList<>();
        savedUserList = new ArrayList<>();
    }

    public static Game getInstance() {
        if(game == null)
            game = new Game();
        return game;
    }

    void addLevel(Level level) {
        levelList.add(level);
    }

    void run() {
        Menu.getInstance().loadStartMenu();
    }

    void print(String s) {
        System.out.println(s);
    }

    void printSavedUserList() {
        for(int i = 0 ; i < savedUserList.size(); i++) {
            System.out.println(i+1 + ". " + savedUserList.get(i));
        }
    }

    String selectSavedUser() {
        printSavedUserList();

        Scanner input = new Scanner(System. in);
        System.out.print("Select user: ");
        String  s = input. nextLine();
        int i = Integer.parseInt(s);

        if(i <= savedUserList.size())
            return savedUserList.get(i-1);
        return null;
    }
}
