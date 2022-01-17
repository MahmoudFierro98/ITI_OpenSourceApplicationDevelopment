/** 
	Lab 8 - Task 2 - Hello World (Use CSS style sheet.)
	Author: Mahmoud Mohamed Kamal
	Date:   17-01-2022
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

public class HelloCSS extends Application
{
    public HelloCSS()
    {
        System.out.println("@ Constructor() Method: " + Thread.currentThread().getName());
    }
    @Override
    public void init() 
    {
        System.out.println("@ Init() Method: " + Thread.currentThread().getName());
    }
    @Override
    public void stop() 
    {
        System.out.println("@ Stop() Method: " + Thread.currentThread().getName());
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        System.out.println("@ Start() Method: " + Thread.currentThread().getName());
        /* Text */
        Text helloWorld = new Text("Hello World");
        helloWorld.setId("txt");
        Text reflectedHelloWorld = new Text("Hello World");
        reflectedHelloWorld.setId("reflectedTxt");
        /* Background */  
        Rectangle rectangle = new Rectangle(0, 0, 400, 300);
        rectangle.setId("bg");
        /* Create Root branch */
	StackPane root = new StackPane();
        root.getChildren().add(rectangle);
        root.getChildren().add(helloWorld);
        root.getChildren().add(reflectedHelloWorld);
        /* Create scene */
    	Scene scene = new Scene(root, 400, 300);
        /* Load CSS Styles */
        scene.getStylesheets().add(getClass().getResource("Styles.css").toString());
        /* Set title */
	primaryStage.setTitle("Hello World");
	/* Add scene to stage */
	primaryStage.setScene(scene);
        /* Change Layout */
        primaryStage.initStyle(StageStyle.DECORATED);
        /* Start */
        primaryStage.show();
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
