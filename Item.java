/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

/**
 * This class can create an item with a name, quantity and price.
 *
 * @author Tanveer
 */
public class Item {

    private String name;
    private int quantity;
    private double price;

    /**
     * Constructor taking name and price of item as parameter. 
     * @param name
     * @param price
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    /**
     * Constructor to set name, quantity and price of the item
     * @param name
     * @param quantity
     * @param price 
     */
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    /**
     * toString method which prints the name and quantity of item when 
     * Item object is printed.
     * @return 
     */
    @Override
    public String toString() {
        return name + " (Qty: " + quantity + ")";
    }

}
