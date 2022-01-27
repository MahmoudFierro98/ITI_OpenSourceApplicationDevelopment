package playigscene;

import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.web.*;
import java.lang.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PlayingSceneBase extends AnchorPane {

    protected final Group group;
    protected final Button button;
    protected final Button button0;
    protected final Group group0;
    protected final Circle circle;
    protected final Label label;
    protected final Group group1;
    protected final Label label0;
    protected final Label label1;
    protected final Group group2;
    protected final Circle circle0;
    protected final Label label2;
    protected final Group group3;
    protected final Label label3;
    protected final Label label4;
    protected final Group group4;
    protected final Rectangle rectangle;
    protected final Button playButton1;
    protected final Button playButton2;
    protected final Button playButton3;
    protected final Button playButton4;
    protected final Button playButton5;
    protected final Button playButton6;
    protected final Button playButton7;
    protected final Button playButton8;
    protected final Button playButton9;
    protected final Separator separator;
    protected final Separator separator0;
    protected final Separator separator1;
    protected final Separator separator2;
    protected final Group group5;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;

    /* Turn X or O flag */
    private boolean turnX = true;
    /* Win Flag check winnig cases */
    private boolean winFlag = false;
    /* Save record of the game and to check the state of winnig cases */
    private char[][] state = new char[3][3];
    private int counter = 0;
    private int value;
    /* Pressed Flags for play buttons */
    private boolean playButton1Pressed = false;
    private boolean playButton2Pressed = false;
    private boolean playButton3Pressed = false;
    private boolean playButton4Pressed = false;
    private boolean playButton5Pressed = false;
    private boolean playButton6Pressed = false;
    private boolean playButton7Pressed = false;
    private boolean playButton8Pressed = false;
    private boolean playButton9Pressed = false;
    
    private void checkState()
    {
        counter++;
        if(((state[0][0] == state[0][1]) && (state[0][0] == state[0][2])) || ((state[0][0] == state[1][0]) && (state[0][0] == state[2][0])))
        {
            if(state[0][0] == 'x')
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "X WIN");
                alert.show();
                winFlag = true;
            }
            else if(state[0][0] == 'o')
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "O WIN");
                alert.show();
                winFlag = true;
            }
        }
        if(((state[1][0] == state[1][1]) && (state[1][1] == state[1][2])) || ((state[1][1] == state[0][1]) && (state[1][1] == state[2][1]))
        || ((state[0][0] == state[1][1]) && (state[1][1] == state[2][2])) || ((state[1][1] == state[2][0]) && (state[1][1] == state[0][2])))
        {
            if(state[1][1] == 'x')
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "X WIN");
                alert.show();
                winFlag = true;
            }
            else if(state[1][1] == 'o')
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "O WIN");
                alert.show();
                winFlag = true;
            }
        }
        if(((state[2][0] == state[2][2]) && (state[2][2] == state[2][1])) || ((state[2][2] == state[0][2]) && (state[2][2] == state[1][2])))
        {
            if(state[2][2] == 'x')
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "X WIN");
                alert.show();
                winFlag = true;
            }
            else if(state[2][2] == 'o')
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "O WIN");
                alert.show();
                winFlag = true;
            }
        }
        if((counter == 9) && !winFlag)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Draw");
            alert.show();
        }
        play();
    }

    public PlayingSceneBase() 
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                state[i][j] = 'z';
            }         
        }

        group = new Group();
        button = new Button();
        button0 = new Button();
        group0 = new Group();
        circle = new Circle();
        label = new Label();
        group1 = new Group();
        label0 = new Label();
        label1 = new Label();
        group2 = new Group();
        circle0 = new Circle();
        label2 = new Label();
        group3 = new Group();
        label3 = new Label();
        label4 = new Label();
        group4 = new Group();
        rectangle = new Rectangle();
        playButton1 = new Button();
        playButton2 = new Button();
        playButton3 = new Button();
        playButton4 = new Button();
        playButton5 = new Button();
        playButton6 = new Button();
        playButton7 = new Button();
        playButton8 = new Button();
        playButton9 = new Button();
        separator = new Separator();
        separator0 = new Separator();
        separator1 = new Separator();
        separator2 = new Separator();
        group5 = new Group();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(800.0);
        setScaleShape(false);
        setStyle("-fx-background-color: linear-gradient(#37077B, #FDB8A5);");

        button.setLayoutX(18.0);
        button.setLayoutY(17.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(47.0);
        button.setPrefWidth(117.0);
        button.setStyle("-fx-background-color: #E4A593; -fx-background-radius: 20px;");
        button.setText("Home");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("System Bold", 15.0));

        button0.setLayoutX(18.0);
        button0.setLayoutY(80.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(47.0);
        button0.setPrefWidth(117.0);
        button0.setStyle("-fx-background-color: #E4A593; -fx-background-radius: 20px;");
        button0.setText("Log out");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("System Bold", 15.0));

        group0.setLayoutX(21.0);

        circle.setFill(javafx.scene.paint.Color.WHITE);
        circle.setLayoutX(132.0);
        circle.setLayoutY(273.0);
        circle.setRadius(79.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#e4a593"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle.setStrokeWidth(15.0);

        label.setLayoutX(105.0);
        label.setLayoutY(214.0);
        label.setText("X");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e4a593"));
        label.setFont(new Font("System Bold", 80.0));

        group1.setLayoutX(21.0);

        label0.setLayoutX(22.0);
        label0.setLayoutY(358.0);
        label0.setStyle("-fx-background-color: #e4a593;");
        label0.setText("Player1_Name");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 34.0));

        label1.setLayoutX(84.0);
        label1.setLayoutY(408.0);
        label1.setText("50 Points");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 24.0));

        group2.setLayoutX(516.0);

        circle0.setFill(javafx.scene.paint.Color.WHITE);
        circle0.setLayoutX(128.0);
        circle0.setLayoutY(273.0);
        circle0.setRadius(79.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#5b3379"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle0.setStrokeWidth(15.0);

        label2.setLayoutX(98.0);
        label2.setLayoutY(214.0);
        label2.setText("O");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#5b3379"));
        label2.setFont(new Font("System Bold", 80.0));

        group3.setLayoutX(508.0);

        label3.setLayoutX(22.0);
        label3.setLayoutY(358.0);
        label3.setStyle("-fx-background-color: #5b3379;");
        label3.setText("Player2_Name");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font("System Bold", 34.0));

        label4.setLayoutX(84.0);
        label4.setLayoutY(408.0);
        label4.setText("50 Points");
        label4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setFont(new Font("System Bold", 24.0));

        group4.setLayoutX(-18.0);
        group4.setLayoutY(-35.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#2626267a"));
        rectangle.setHeight(319.0);
        rectangle.setLayoutX(175.0);
        rectangle.setLayoutY(502.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(487.0);

        playButton1.setLayoutX(176.0);
        playButton1.setLayoutY(502.0);
        playButton1.setMnemonicParsing(false);
        playButton1.setPrefHeight(104.0);
        playButton1.setPrefWidth(161.0);
        playButton1.setStyle("-fx-background-color: transparent;");
        playButton1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        //playButton1.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        playButton1.setFont(new Font("System Bold", 48.0));

        playButton2.setLayoutX(340.0);
        playButton2.setLayoutY(502.0);
        playButton2.setMnemonicParsing(false);
        playButton2.setPrefHeight(104.0);
        playButton2.setPrefWidth(161.0);
        playButton2.setStyle("-fx-background-color: transparent;");
        playButton2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playButton2.setFont(new Font("System Bold", 48.0));

        playButton3.setLayoutX(501.0);
        playButton3.setLayoutY(502.0);
        playButton3.setMnemonicParsing(false);
        playButton3.setPrefHeight(104.0);
        playButton3.setPrefWidth(161.0);
        playButton3.setStyle("-fx-background-color: transparent;");
        playButton3.setFont(new Font("System Bold", 48.0));

        playButton4.setLayoutX(176.0);
        playButton4.setLayoutY(608.0);
        playButton4.setMnemonicParsing(false);
        playButton4.setPrefHeight(104.0);
        playButton4.setPrefWidth(161.0);
        playButton4.setStyle("-fx-background-color: transparent;");
        playButton4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playButton4.setFont(new Font("System Bold", 48.0));

        playButton5.setLayoutX(340.0);
        playButton5.setLayoutY(608.0);
        playButton5.setMnemonicParsing(false);
        playButton5.setPrefHeight(104.0);
        playButton5.setPrefWidth(161.0);
        playButton5.setStyle("-fx-background-color: transparent;");
        playButton5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playButton5.setFont(new Font("System Bold", 48.0));

        playButton6.setLayoutX(501.0);
        playButton6.setLayoutY(608.0);
        playButton6.setMnemonicParsing(false);
        playButton6.setPrefHeight(104.0);
        playButton6.setPrefWidth(161.0);
        playButton6.setStyle("-fx-background-color: transparent;");
        playButton6.setFont(new Font("System Bold", 48.0));

        playButton7.setLayoutX(176.0);
        playButton7.setLayoutY(714.0);
        playButton7.setMnemonicParsing(false);
        playButton7.setPrefHeight(104.0);
        playButton7.setPrefWidth(161.0);
        playButton7.setStyle("-fx-background-color: transparent;");
        playButton7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        //playButton7.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        playButton7.setFont(new Font("System Bold", 48.0));

        playButton8.setLayoutX(339.0);
        playButton8.setLayoutY(714.0);
        playButton8.setMnemonicParsing(false);
        playButton8.setPrefHeight(104.0);
        playButton8.setPrefWidth(161.0);
        playButton8.setStyle("-fx-background-color: transparent;");
        playButton8.setFont(new Font("System Bold", 48.0));

        playButton9.setLayoutX(501.0);
        playButton9.setLayoutY(714.0);
        playButton9.setMnemonicParsing(false);
        playButton9.setPrefHeight(104.0);
        playButton9.setPrefWidth(161.0);
        playButton9.setStyle("-fx-background-color: transparent;");
        playButton9.setFont(new Font("System Bold", 48.0));

        separator.setLayoutX(176.0);
        separator.setLayoutY(605.0);
        separator.setPrefHeight(0.0);
        separator.setPrefWidth(486.0);
        separator.setStyle("-fx-background-color: white;");

        separator0.setLayoutX(176.0);
        separator0.setLayoutY(711.0);
        separator0.setPrefHeight(0.0);
        separator0.setPrefWidth(486.0);
        separator0.setStyle("-fx-background-color: white;");

        separator1.setLayoutX(337.0);
        separator1.setLayoutY(503.0);
        separator1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator1.setPrefHeight(316.0);
        separator1.setPrefWidth(0.0);
        separator1.setStyle("-fx-background-color: white;");

        separator2.setLayoutX(498.0);
        separator2.setLayoutY(502.0);
        separator2.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator2.setPrefHeight(316.0);
        separator2.setPrefWidth(0.0);
        separator2.setStyle("-fx-background-color: white;");

        group5.setLayoutX(42.0);
        group5.setLayoutY(1.0);

        label5.setLayoutX(678.0);
        label5.setText("O");
        label5.setTextFill(javafx.scene.paint.Color.WHITE);
        label5.setFont(new Font("System Bold", 64.0));

        label6.setLayoutX(636.0);
        label6.setText("X");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#e4a593"));
        label6.setFont(new Font("System Bold", 64.0));

        label7.setLayoutX(678.0);
        label7.setLayoutY(50.0);
        label7.setText("O");
        label7.setTextFill(javafx.scene.paint.Color.valueOf("#e4a593"));
        label7.setFont(new Font("System Bold", 64.0));

        label8.setLayoutX(636.0);
        label8.setLayoutY(50.0);
        label8.setText("X");
        label8.setTextFill(javafx.scene.paint.Color.WHITE);
        label8.setFont(new Font("System Bold", 64.0));

        group.getChildren().add(button);
        group.getChildren().add(button0);
        getChildren().add(group);
        group0.getChildren().add(circle);
        group0.getChildren().add(label);
        getChildren().add(group0);
        group1.getChildren().add(label0);
        group1.getChildren().add(label1);
        getChildren().add(group1);
        group2.getChildren().add(circle0);
        group2.getChildren().add(label2);
        getChildren().add(group2);
        group3.getChildren().add(label3);
        group3.getChildren().add(label4);
        getChildren().add(group3);
        group4.getChildren().add(rectangle);
        group4.getChildren().add(playButton1);
        group4.getChildren().add(playButton2);
        group4.getChildren().add(playButton3);
        group4.getChildren().add(playButton4);
        group4.getChildren().add(playButton5);
        group4.getChildren().add(playButton6);
        group4.getChildren().add(playButton7);
        group4.getChildren().add(playButton8);
        group4.getChildren().add(playButton9);
        group4.getChildren().add(separator);
        group4.getChildren().add(separator0);
        group4.getChildren().add(separator1);
        group4.getChildren().add(separator2);
        getChildren().add(group4);
        group5.getChildren().add(label5);
        group5.getChildren().add(label6);
        group5.getChildren().add(label7);
        group5.getChildren().add(label8);
        getChildren().add(group5);

        play();
    }

    private void play()
    {
        if(!winFlag)
        {
            playButton1.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton1Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton1);
                        state[0][0] = 'x';
                    }
                    else
                    {
                        playY(playButton1);
                        state[0][0] = 'o';
                    }
                    //playButton1.setDisable(true);
                    playButton1Pressed = true;
                    checkState();
                    System.out.println("playButton1: "+state[0][0]);
                }
            });

            playButton2.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton2Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton2);
                        state[0][1] = 'x';
                    }
                    else
                    {
                        playY(playButton2);
                        state[0][1] = 'o';
                    }
                    //playButton2.setDisable(true);
                    playButton2Pressed = true;
                    checkState();
                    System.out.println("playButton2: "+state[0][1]);
                }
            });

            playButton3.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton3Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton3);
                        state[0][2] = 'x';
                    }
                    else
                    {
                        playY(playButton3);
                        state[0][2] = 'o';
                    }
                    //playButton3.setDisable(true);
                    playButton3Pressed = true;
                    checkState();
                    System.out.println("playButton3: "+state[0][2]);
                }
            }); 

            playButton4.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton4Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton4);
                        state[1][0] = 'x';
                    }
                    else
                    {
                        playY(playButton4);
                        state[1][0] = 'o';
                    }
                    //playButton4.setDisable(true);
                    playButton4Pressed = true;
                    checkState();
                    System.out.println("playButton4: "+state[1][0]);
                }
            });

            playButton5.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton5Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton5);
                        state[1][1] = 'x';
                    }
                    else
                    {
                        playY(playButton5);
                        state[1][1] = 'o';
                    }
                    //playButton5.setDisable(true);
                    playButton5Pressed = true;
                    checkState();
                    System.out.println("playButton5: "+state[1][1]);
                }
            });

            playButton6.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton6Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton6);
                        state[1][2] = 'x';
                    }
                    else
                    {
                        playY(playButton6);
                        state[1][2] = 'o';
                    }
                    //playButton6.setDisable(true);
                    playButton6Pressed = true;
                    checkState();
                    System.out.println("playButton6: "+state[1][2]);
                }
            });

            playButton7.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton7Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton7);
                        state[2][0] = 'x';
                    }
                    else
                    {
                        playY(playButton7);
                        state[2][0] = 'o';
                    }
                    //playButton7.setDisable(true);
                    playButton7Pressed = true;
                    checkState();
                    System.out.println("playButton7: "+state[2][0]);
                }
            });

            playButton8.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton8Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton8);
                        state[2][1] = 'x';
                    }
                    else
                    {
                        playY(playButton8);
                        state[2][1] = 'o';
                    }
                    //playButton8.setDisable(true);
                    playButton8Pressed = true;
                    checkState();
                    System.out.println("playButton8: "+state[2][1]);
                }
            });

            playButton9.setOnAction((javafx.event.ActionEvent e) -> {
                if(!playButton9Pressed)
                {
                    if(turnX)
                    {
                        playX(playButton9);
                        state[2][2] = 'x';
                    }
                    else
                    {
                        playY(playButton9);
                        state[2][2] = 'o';
                    }
                    //playButton9.setDisable(true);
                    playButton9Pressed = true;
                    checkState();
                    System.out.println("playButton9: "+state[2][2]);
                }
            });
        }
        else
        {
            /* Disable playButtons by serDisable() *//*
            playButton1.setDisable(true);
            playButton2.setDisable(true);
            playButton3.setDisable(true);
            playButton4.setDisable(true);
            playButton5.setDisable(true);
            playButton6.setDisable(true);
            playButton7.setDisable(true);
            playButton8.setDisable(true);
            playButton9.setDisable(true);*/
            /* Disable playButtons by flags */
            playButton1Pressed = true;
            playButton2Pressed = true;
            playButton3Pressed = true;
            playButton4Pressed = true;
            playButton5Pressed = true;
            playButton6Pressed = true;
            playButton7Pressed = true;
            playButton8Pressed = true;
            playButton9Pressed = true;
            /* End of the game */
        }
    }

    private void playX(Button currentButton)//, int playButtonNum)
    {
        currentButton.setText("X");
        currentButton.setTextFill(javafx.scene.paint.Color.valueOf("#e4a593"));
        turnX = false;
    } 

    private void playY(Button currentButton)//, int playButtonNum)
    {
        currentButton.setText("O");
        currentButton.setTextFill(javafx.scene.paint.Color.valueOf("#5b3379"));
        turnX = true;
    } 

    private void playYComputer(Button currentButton)//, int playButtonNum)
    {
        currentButton.setText("O");
        currentButton.setTextFill(javafx.scene.paint.Color.valueOf("#5b3379"));
        turnX = true;
    } 
}