/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxnotepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mahmoud kamal
 */
public class JavaFXNotePad extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLDocumentBase(stage);
        
        Scene scene = new Scene(root);
        
	stage.setTitle("Untitled - FX NotePad");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
