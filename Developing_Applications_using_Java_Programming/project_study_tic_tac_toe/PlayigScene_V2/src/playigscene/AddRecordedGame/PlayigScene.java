/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package playigscene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mahmoud kamal
 */
public class PlayigScene extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("PlayingScene.fxml"));
//        PlayingSceneBase root = new PlayingSceneBase("vsComputer", "Fierro_1998", "Computer");
        PlayingSceneBase root = new PlayingSceneBase("RecordedGame", "Fierro_1998", "Computer");
//        root.setRecord("014253786");
        root.setRecord("031485");
        Scene scene = new Scene(root);
        
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
