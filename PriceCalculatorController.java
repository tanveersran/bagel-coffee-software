/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

/**
 * Controller class for the main application.
 *
 * @author Tanveer
 */
public class PriceCalculatorController implements Initializable {

    @FXML
    private Spinner<Integer> whiteSpinner;
    @FXML
    private Spinner<Integer> wholeWheatSpinner;
    @FXML
    private Spinner<Integer> regularSpinner;
    @FXML
    private Spinner<Integer> cappucinoSpinner;
    @FXML
    private Spinner<Integer> cafeSpinner;
    @FXML
    private CheckBox cbCreamCheese;
    @FXML
    private CheckBox cbButter;
    @FXML
    private CheckBox cbBlueberry;
    @FXML
    private CheckBox cbRaspberry;
    @FXML
    private CheckBox cbPeachJelly;
    @FXML
    private Label coffeeError;
    @FXML
    private Label labelSubtotal;
    @FXML
    private Label labelSalesTax;
    @FXML
    private Label labelTotal;
    @FXML
    private CheckBox cbWhite;
    @FXML
    private CheckBox cbWholeWheat;
    @FXML
    private CheckBox cbRegular;
    @FXML
    private CheckBox cbCappucino;
    @FXML
    private CheckBox cbCafe;
    @FXML
    private CheckBox cbNoneCoffee;
    @FXML
    private CheckBox cbNoneBagel;
    @FXML
    private Button resetButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button btnCalculate;
    @FXML
    private Button btnPrint;
    @FXML
    private Button btnSave;
    @FXML
    private Menu closeMenu;
    @FXML
    private MenuItem saveReceipt;
    @FXML
    private MenuItem printReceipt;
    @FXML
    private Menu printMenu;
    @FXML
    private MenuItem calculateMenu;
    @FXML
    private MenuItem resetFormMenu;

    // items
    Item whiteBagel;
    Item wholeWheatBagel;
    Item regularCoffee;
    Item cappucinoCoffee;
    Item cafeCoffee;
    Item creamCheeseTopping;
    Item butterTopping;
    Item blueberryTopping;
    Item raspberryTopping;
    Item peachJellyTopping;

    /**
     * This method initializes important values
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // creating items and adding them to ItemList
        whiteBagel = new Item("White Bagel", 1.25);
        ItemList.addBagel(whiteBagel);
        wholeWheatBagel = new Item("Whole Wheat Bagel", 1.50);
        ItemList.addBagel(wholeWheatBagel);

        regularCoffee = new Item("Regular Coffee", 1.25);
        ItemList.addCoffee(regularCoffee);
        cappucinoCoffee = new Item("Cappucino Coffee", 2.00);
        ItemList.addCoffee(cappucinoCoffee);
        cafeCoffee = new Item("Cafe au lait", 1.75);
        ItemList.addCoffee(cafeCoffee);

        creamCheeseTopping = new Item("Cream Cheese", 0.50);
        ItemList.addTopping(creamCheeseTopping);
        butterTopping = new Item("Butter", 0.75);
        ItemList.addTopping(butterTopping);
        blueberryTopping = new Item("Blueberry Jam", 0.75);
        ItemList.addTopping(blueberryTopping);
        raspberryTopping = new Item("Raspberry Jam", 0.75);
        ItemList.addTopping(raspberryTopping);
        peachJellyTopping = new Item("Peach Jelly", 0.75);
        ItemList.addTopping(peachJellyTopping);

        /* This code below adds an event listener to the spinner inputted in the parameters
    which updates the quantity of the item related to the spinner every time the 
    value changes
         */
        whiteSpinner.valueProperty().addListener((ObservableValue<? extends Integer> ov, Integer t, Integer t1) -> {
            whiteBagel.setQuantity(whiteSpinner.getValue());
        });

        wholeWheatSpinner.valueProperty().addListener((ObservableValue<? extends Integer> ov, Integer t, Integer t1) -> {
            wholeWheatBagel.setQuantity(wholeWheatSpinner.getValue());
        });

        regularSpinner.valueProperty().addListener((ObservableValue<? extends Integer> ov, Integer t, Integer t1) -> {
            regularCoffee.setQuantity(regularSpinner.getValue());
        });

        cappucinoSpinner.valueProperty().addListener((ObservableValue<? extends Integer> ov, Integer t, Integer t1) -> {
            cappucinoCoffee.setQuantity(cappucinoSpinner.getValue());
        });

        cafeSpinner.valueProperty().addListener((var ov, var t, var t1) -> {
            cafeCoffee.setQuantity(cafeSpinner.getValue());
        });

        /* Calling method to disable the bagel and coffee spinners,
        and coffee checkboxes by default */
        resetAll();

    }

    /**
     * This method is called when a checkbox of bagel is selected. This method
     * is responsible for setting the quantity of the bagels and
     * enabling/disabling checkboxes.
     *
     * @param event
     *
     */
    @FXML
    private void bagelSelected(ActionEvent event) {
        /* This code calls the bagelSelection method from CheckBoxEvent class
            which enables the spinner and assigns it values once the checkbox 
            is clicked. If checkbox is not selected, it will disable the spinner
            and set the quantity of item to 0 */

        if (event.getSource() == cbWhite) {
            int qty = CheckBoxEvent.bagelSelection(cbWhite, whiteSpinner);
            whiteBagel.setQuantity(qty);
        } else if (event.getSource() == cbWholeWheat) {
            int qty = CheckBoxEvent.bagelSelection(cbWholeWheat, wholeWheatSpinner);
            wholeWheatBagel.setQuantity(qty);
        }

        /* If the "None" checkbox is selected, this will unselect it when any 
        bagel has been selected. */
        if (cbWhite.isSelected() || cbWholeWheat.isSelected()) {
            cbNoneBagel.setSelected(false);
            printMenu.setDisable(false); // enabling the print menu

            CheckBoxEvent.enableCheckBox(cbRegular, cbCappucino, cbCafe);
            CheckBoxEvent.enableCheckBox(cbCreamCheese, cbButter, cbBlueberry,
                    cbRaspberry, cbPeachJelly);
            CheckBoxEvent.enableButton(btnPrint, btnSave);

            if (coffeeError.getOpacity() == 1) {
                coffeeError.setOpacity(0); // hide the error if bagel gets selected
            }
        } else {
            coffeeError.setOpacity(1); // display error if no bagel is selected
            // disabling coffee checkbox selection and spinner
            resetAll();
        }

    }

    /**
     * This method runs when a coffee checkbox is selected. It updates the
     * quantity of the coffee and selects/unselects the checkboxes as required.
     *
     * @param event
     */
    @FXML
    private void coffeeSelected(ActionEvent event) {

        /* This code calls the coffeeSelection method from CheckBoxEvent class
            which enables the spinner and assigns it values once the checkbox 
            is clicked. If checkbox is unselected, this will disable the spinner
            and set items quantity to 0.
         */
        if (event.getSource() == cbRegular) {
            int qty = CheckBoxEvent.coffeeSelection(cbRegular, regularSpinner);
            regularCoffee.setQuantity(qty);
        } else if (event.getSource() == cbCappucino) {
            int qty = CheckBoxEvent.coffeeSelection(cbCappucino, cappucinoSpinner);
            cappucinoCoffee.setQuantity(qty);
        } else if (event.getSource() == cbCafe) {
            int qty = CheckBoxEvent.coffeeSelection(cbCafe, cafeSpinner);
            cafeCoffee.setQuantity(qty);
        }

        /* If the none button is clicked, this code will unselect all coffee
            checkboxes and disable their spinners.
         */

 /* This code sets the "None" checkbox to selected if no coffee is selected
            and in case any coffee is selected, the none checkbox will get unselected.
         */
        if (cbRegular.isSelected() || cbCappucino.isSelected() || cbCafe.isSelected()) {
            cbNoneCoffee.setSelected(false);
        } else { // select "none" checkbox and reset coffee qunatity and cost
            cbNoneCoffee.setSelected(true);
            Price.resetCoffee();
            Price.calcTotal();
        }

    }

    /**
     * This method is called when any checkbox of toppings is clicked. It
     * updates the values of toppings as needed.
     *
     * @param event
     */
    @FXML
    private void toppingsSelected(ActionEvent event) {
        if (event.getSource() == cbCreamCheese) {
            int qty = CheckBoxEvent.toppingSelection(cbCreamCheese);
            creamCheeseTopping.setQuantity(qty);
        }

        if (event.getSource() == cbButter) {
            int qty = CheckBoxEvent.toppingSelection(cbButter);
            butterTopping.setQuantity(qty);
        }

        if (event.getSource() == cbBlueberry) {
            int qty = CheckBoxEvent.toppingSelection(cbBlueberry);
            blueberryTopping.setQuantity(qty);
        }

        if (event.getSource() == cbRaspberry) {
            int qty = CheckBoxEvent.toppingSelection(cbRaspberry);
            raspberryTopping.setQuantity(qty);
        }

        if (event.getSource() == cbPeachJelly) {
            int qty = CheckBoxEvent.toppingSelection(cbPeachJelly);
            peachJellyTopping.setQuantity(qty);
        }

    }

    /**
     * This method is called when the "None" checkbox of bagel or coffee is
     * selected The entire form is reset if bagel "none" checkbox is selected.
     * Coffee "none" selection disables the checkboxes of the coffee.
     *
     * @param event
     */
    @FXML
    private void noneSelected(ActionEvent event) {
        /* This will unselect all bagels if the "None" checkbox is clicked and 
        will disable their spinners.
         */
        if (event.getSource() == cbNoneBagel) {
            resetAll();
        }

        if (event.getSource() == cbNoneCoffee) {
            Price.resetCoffee();
            Price.calcTotal();
            cbNoneCoffee.setSelected(true); // this makes sure the checkbox does not get unselected.
            CheckBoxEvent.unselectCheckBox(cbRegular, cbCappucino, cbCafe);
            CheckBoxEvent.disableCheckBox(cbRegular, cbCappucino, cbCafe);
            CheckBoxEvent.disableSpinner(regularSpinner, cappucinoSpinner, cafeSpinner);
        }

    }

    /**
     * This method is run when calculate button is clicked and calculates and
     * sets the cost labels.
     *
     * @param event
     */
    @FXML
    private void btnCalculate_Click(ActionEvent event) {
        Price.bagelCost();
        Price.toppingCost();
        Price.coffeeCost();

        Price.calcSubtotal();
        Price.calcTax();
        Price.calcTotal();

        labelSubtotal.setText("$" + String.format("%.2f", Price.getSubtotal()));
        labelSalesTax.setText("$" + String.format("%.2f", Price.getTax()));
        labelTotal.setText("$" + String.format("%.2f", Price.getTotal()));
    }

    /**
     * This method is run when the reset button is clicked. It resets the entire
     * form and selects the "none" box of the bagel tab by default.
     *
     * @param event
     */
    @FXML
    private void btnReset_Click(ActionEvent event) {
        resetAll();

        labelSubtotal.setText("$" + String.format("%.2f", Price.getSubtotal()));
        labelSalesTax.setText("$" + String.format("%.2f", Price.getTax()));
        labelTotal.setText("$" + String.format("%.2f", Price.getTotal()));
    }

    /**
     * This method is run when the exit button is clicked. It shows a
     * confirmation dialogue box upon which being confirmed, the program is
     * closed.
     *
     * @param event
     */
    @FXML
    private void btnExit_Click(ActionEvent event) {
        Stage window = (Stage) exitButton.getScene().getWindow();
        ConfirmBox exitBox = new ConfirmBox("Exit Program", "Are you sure you want to quit?");
        boolean answer = exitBox.confirm();
        if (answer) {
            window.close();
        }
    }

    /**
     * This method is run when the print button is clicked and calls the print
     * method to print the receipt.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void btnPrint_Click(ActionEvent event) throws IOException {
        Price.bagelCost();
        Price.toppingCost();
        Price.coffeeCost();

        Price.calcSubtotal();
        Price.calcTax();
        Price.calcTotal();

        Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
        Scene scene = new Scene(root);

        Print.print(root);
    }

    /**
     * This method is called when the save button is clicked or is accessed from
     * the menu. This saves the receipt as a file in the source folder.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void btnSave_Click(ActionEvent event) throws IOException {
        Price.bagelCost();
        Price.toppingCost();
        Price.coffeeCost();

        Price.calcSubtotal();
        Price.calcTax();
        Price.calcTotal();

        Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
        Scene scene = new Scene(root);

        Print.save(root);
    }

    /**
     * This method resets the entire form.
     */
    private void resetAll() {
        // disabling print menu as no items are selected
        printMenu.setDisable(true);

        Price.resetBagels();
        Price.resetToppings();
        Price.resetCoffee();
        Price.resetPrice();
        coffeeError.setOpacity(1); // display error if no bagel is selected
        // disabling coffee checkbox selection and spinner
        cbNoneCoffee.setSelected(true); // set selected coffee value to none.
        cbNoneBagel.setSelected(true);

        //disabling the print menu
        /* Calling methods to disable the bagel and coffee spinners,
        and coffee checkboxes by default */
        CheckBoxEvent.disableCheckBox(cbRegular, cbCappucino, cbCafe);
        CheckBoxEvent.disableSpinner(whiteSpinner, wholeWheatSpinner);
        CheckBoxEvent.disableSpinner(regularSpinner, cappucinoSpinner, cafeSpinner);
        CheckBoxEvent.disableCheckBox(cbCreamCheese, cbButter, cbBlueberry,
                cbRaspberry, cbPeachJelly);
        CheckBoxEvent.unselectCheckBox(cbWhite, cbWholeWheat);
        CheckBoxEvent.unselectCheckBox(cbRegular, cbCappucino, cbCafe);
        CheckBoxEvent.unselectCheckBox(cbCreamCheese, cbButter, cbBlueberry,
                cbRaspberry, cbPeachJelly);
        CheckBoxEvent.disableButton(btnPrint, btnSave);
    }
}
