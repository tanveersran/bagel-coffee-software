/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * This class handles events that occur when selected checkboxes. It sets the
 * spinner values when their corresponding checkboxes are enabled. It has
 * methods to enable/disable checkboxes as required.
 *
 * @author Tanveer
 */
public class CheckBoxEvent {

    private static int maxCoffeeLimit = 10;
    private static int maxBagelLimit = 10;

    /**
     * This method will set the bagel spinner values according to whether the
     * spinner is enabled or not.It returns an int value which is the value of
     * the quantity of the bagel.
     *
     * It adds an event listener to the text field of the spinner which prevents
     * users from entering unwanted values.
     *
     * @param cb
     * @param spinner
     * @return int quantity of the bagel.
     */
    public static int bagelSelection(CheckBox cb, Spinner<Integer> spinner) {
        int qty = 0;
        if (cb.isSelected()) {
            spinner.setDisable(false);
            spinner.getEditor().setText("1");
            SpinnerValueFactory<Integer> spinnerValueFactory
                    = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxBagelLimit);
            spinner.setValueFactory(spinnerValueFactory); // assign the valueFactory to the white bagel.   
            qty = 1; // set quantity to 1

            // preventing users from inputting text
            spinner.getEditor().textProperty().addListener((observable, oldVal, newVal) -> {
                if (!spinner.isDisabled()) { // if spinner is enabled
                    if (!newVal.matches("\\d*") || newVal.matches("")) // check if new value is not a digit or an empty string
                    {
                        spinner.getEditor().setText(oldVal); // set value to previous value if a character is entered or everything is removed
                    }
                }
            });
        } else {
            spinner.setDisable(true);
            spinner.getEditor().setText("");
        }
        return qty;
    }

    /**
     * This method will set the coffee spinner values according to whether the
     * spinner is enabled or not.It returns an int value which is the value of
     * the quantity of the coffee.
     *
     * @param cb
     * @param spinner
     * @return int quantity of coffee selected.
     */
    public static int coffeeSelection(CheckBox cb, Spinner<Integer> spinner) {
        int qty = 0;
        if (cb.isSelected()) {
            spinner.setDisable(false);
            spinner.getEditor().setText("1");
            SpinnerValueFactory<Integer> spinnerValueFactory
                    = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxCoffeeLimit);
            spinner.setValueFactory(spinnerValueFactory); // assign the valueFactory to the white bagel.
            qty = 1;

            // preventing users from inputting text
            spinner.getEditor().textProperty().addListener((observable, oldVal, newVal) -> {
                if (!spinner.isDisabled()) { // if spinner is enabled
                    if (!newVal.matches("\\d*") || newVal.matches("")) // check if new value is not a digit
                    {
                        spinner.getEditor().setText(oldVal); // set value to previous value if a character is entered
                    }
                }
            });

        } else {
            spinner.setDisable(true);
            spinner.getEditor().setText("");
        }
        return qty;
    }

    /**
     * this method returns a value of 0 or 1 depending on whether the topping
     * checkbox is selected or not.
     *
     * @param cb
     * @return
     */
    public static int toppingSelection(CheckBox cb) {
        int qty = 0;
        if (cb.isSelected()) {
            qty = 1;
        }
        return qty;
    }

    /**
     * This is an overloaded method which can take either 2 parameters.It will
     * set the inputted checkboxes to disabled.
     *
     * @param cb1
     * @param cb2
     */
    public static void disableCheckBox(CheckBox cb1, CheckBox cb2) {
        cb1.setDisable(true);
        cb2.setDisable(true);
    }

    /**
     * This is an overloaded method which can take either 3 parameters.It will
     * set the inputted checkboxes to disabled.
     *
     * @param cb1
     * @param cb2
     * @param cb3
     */
    public static void disableCheckBox(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        cb1.setDisable(true);
        cb2.setDisable(true);
        cb3.setDisable(true);
    }

    /**
     * This is an overloaded method which can take either 5 parameters.It will
     * set the inputted checkboxes to disabled.
     *
     * @param cb1
     * @param cb2
     * @param cb3
     * @param cb4
     * @param cb5
     */
    public static void disableCheckBox(CheckBox cb1, CheckBox cb2, CheckBox cb3,
            CheckBox cb4, CheckBox cb5) {
        cb1.setDisable(true);
        cb2.setDisable(true);
        cb3.setDisable(true);
        cb4.setDisable(true);
        cb5.setDisable(true);
    }

    /**
     * This overloaded method takes 2 values which unselects the inputted
     * checkboxes.
     *
     * @param cb1
     * @param cb2
     */
    public static void unselectCheckBox(CheckBox cb1, CheckBox cb2) {
        cb1.setSelected(false);
        cb2.setSelected(false);
    }

    /**
     * This overloaded method takes 3 values which unselects the inputted
     * checkboxes.
     *
     * @param cb1
     * @param cb2
     * @param cb3
     */
    public static void unselectCheckBox(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
    }

    /**
     * This overloaded method takes 5 parameters which unselects the inputted
     * checkboxes.
     *
     * @param cb1
     * @param cb2
     * @param cb3
     * @param cb4
     * @param cb5
     */
    public static void unselectCheckBox(CheckBox cb1, CheckBox cb2, CheckBox cb3,
            CheckBox cb4, CheckBox cb5) {
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb4.setSelected(false);
        cb5.setSelected(false);
    }

    /**
     * This is an overloaded method taking 2 parameters which will set the
     * spinner to disabled and hide its value.
     *
     * @param spinner1
     * @param spinner2
     */
    public static void disableSpinner(Spinner<Integer> spinner1,
            Spinner<Integer> spinner2) {
        spinner1.setDisable(true);
        spinner2.setDisable(true);

        spinner1.getEditor().setText("");
        spinner2.getEditor().setText("");
    }

    /**
     * This is an overloaded method taking 2 parameters which will set the
     * spinners to disabled and hide its value. Parameters are Spinners<Integer>
     *
     * @param spinner1
     * @param spinner2
     * @param spinner3
     */
    public static void disableSpinner(Spinner<Integer> spinner1,
            Spinner<Integer> spinner2, Spinner<Integer> spinner3) {
        spinner1.setDisable(true);
        spinner2.setDisable(true);
        spinner3.setDisable(true);

        spinner1.getEditor().setText("");
        spinner2.getEditor().setText("");
        spinner3.getEditor().setText("");
    }

    /**
     * This method disables the buttons so they cannot be pressed
     *
     * @param button1
     * @param button2
     */
    public static void disableButton(Button button1, Button button2) {
        button1.setDisable(true);
        button2.setDisable(true);
    }

    /**
     * This method enables the buttons to allow them to be pressed
     *
     * @param button1
     * @param button2
     */
    public static void enableButton(Button button1, Button button2) {
        button1.setDisable(false);
        button2.setDisable(false);
    }

    /**
     * This overloaded method enables the checkboxes inputted in the parameters.
     *
     * @param cb1 CheckBox 1
     * @param cb2 CheckBox 2
     * @param cb3 CheckBox 3
     */
    public static void enableCheckBox(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        cb1.setDisable(false);
        cb2.setDisable(false);
        cb3.setDisable(false);
    }

    /**
     * This overloaded method enables the checkboxes inputted in the parameters.
     * It takes 5 parameters, which are all checkboxes.
     *
     * @param cb1
     * @param cb2
     * @param cb3
     * @param cb4
     * @param cb5
     */
    public static void enableCheckBox(CheckBox cb1, CheckBox cb2, CheckBox cb3,
            CheckBox cb4, CheckBox cb5) {
        cb1.setDisable(false);
        cb2.setDisable(false);
        cb3.setDisable(false);
        cb4.setDisable(false);
        cb5.setDisable(false);
    }

    /**
     * This method enables the spinner so its values can be changed and edited
     *
     * @param spinner1
     * @param spinner2
     * @param spinner3
     */
    public static void enableSpinner(Spinner<Integer> spinner1, Spinner<Integer> spinner2,
            Spinner<Integer> spinner3) {
        spinner1.setDisable(false);
        spinner2.setDisable(false);
        spinner3.setDisable(false);
    }

    /**
     * Setters and getters for the max coffee limit.It is set to 10 (maximum) by
     * default
     *
     * @return max coffee limit
     */
    public static int getMaxCoffeeLimit() {
        return maxCoffeeLimit;
    }

    /**
     * Setter for max coffee limit
     *
     * @param maxCoffeeLimit
     */
    public static void setMaxCoffeeLimit(int maxCoffeeLimit) {
        CheckBoxEvent.maxCoffeeLimit = maxCoffeeLimit;
    }

    /**
     * @return maximum bagel limit
     */
    public static int getMaxBagelLimit() {
        return maxBagelLimit;
    }

    /**
     * method to set the maximum bagel limit
     *
     * @param maxBagelLimit
     */
    public static void setMaxBagelLimit(int maxBagelLimit) {
        CheckBoxEvent.maxBagelLimit = maxBagelLimit;
    }

}
