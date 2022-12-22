package com.mycompany.isleofchaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    List<Item> itemList = new ArrayList<>();

    void addItem(Item item) {
        itemList.add(item);
    }

    void removeItem(Item item) {
        itemList.remove(item);
    }

    void printInventory() {
        for(int i = 0; i < itemList.size(); i++) {
            System.out.print(i+1 + ". ");
            itemList.get(i).print();
        }
    }

    Item selectItem() {
        if(!itemList.isEmpty()) {
            printInventory();

            //Select Item index
            Scanner input = new Scanner(System. in);
            System.out.println("Select Item: ");
            String  s = input. nextLine();
            int i = Integer.parseInt(s);

            //return item at input Index in itemList
            return  itemList.get(i-1);
        }
        else {
            System.out.println("Inventory is empty");
            return null;
        }
    }
}
