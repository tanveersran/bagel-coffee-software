/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafx_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class which sets the scene and loads the fxml file.
 * @author Tanveer
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Start method to run the program.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PriceCalculator.fxml"));
        Scene scene = new Scene(root);

        stage.setOnCloseRequest(e -> {
            e.consume(); // consume the close request and handle it manually
            ConfirmBox exitBox = new ConfirmBox("Exit Program", "Are you sure you want to quit?");
            boolean answer = exitBox.confirm();
            if (answer) {
                stage.close();
            }
        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Bruin Bagel House");
        stage.show();

    }

}
