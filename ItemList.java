/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

import java.util.ArrayList;

/**
 * This class stores ArrayLists of items created from the Items class. The methods 
 * and fields are static as they are to be accessed through multiple classes and are
 * singleton.
 * 
 * @author Tanveer
 */
public class ItemList {
    static ArrayList<Item> bagelList = new ArrayList();
    static ArrayList<Item> coffeeList = new ArrayList();
    static ArrayList<Item> toppingList = new ArrayList(); 
    
    /**
     * This method adds a bagel Item to the bagelList.
     * @param bagel a bagel item
     */
    public static void addBagel(Item bagel) {
        bagelList.add(bagel);
    }
    /**
     * This method adds a coffee Item to the coffeeList
     * @param coffee a coffee item
     */
    public static void addCoffee(Item coffee) {
        coffeeList.add(coffee);
    }
    
    /**
     * This methods adds a topping to the toppingList
     * @param topping a topping item
     */
    public static void addTopping(Item topping) {
        toppingList.add(topping);
    }
}
