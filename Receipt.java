/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Label;

/**
 * This class sets the dynamic items of the receipt and prepares the base receipt.
 * @author Tanveer
 */
public class Receipt {
    
    private static int receiptCount; // count the receipt number

    /**
     * static getter to get the receipt count in all classes where it is required.
     * @return 
     */
    public static int getReceiptCount() {
        return receiptCount;
    }
    
    private String items = "";
    private String price = "";
    private double subtotal;
    private double tax;
    private boolean hasToppings; // keep track of toppings
  
   /** 
    * This method adds the item names that are to be ordered and their quantity 
    * to the receipt label. It gets the items from the ItemList class and takes
    * the label where the items are to be added to as a parameter.
    * @param itemsLabel 
    */
    public void setItems(Label itemsLabel) {
        // adding items and quantity to the receipt
        for (Item bagel : ItemList.bagelList) {
            if (bagel.getQuantity() > 0) {
                items += bagel.toString() + "\n";
            }
        }

        items += "Toppings: \n"; // add title for toppings

        for (Item topping : ItemList.toppingList) {
            if (topping.getQuantity() > 0) {
                items += topping.getName() + "(Qty: " + Price.getBagelQty() + ")\n";
                hasToppings = true;
            }
        }

        if (!hasToppings) {
            items += "NO TOPPINGS \n"; // if no toppings are selected, print this.
        }

        for (Item coffee : ItemList.coffeeList) {
            if (coffee.getQuantity() > 0) {
                items += coffee.toString() + "\n";
            }
        }
        itemsLabel.setText(items);

    }

    /**
     * This method sets the individual price of the items added to the receipt
     * @param priceLabel label which holds the price values
     */
    public void setPrice(Label priceLabel) {
        
        // adding subtotal of items to the receipt
        for (Item bagel : ItemList.bagelList) {
            if (bagel.getQuantity() > 0) {
                price += "$" + bagel.getPrice() * bagel.getQuantity() + "\n";
            }
        }
        price += "\n"; // compensate for spacing for toppings title in addItems()
        if (!hasToppings) {
            price += "\n"; // add another space to compensate no toppings text if no toppings are there.
        }
        for (Item topping : ItemList.toppingList) {
            if (topping.getQuantity() > 0) {
                price += "$" + topping.getPrice() * Price.getBagelQty() + "\n";
            }
        }

        for (Item coffee : ItemList.coffeeList) {
            if (coffee.getQuantity() > 0) {
                price += "$" + coffee.getPrice() * coffee.getQuantity() + "\n";
            }
        }
        priceLabel.setText(price);
    }

    /**
     * This method sets the values in the subtotal, tax, and total sections of the receipt.
     * @param subtotal_TaxLabel label having the subtotal and tax column
     * @param totalPriceLabel label having the total price column
     */
    public void setCostBreakdown(Label subtotal_TaxLabel, Label totalPriceLabel) {
        subtotal = Price.getSubtotal();
        tax = Price.getTax();

        subtotal_TaxLabel.setText("$" + String.format("%.2f", subtotal) + "\n"
                + "$" + String.format("%.2f", tax)); //print subtotal and tax with two digits after decimal.

        double totalPrice = subtotal + tax;

        totalPriceLabel.setText("$" + String.format("%.2f", totalPrice)); // print total price by adding subtotal and tax
    }

    /**
     * This is to set the date and time the receipt was generated and set the
     * receipt number as well.
     * @param dateLabel label where the date is to be put
     * @param receiptNoLabel label where the receipt number has to be added
     */
    public void setDateAndReceipt (Label dateLabel, Label receiptNoLabel) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(); // create current date object
        
        dateLabel.setText(formatter.format(date));
        receiptNoLabel.setText("" + receiptCount);
        receiptCount++; // increment the receipt counter.
        
    }

}
