/** 
	Lab 8 - Task 1 - Hello World (Use JavaFX code [ Reflection , LinearGradient])
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

public class Hello extends Application
{
    public Hello()
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
        helloWorld.setFill(Color.RED);
        helloWorld.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50.0));
        /* Reflection */
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        helloWorld.setEffect(reflection);
        /* Gradient Background */  
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE), new Stop(1, Color.BLACK)};
        LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        Rectangle rectangle = new Rectangle(0, 0, 400, 300);
        rectangle.setFill(linearGradient);
        /* Create Root branch */
		StackPane root = new StackPane();
        root.getChildren().add(rectangle);
        root.getChildren().add(helloWorld);
        /* Create scene */
		Scene scene = new Scene(root, 400, 300);
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