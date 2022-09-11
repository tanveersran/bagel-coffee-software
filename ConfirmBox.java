/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class can create a dialogue box which returns a boolean value after
 * asking for a user response on whether to accept something or deny it.
 *
 * @author Tanveer
 */
public class ConfirmBox {

    private String title;
    private String message;
    private boolean answer;

    /**
     * Constructor taking parameters of title and message.
     *
     * @param title
     * @param message
     */
    ConfirmBox(String title, String message) {
        this.title = title;
        this.message = message;
    }

    /**
     * This method displays an alert window which asks the user to select from
     * two buttons, confirm and deny.It returns a boolean value of true or false
     * depending on users selection.
     *
     * @return boolean value true if user clicks confirm and false if deny is
     * clicked.
     */
    public boolean confirm() {
        Stage window = new Stage();
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        window.initModality(Modality.APPLICATION_MODAL); // prevents another windows from being clickable
        Button confirmButton = new Button("Confirm");
        Button denyButton = new Button("Deny");

        confirmButton.setOnAction(e -> {
            answer = true; // return value as true if user clicks confirm button
            window.close();
        });
        denyButton.setOnAction(e -> {
            answer = false; // return value as false if user clicks deny button
            window.close();
        });

        Label infoLabel = new Label(message); // set label to display a custom message created through object.

        layout.getChildren().addAll(infoLabel, confirmButton, denyButton);
        layout.setAlignment(Pos.CENTER);
        layout.setMinWidth(250);

        window.setResizable(false);
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait();
        return answer;
    }
}
