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
import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud kamal
 */
public class PlayingSceneBase extends AnchorPane /*implements Runnable*/ {

    protected final Group group;
    protected final Button homeBtn;
    protected final Button logoutBtn;
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
    protected final Button[] playButton = new Button[9];
    protected final Separator separator;
    protected final Separator separator0;
    protected final Separator separator1;
    protected final Separator separator2;
    protected final Group group5;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final AnchorPane gameStatePane;
    protected final Button replayBtn;
    protected final Button exitBtn;
    protected final Label gameStateLabel;
    protected final Label gamePointsLabel;

    /* Turn X or O flag */
    private boolean turnX;
    /* Win Flag check winnig cases */
    private boolean finishFlag;
    /* Save record of the game and to check the state of winnig cases */
    private char[] state = new char[9];
    private int counter;
    /* Pressed Flags for play buttons */
    private boolean[] playButtonPressed = new boolean[9];
    /* Play Mode */
    String playMode;
    /* Players Name */
    String player1Name;
    String player2Name;
    /* Players Points */
    int player1Points;
    int player2Points;
    /* Player Side */
    char playerSide;
//    Thread th;
    public PlayingSceneBase() 
    {
        /* Initialization */
        turnX = true;
        finishFlag = false;
        for(int i=0; i<9; i++)
        {
            state[i] = 'z';
            playButtonPressed[i] = false;     
        }
        counter = 0;
        playMode = "vsComputer";
        playerSide = 'o';

        group = new Group();
        homeBtn = new Button();
        logoutBtn = new Button();
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
        for(int i=0; i<9; i++)
        {
            playButton[i] = new Button();
        }
        separator = new Separator();
        separator0 = new Separator();
        separator1 = new Separator();
        separator2 = new Separator();
        group5 = new Group();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        gameStatePane = new AnchorPane();
        replayBtn = new Button();
        exitBtn = new Button();
        gameStateLabel = new Label();
        gamePointsLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(800.0);
        setScaleShape(false);
        setStyle("-fx-background-color: linear-gradient(#37077B, #FDB8A5);");

        homeBtn.setLayoutX(18.0);
        homeBtn.setLayoutY(17.0);
        homeBtn.setMnemonicParsing(false);
        homeBtn.setPrefHeight(47.0);
        homeBtn.setPrefWidth(117.0);
        homeBtn.setStyle("-fx-background-color: #E4A593; -fx-background-radius: 20px;");
        homeBtn.setText("Home");
        homeBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        homeBtn.setFont(new Font("System Bold", 15.0));
        homeBtn.setOnAction((javafx.event.ActionEvent e) -> {
            System.exit(0);
        });

        logoutBtn.setLayoutX(18.0);
        logoutBtn.setLayoutY(80.0);
        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setPrefHeight(47.0);
        logoutBtn.setPrefWidth(117.0);
        logoutBtn.setStyle("-fx-background-color: #E4A593; -fx-background-radius: 20px;");
        logoutBtn.setText("Log out");
        logoutBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoutBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        logoutBtn.setFont(new Font("System Bold", 15.0));
        logoutBtn.setOnAction((javafx.event.ActionEvent e) -> {
            System.exit(0);
        });

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

        playButton[0].setLayoutX(176.0);
        playButton[0].setLayoutY(502.0);

        playButton[1].setLayoutX(340.0);
        playButton[1].setLayoutY(502.0);

        playButton[2].setLayoutX(501.0);
        playButton[2].setLayoutY(502.0);

        playButton[3].setLayoutX(176.0);
        playButton[3].setLayoutY(608.0);

        playButton[4].setLayoutX(340.0);
        playButton[4].setLayoutY(608.0);

        playButton[5].setLayoutX(501.0);
        playButton[5].setLayoutY(608.0);

        playButton[6].setLayoutX(176.0);
        playButton[6].setLayoutY(714.0);

        playButton[7].setLayoutX(339.0);
        playButton[7].setLayoutY(714.0);

        playButton[8].setLayoutX(501.0);
        playButton[8].setLayoutY(714.0);

        for(int i=0; i<9; i++)
        {
            playButton[i].setMnemonicParsing(false);
            playButton[i].setPrefHeight(104.0);
            playButton[i].setPrefWidth(161.0);
            playButton[i].setStyle("-fx-background-color: transparent;");
            playButton[i].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            //playButton[i].setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
            playButton[i].setFont(new Font("System Bold", 48.0));
        }

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

        /* Game States (Win or Lose) + Points */
        gameStatePane.setLayoutX(122.0);
        gameStatePane.setLayoutY(73.0);
        gameStatePane.setPrefHeight(455.0);
        gameStatePane.setPrefWidth(557.0);
        gameStatePane.setStyle("-fx-background-color: #2323237a;");
        gameStatePane.setVisible(false);

        replayBtn.setLayoutX(204.0);
        replayBtn.setLayoutY(234.0);
        replayBtn.setMnemonicParsing(false);
        replayBtn.setPrefHeight(85.0);
        replayBtn.setPrefWidth(150.0);
        replayBtn.setStyle("-fx-background-color: #E4A593; -fx-background-radius: 20px;");
        replayBtn.setText("Re-Play");
        replayBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        replayBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        replayBtn.setFont(new Font("System Bold", 30.0));
        replayBtn.setOnAction((javafx.event.ActionEvent e) -> {
            newGame();
        });

        exitBtn.setLayoutX(204.0);
        exitBtn.setLayoutY(335.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(85.0);
        exitBtn.setPrefWidth(150.0);
        exitBtn.setStyle("-fx-background-color: #523178; -fx-background-radius: 20px;");
        exitBtn.setText("Exit");
        exitBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        exitBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        exitBtn.setFont(new Font("System Bold", 30.0));
        exitBtn.setOnAction((javafx.event.ActionEvent e) -> {
            System.exit(0);
        });

        gameStateLabel.setLayoutX(194.0);
        gameStateLabel.setLayoutY(47.0);
        gameStateLabel.setText("You win");
        gameStateLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        gameStateLabel.setFont(new Font("System Bold", 45.0));

        gamePointsLabel.setLayoutX(213.0);
        gamePointsLabel.setLayoutY(145.0);
        gamePointsLabel.setText("+5 Points");
        gamePointsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#e4a593"));
        gamePointsLabel.setFont(new Font("System Bold", 29.0));

        group.getChildren().add(homeBtn);
        group.getChildren().add(logoutBtn);
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
        for(int i=0; i<9; i++)
        {
            group4.getChildren().add(playButton[i]);
        }
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
        gameStatePane.getChildren().add(replayBtn);
        gameStatePane.getChildren().add(exitBtn);
        gameStatePane.getChildren().add(gameStateLabel);
        gameStatePane.getChildren().add(gamePointsLabel);
        getChildren().add(gameStatePane);

        play();
    }

    private void play()
    {
        /* Check Play Mode and Player Side */
        if(playMode.equals("vsComputer"))
        {
            if(playerSide == 'x')
            {
                playXvsComputerO();
            }
            else if(playerSide == 'o')
            {
                playOvsComputerX();
            }
        }
        else if(playMode.equals("localPlay"))
        {
            localPlay();
        }
    }
    private void localPlay()
    {
        if(!finishFlag)
        {
            for(int i=0; i<9; i++)
            {
                int j = i; 
                playButton[i].setOnAction((javafx.event.ActionEvent e) -> {
                    if(!playButtonPressed[j])
                    {
                        if(turnX)
                        {
                            playX(playButton[j],j);
                        }
                        else
                        {
                            playO(playButton[j],j);
                        }
                    }
                });
            }
        }
        else
        {
            /* Disable playButtons by serDisable() *//*
            for(int i=0; i<9; i++)
            {
                playButton[i].setDisable(true);
            }
            /* Disable playButtons by flags */
            for(int i=0; i<9; i++)
            {
                playButtonPressed[i] = true;
            }
            /* End of the game */
        }
    }

    private void playXvsComputerO()
    {
        if(!finishFlag)
        {
            if(turnX)
            {
                for(int i=0; i<9; i++)
                {
                    int j = i; 
                    playButton[i].setOnAction((javafx.event.ActionEvent e) -> {
                        if(!playButtonPressed[j])
                        {
                            playX(playButton[j],j);
                        }
                    });
                }
            }
            else
            {
                playOComputer();
            }
        }
        else
        {
            /* Disable playButtons by serDisable() *//*
            for(int i=0; i<9; i++)
            {
                playButton[i].setDisable(true);
            }
            /* Disable playButtons by flags */
            for(int i=0; i<9; i++)
            {
                playButtonPressed[i] = true;
            }
            /* End of the game */
        }
    }

    private void playOvsComputerX()
    {
        if(!finishFlag)
        {
            if(turnX)
            {
                playXComputer();
            }
            else
            {
                for(int i=0; i<9; i++)
                {
                    int j = i; 
                    playButton[i].setOnAction((javafx.event.ActionEvent e) -> {
                        if(!playButtonPressed[j])
                        {
                            playO(playButton[j],j);
                        }
                    });
                }
            }
        }
        else
        {
            /* Disable playButtons by serDisable() *//*
            for(int i=0; i<9; i++)
            {
                playButton[i].setDisable(true);
            }
            /* Disable playButtons by flags */
            for(int i=0; i<9; i++)
            {
                playButtonPressed[i] = true;
            }
            /* End of the game */
        }
    }

    private void playX(Button currentButton, int playButtonNum)
    {
        currentButton.setText("X");
        currentButton.setTextFill(javafx.scene.paint.Color.valueOf("#e4a593"));
        state[playButtonNum] = 'x';
        //playButton[playButtonNum].setDisable(true);
        playButtonPressed[playButtonNum] = true;
        turnX = false;
        System.out.println("playButton["+playButtonNum+"]: "+state[playButtonNum]);
        checkState();
    } 

    private void playO(Button currentButton, int playButtonNum)
    {
        currentButton.setText("O");
        currentButton.setTextFill(javafx.scene.paint.Color.valueOf("#5b3379"));
        state[playButtonNum] = 'o';
        //playButton[playButtonNum].setDisable(true);
        playButtonPressed[playButtonNum] = true;
        turnX = true;
        System.out.println("playButton["+playButtonNum+"]: "+state[playButtonNum]);
        checkState();
    } 

    private void playXComputer()
    {
        if((counter < 9) && !finishFlag)
        {
            int value = 1;
            do{ 
                value = (int)(Math.random() * (9));System.out.println(value);
            }while(state[value] != 'z');
            playX(playButton[value],value);
        }
    } 

    private void playOComputer()
    {
        if((counter < 9) && !finishFlag)
        {
            int value = 0;
            do{ 
                value = (int)(Math.random() * (9));System.out.println(value);
            }while(state[value] != 'z');
            playO(playButton[value],value);
        }
    }
    
    private void checkState()
    {
        counter++;
        if((state[0] == state[1]) && (state[0] == state[2])) 
        {   
            checkXO(state[0],0,1,2);
        }
        else if((state[0] == state[3]) && (state[0] == state[6]))
        {   
            checkXO(state[0],0,3,6);
        }
        else if((state[4] == state[3]) && (state[4] == state[5])) 
        {   
            checkXO(state[4],3,4,5);
        }
        else if((state[4] == state[1]) && (state[4] == state[7]))
        {   
            checkXO(state[4],1,4,7);
        }
        else if((state[4] == state[0]) && (state[4] == state[8])) 
        {   
            checkXO(state[4],0,4,8);
        }
        else if((state[4] == state[2]) && (state[4] == state[6]))
        {   
            checkXO(state[4],2,4,6);
        }
        else if((state[8] == state[6]) && (state[8] == state[7])) 
        {   
            checkXO(state[8],6,7,8);
        }
        else if((state[8] == state[2]) && (state[8] == state[5]))
        {   
            checkXO(state[8],2,5,8);
        }
        else if((counter >= 9) && !finishFlag)
        {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Draw");
//            alert.show();
            draw();
            drawButtons();
        }
        play();
    }

    void checkXO(int st, int btn1, int btn2, int btn3)
    {   
        if(((st == 'x')&&(playerSide == 'x')) || ((st == 'o')&&(playerSide == 'o')))
        {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "X WIN");
//            alert.show();
            win();
            finishFlag = true;
            /* Color the buttons */
            winningButton(playButton[btn1]);
            winningButton(playButton[btn2]);
            winningButton(playButton[btn3]);
        }
        else if(((st == 'x')&&(playerSide != 'x')) || ((st == 'o')&&(playerSide != 'o')))
        {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "O WIN");
//            alert.show();
            lose();
            finishFlag = true;
            /* Color the buttons */
            winningButton(playButton[btn1]);
            winningButton(playButton[btn2]);
            winningButton(playButton[btn3]);
        }
    } 

    void winningButton(Button btn)
    {   
        //btn.setTextFill(javafx.scene.paint.Color.valueOf("GREEN"));
        btn.setStyle("-fx-background-color: GREEN;");
    } 

    void drawButtons()
    {   
        //btn.setTextFill(javafx.scene.paint.Color.valueOf("GREEN"));
        for(int i=0; i<9; i++)
        {
            playButton[i].setStyle("-fx-background-color: YELLOW;");
        }
    }

    void win()
    {
        gameStateLabel.setText("You win");
        gameStateLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        gamePointsLabel.setVisible(true);
        gameStatePane.setVisible(true);
    }

    void lose()
    {
        gameStateLabel.setText("You Lost");
        gameStateLabel.setTextFill(javafx.scene.paint.Color.RED);
        gamePointsLabel.setVisible(false);
        gameStatePane.setVisible(true);
    }

    void draw()
    {
        gameStateLabel.setText("  Draw");
        gameStateLabel.setTextFill(javafx.scene.paint.Color.RED);
        gamePointsLabel.setVisible(false);
        gameStatePane.setVisible(true);
    }

    void newGame()
    {
        turnX = true;
        finishFlag = false;
        counter = 0;
        for(int i=0; i<9; i++)
        {
            state[i] = 'z';
            playButtonPressed[i] = false;  
            playButton[i].setStyle("-fx-background-color: transparent;");  
            playButton[i].setText(""); 
        }
        gameStatePane.setVisible(false);
        play();
    }
}