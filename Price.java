/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

/**
 * This class calculates the price of the bagels, toppings and coffee. It accesses
 * the quantities and cost of the items from ItemList dynamically. It follows the principle
 * of loose coupling, so any addition or deletion in ItemList will not affect this class.
 * 
 * It can calculate the cost and tax of the items.
 * 
 * @author Tanveer
 */
public class Price {
    // qty
    private static int bagelQty;
    
    // cost
    private static double bagelCost;
    private static double toppingCost;
    private static double coffeeCost;
    
    private static double subtotal;
    private static double tax;
    private static double total;

    private static double taxPercent = 13;


    public static void bagelCost() {
        double cost = 0;
        int qty = 0;
        
        for (Item bagel: ItemList.bagelList) {
         qty += bagel.getQuantity(); // storing total bagel quantity to use in toppingCost()       
         cost += bagel.getQuantity() * bagel.getPrice();
        }
        bagelCost = cost;
        bagelQty = qty;
    }
    
    public static void coffeeCost() {
        double cost = 0;
        for (Item coffee: ItemList.coffeeList) {
         cost += coffee.getQuantity() * coffee.getPrice();
        }
        coffeeCost = cost;
    }
    
    public static void toppingCost() {
        double cost = 0;
        for (Item topping: ItemList.toppingList) {
         cost += topping.getQuantity() * topping.getPrice() * bagelQty ;
        }
        toppingCost = cost;
    }
    
    public static double calcSubtotal() {
        subtotal = bagelCost + coffeeCost + toppingCost;
        return subtotal;
    }

    public static double calcTax() {
        tax = (subtotal * taxPercent) / 100;
        return tax;
    }

    public static  double calcTotal() {
        calcSubtotal();
        calcTax();
        total = subtotal+tax;
        return total;
    }
    
    
    public static void resetBagels() {
        for (Item bagel: ItemList.bagelList) {
         bagel.setQuantity(0);
        }
    }
    
    public static void resetCoffee() {
        for (Item coffee: ItemList.coffeeList) {
         coffee.setQuantity(0);
        }
    }
    
    public static void resetToppings() {
          for (Item topping: ItemList.toppingList) {
         topping.setQuantity(0);
        }
    }
    
    public static void resetPrice() {
        bagelCost = 0;
        toppingCost = 0;
        coffeeCost = 0;
        
        subtotal = 0;
        tax = 0;
        total = 0;
    }

    
    public static double getSubtotal() {
        return subtotal;
    }

    public static double getTax() {
        return tax;
    }

    public static double getTotal() {
        return total;
    }

    public static int getBagelQty() {
        return bagelQty;
    }
    
    public static double getTaxPercent() {
        return taxPercent;
    }

  
}
