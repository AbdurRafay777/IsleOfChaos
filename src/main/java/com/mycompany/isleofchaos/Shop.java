package com.mycompany.isleofchaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private static Shop shop;
    List<Item> itemListFull;
    List<Item> itemListFiltered;

    private Shop() {
        itemListFull = new ArrayList<>();
        itemListFiltered = new ArrayList<>();
    }

    public static Shop getInstance() {
        if(shop == null)
            shop = new Shop();
        return shop;
    }

    void loadShopMainMenu() {
        System.out.println("===========SHOP===========");
        System.out.println("Coins: " + Game.getInstance().player.coins);
        System.out.println("1. Buy Item");
        System.out.println("2. Sell Item");
        System.out.println("3. Back to Main Menu");

        int option = selectOption();
        switch (option) {
            case 1:
                buyItem();
                break;
            case 2:
                sellItem();
                break;
            case 3:
                Menu.getInstance().loadMainMenu();
                break;
        }
    }

    void buyItem() {
        //choose viewing method
        String option = chooseItemViewingMethod();
        //select item
        Item item = selectItem(option);
        if(option != null) {
            itemListFiltered.clear();
        }
        //decrease money
        if(item != null) {
            Player player = Game.getInstance().player;
            if(player.coins >= item.cost){
                player.coins -= item.cost;
                Inventory inventory = player.inventory;
                inventory.addItem(item);
                System.out.println("Item bought");
                System.out.println("Coins: " + player.coins);
                buyItem();
            }
            else {
                System.out.println("Not Enough Money");
                loadShopMainMenu();
            }
        }
        else{
            loadShopMainMenu();
        }

    }

    void sellItem() {
        //display inventory
        Player player = Game.getInstance().player;
        Inventory inventory = player.inventory;
        //select item
        Item item = inventory.selectItem();
        if(item != null){
            //increase money
            player.coins += (int)(item.cost*0.5);
            //remove from Inventory
            inventory.removeItem(item);
            System.out.println("Item SOLD");
            loadShopMainMenu();
        }
        System.out.println("Cannot sell items");
        loadShopMainMenu();
    }

    String chooseItemViewingMethod() {
        System.out.println("CHOOSE VIEWING METHOD");
        System.out.println("1. Browse All Items");
        System.out.println("2. Browse Items with SubString");
        System.out.println("3. Back");

        int option = selectOption();
        switch (option) {
            case 2:
                Scanner input = new Scanner(System. in);
                System.out.print("Enter substring: ");
                String substr = input.nextLine();
                return substr;
            case 3:
                loadShopMainMenu();
                break;
            default:
                break;
        }
        return null;
    }

    void printAllItemsinShop() {
        for (int i = 0; i < itemListFull.size(); i++) {
            System.out.print(i+1+". ");
            itemListFull.get(i).print();
        }
    }

    boolean printItemsWithSubstring(String s) {
        for (Item item: itemListFull) {
            if(item.name.contains(s)) {
                itemListFiltered.add(item);
            }
        }
        if(itemListFiltered.size() != 0) {
            for(int i = 0; i < itemListFiltered.size(); i++) {
                System.out.print(i+1+". ");
                itemListFiltered.get(i).print();
            }
            return true;
        }
        else{
            System.out.println("No such items exist");
            return false;
        }
    }

    Item selectItem(String str) {
        if(str == null) {
            printAllItemsinShop();

            //Select Item index
            Scanner input = new Scanner(System. in);
            System.out.println("Select Item: ");
            String  s = input. nextLine();
            int i = Integer.parseInt(s);

            //return item at input Index in itemList
            return  itemListFull.get(i-1);
        }
        else {
            if(printItemsWithSubstring(str)){
                Scanner input = new Scanner(System. in);
                System.out.println("Select Item: ");
                String  s = input. nextLine();
                int i = Integer.parseInt(s);

                return  itemListFiltered.get(i-1);
            }
            return null;
        }
    }

    void addItemToShop(Item item) {
        itemListFull.add(item);
    }

    int selectOption() {
        Scanner input = new Scanner(System. in);
        System.out.print("Option: ");
        String menuOption = input.nextLine();
        return Integer.parseInt(menuOption);
    }

}
