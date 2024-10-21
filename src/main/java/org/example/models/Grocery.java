package org.example.models;

import org.junit.platform.engine.support.descriptor.FileSystemSource;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.transform.SourceLocator;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int choice;
        do {
            System.out.println("Yapılacak işlemi seçin. (0: Çıkış, 1: Ekleme, 2: Çıkarma)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Eklenecek elemanı giriniz.");
                    String itemsAdded = scanner.nextLine();
                    addItems(itemsAdded);
                    printSorted();
                    break;

                case 2:
                    System.out.println("Çıkarılacak elemanı giriniz.");
                    String itemsRemoved = scanner.nextLine();
                    removeItems(itemsRemoved);
                    printSorted();
                    break;
            }
        }  while (choice != 0);
        scanner.close();
    }

    public static void removeItems(String itemsRemoved) {
        String [] splitItems = itemsRemoved.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if(!checkItemsInList(item)) {
                System.out.println("Girilen değer listede bulunmuyor: " + item);
            } else {
                groceryList.remove(item);
            }
        }

    }

    public static void addItems(String itemsAdded) {
       String[] splitted =  itemsAdded.split(",");
       for(String item : splitted) {
           item = item.trim();
           if(checkItemsInList(item)) {
               System.out.println("Girilen değer listede bulunuyor: " + item);
           } else {
               groceryList.add(item);
           }
       }
       sortItems();
    }

    public static boolean checkItemsInList(String item) {
        return groceryList.contains(item);
    }

   public static void printSorted() {
        sortItems();
        System.out.println("Mevcut liste: ");
        for (String item: groceryList) {
            System.out.println(item);
        }
   }

   public static void sortItems() {
       Collections.sort(groceryList);
   }
}
