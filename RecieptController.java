/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafx_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class for Receipt. 
 *
 * @author Tanveer
 */
public class RecieptController implements Initializable {

    @FXML
    private Label itemsLabel;
    @FXML
    private Label receiptNoLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label costLabel; // subtotal of each item
    @FXML
    private Label costBreakdownLabel; // subtotal breakdown by subtotal and tax
    @FXML
    private Label totalCostLabel; // total subtotal by adding tax and subtotal
    
    
    /**
     * Initializes the controller class by calling methods that replaces the
     * placeholders with values and names of items ordered.Also increments the
 receipt number count and prints the current date and time at the bottom.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Receipt newReceipt = new Receipt();
        
        newReceipt.setItems(itemsLabel);
        newReceipt.setPrice(costLabel);
        newReceipt.setCostBreakdown(costBreakdownLabel, totalCostLabel);
        newReceipt.setDateAndReceipt(dateLabel, receiptNoLabel);
        

    }
}
