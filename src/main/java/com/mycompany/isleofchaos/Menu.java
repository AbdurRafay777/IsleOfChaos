package com.mycompany.isleofchaos;

import java.io.*;
import java.util.Scanner;


public class Menu {
    private static Menu menu;

    private Menu() {

    }

    public static Menu getInstance() {
        if(menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    void loadStartMenu() {
        System.out.println("-------ISLE OF CHAOS-------");
        System.out.println("START MENU");
        System.out.println("1. Create new User");
        System.out.println("2. Load User");

        String s = selectOption();

        if(s.equals("1")) {
            createNewUser();
        }
        else {
            loadUser();
        }
    }

    void loadMainMenu() {
        print("MAIN MENU");
        print("1. Play");
        print("2. Shop");
        print("3. Select Team");
        print("4. Change Username");
        print("5. View Stats");
        print("6. Save Game");
        print("7. Back to Start Menu");

        String menuOption = selectOption();

        if(menuOption.equals("1")) {
            playLevel();
        }
        else if(menuOption.equals("2")) {
            goToShop();
        }
        else if(menuOption.equals("3")) {
            selectTeam();
        }
        else if(menuOption.equals("4")) {
            changeUsername();
        }
        else if(menuOption.equals("5")) {
            viewStats();
        }
        else if(menuOption.equals("6")) {
            saveGame();
        }
        else if(menuOption.equals("7")) {
            loadStartMenu();
        }
        else{
            loadMainMenu();
        }

    }

    String selectOption() {
        Scanner input = new Scanner(System.in);
        System.out.print("Option: ");
        String menuOption = input.nextLine();
        return  menuOption;
    }

    void createNewUser() {
        print("Enter username: ");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        Game.getInstance().player.userName = userName;
        selectTeam();
        loadMainMenu();
    }

    void playLevel() {
        Game game = Game.getInstance();
        print("1. Play Level");
        print("2. Back to Main Menu");

        String menuOption = selectOption();

        if(menuOption.equals("1")) {
            game.currentLevel = selectLevel();
            game.currentLevel.startLevel();
        }
        else if(menuOption.equals("2")) {
            loadMainMenu();
        }
        else {
            loadMainMenu();
        }

    }

    void goToShop() {
        Shop.getInstance().loadShopMainMenu();
    }

    void selectTeam() {
        Player player = Game.getInstance().player;
        HeroInitializer HI = HeroInitializer.getInstance();

        print("================SELECT YOUR TEAM================");
        player.resetParty();
        boolean teamSelected = false;
        while(!teamSelected)
        {
            print("CHOOSE A HERO");
            print("1. Warrior");
            print("2. Sorcerer");
            print("3. Assassin");
            print("4. Templar");
            print("5. END TEAM SELECTION");

            String s = selectOption();

            int option = Integer.parseInt(s);

            switch(option) {
                case 1:
                    player.addToParty(HI.getHero("Warrior"));
                    break;
                case 2:
                    player.addToParty(HI.getHero("Sorcerer"));
                    break;
                case 3:
                    player.addToParty(HI.getHero("Assassin"));
                    break;
                case 4:
                    player.addToParty(HI.getHero("Templar"));
                    break;
                default:
                    teamSelected = true;
                    break;
            }

            print("CURRENT TEAM: ");
            for(int i = 0; i < player.party.size(); i++) {
                player.party.get(i).printInfo();
            };

            if(player.party.size() == 3)
                teamSelected = true;
        }
        loadMainMenu();
    }

    Level selectLevel() {
        System.out.println("SELECT LEVEL");
        Game game = Game.getInstance();

        for(int i = 0; i < game.levelList.size(); i++) {
            System.out.println(i+1+ ". Level " + (i+1));
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Select Level: ");
        String  s = input.nextLine();
        int i = Integer.parseInt(s);

        return game.levelList.get(i-1);
    }

    void viewStats() {
        Player p = Game.getInstance().player;
        p.printStats();
        loadMainMenu();
    }

    void changeUsername() {
        Game game = Game.getInstance();
        print("CHANGE USERNAME");
        print("Current Username: " + game.player.userName);
        print("New Username: ");
        Scanner input = new Scanner(System. in);
        String newUsername = input.nextLine();

        game.player.setUserName(newUsername);
        loadMainMenu();
    }

    void saveGame() {
        Player player = Game.getInstance().player;
        String fileName = player.userName + "_saveData.txt";
        String absolutePath = "C:\\Users\\Abdur Rafay\\Documents\\NetBeansProjects\\IsleOfChaos\\src\\main\\java\\com\\mycompany\\" + fileName;
        try(FileWriter fileWriter = new FileWriter(absolutePath)) {
            fileWriter.write(player.userName);
            fileWriter.write("\n");
            fileWriter.write(Integer.toString(player.coins));
            fileWriter.write("\n");
            fileWriter.write(Integer.toString(player.stats.numOfWins));
            fileWriter.write("\n");
            fileWriter.write(Integer.toString(player.stats.numOfLosses));
            fileWriter.write("\n");

            for(int i = 0; i < player.party.size(); i++) {
                fileWriter.write(player.party.get(i).name);
                fileWriter.write("\n");
            }
            fileWriter.write("&");
            print("Data Saved.");
            Game.getInstance().savedUserList.add(player.userName);
        }
        catch (IOException i) {
            print("Could not write to file");
        }
    }

    void loadUser() {
        HeroInitializer HI = HeroInitializer.getInstance();
        Player player = Game.getInstance().player;
        String name = selectSaveSlot();
        if(name != null) {
            String fileName = name + "_saveData.txt";
            String absolutePath = "C:\\Users\\Abdur Rafay\\Documents\\NetBeansProjects\\IsleOfChaos\\src\\main\\java\\com\\mycompany\\" + fileName;

            try(FileReader fileReader = new FileReader(absolutePath)) {
                int ch = fileReader.read();
                String s = "";

                while((char)ch != '\n') {
                    s += (char)ch;
                    ch = fileReader.read();
                }
                //print(s);
                player.userName = s;
                ch = fileReader.read();

                s = "";
                while((char)ch != '\n') {
                    s += (char)ch;
                    ch = fileReader.read();
                }
                //print(s);
                player.coins = Integer.parseInt(s);
                ch = fileReader.read();

                s = "";
                while((char)ch != '\n') {
                    s += (char)ch;
                    ch = fileReader.read();
                }
                //print(s);
                player.stats.numOfWins = Integer.parseInt(s);
                ch = fileReader.read();

                s = "";
                while((char)ch != '\n') {
                    s += (char)ch;
                    ch = fileReader.read();
                }
                //print(s);
                player.stats.numOfLosses = Integer.parseInt(s);

                while((char)ch != '&') {
                    s = "";
                    while((char)ch != '\n') {
                        s += (char)ch;
                        ch = fileReader.read();
                    }
                    player.addToParty(HI.getHero(s));
                    ch = fileReader.read();
                }
                loadMainMenu();
            } catch (FileNotFoundException e) {
                // exception handling
            } catch (IOException e) {
                // exception handling
            }
        }
        else {
            print("No data saved in save slot");
            loadStartMenu();
        }
    }

    //void exitGame() { }

    void print(String s) {
        System.out.println(s);
    }

    String selectSaveSlot() {
        return Game.getInstance().selectSavedUser();
    }
}
