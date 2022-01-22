package tictactoe;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import javafx.scene.effect.*;
import java.lang.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Reflection reflection;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;

    private boolean turnX = true;
    private boolean winFlag = false;
    private char[][] state = new char[3][3];
    private int counter = 0;
    
    private void checkState()
    {
        counter++;
        if(((state[0][0] == state[0][1]) && (state[0][0] == state[0][2])) || ((state[0][0] == state[1][0]) && (state[0][0] == state[2][0])))
        {
            if(state[0][0] == 'x')
            {
                Alert alert = new Alert(AlertType.INFORMATION, "X WIN");
                alert.show();
                winFlag = true;
            }
            else if(state[0][0] == 'o')
            {
                Alert alert = new Alert(AlertType.INFORMATION, "O WIN");
                alert.show();
                winFlag = true;
            }
        }
        if(((state[1][0] == state[1][1]) && (state[1][1] == state[1][2])) || ((state[1][1] == state[0][1]) && (state[1][1] == state[2][1]))
        || ((state[0][0] == state[1][1]) && (state[1][1] == state[2][2])) || ((state[1][1] == state[2][0]) && (state[1][1] == state[0][2])))
        {
            if(state[1][1] == 'x')
            {
                Alert alert = new Alert(AlertType.INFORMATION, "X WIN");
                alert.show();
                winFlag = true;
            }
            else if(state[1][1] == 'o')
            {
                Alert alert = new Alert(AlertType.INFORMATION, "O WIN");
                alert.show();
                winFlag = true;
            }
        }
        if(((state[2][0] == state[2][2]) && (state[2][2] == state[2][1])) || ((state[2][2] == state[0][2]) && (state[2][2] == state[1][2])))
        {
            if(state[2][2] == 'x')
            {
                Alert alert = new Alert(AlertType.INFORMATION, "X WIN");
                alert.show();
                winFlag = true;
            }
            else if(state[2][2] == 'o')
            {
                Alert alert = new Alert(AlertType.INFORMATION, "O WIN");
                alert.show();
                winFlag = true;
            }
        }
        if((counter == 9) && !winFlag)
        {
            Alert alert = new Alert(AlertType.INFORMATION, "Draw");
            alert.show();
        }
        play();
    }
    public FXMLDocumentBase() {

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                state[i][j] = 'z';
            }         
        }

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        reflection = new Reflection();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();

        setGridLinesVisible(true);
        setPrefHeight(598.0);
        setPrefWidth(1097.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(399.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(395.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(402.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(339.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(402.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(339.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        button.setMnemonicParsing(false);
        button.setPrefHeight(215.0);
        button.setPrefWidth(434.0);
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        GridPane.setRowIndex(button0, 1);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(215.0);
        button0.setPrefWidth(434.0);
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setRowIndex(button1, 2);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(215.0);
        button1.setPrefWidth(434.0);
        button1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        GridPane.setColumnIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(215.0);
        button2.setPrefWidth(434.0);
        button2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(215.0);
        button3.setPrefWidth(434.0);
        button3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 2);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(215.0);
        button4.setPrefWidth(434.0);
        button4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        GridPane.setColumnIndex(button5, 2);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(215.0);
        button5.setPrefWidth(434.0);
        button5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(button6, 2);
        GridPane.setRowIndex(button6, 1);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(215.0);
        button6.setPrefWidth(434.0);
        button6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(215.0);
        button7.setPrefWidth(434.0);
        button7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(button4);
        getChildren().add(button5);
        getChildren().add(button6);
        getChildren().add(button7);

        play();
    }

    private void play()
    {
        if(winFlag == false)
        {
            button.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button.setText("X");
                    state[0][0] = 'x';
                    turnX = false;
                }
                else
                {
                    button.setText("O");
                    state[0][0] = 'o';
                    turnX = true;
                }
                button.setFont(new Font(96));
                button.setDisable(true);
                checkState();
                System.out.println(state[0][0]);
            });

            button0.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button0.setText("X");
                    state[1][0] = 'x';
                    turnX = false;
                }
                else
                {
                    button0.setText("O");
                    state[1][0] = 'o';
                    turnX = true;
                }
                button0.setFont(new Font(96));
                button0.setDisable(true);
                checkState();
                System.out.println(state[1][0]);
            });;

            button1.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button1.setText("X");
                    state[2][0] = 'x';
                    turnX = false;
                }
                else
                {
                    button1.setText("O");
                    state[2][0] = 'o';
                    turnX = true;
                }
                button1.setFont(new Font(96));
                button1.setDisable(true);
                checkState();
                System.out.println(state[2][0]);
            });

            button2.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button2.setText("X");
                    state[0][1] = 'x';
                    turnX = false;
                }
                else
                {
                    button2.setText("O");
                    state[0][1] = 'o';
                    turnX = true;
                }
                button2.setFont(new Font(96));
                button2.setDisable(true);
                checkState();
                System.out.println(state[0][1]);
            });

            button3.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {   
                    button3.setText("X");
                    state[1][1] = 'x';
                    turnX = false;
                }
                else
                {
                    button3.setText("O");
                    state[1][1] = 'o';
                    turnX = true;
                }
                button3.setFont(new Font(96));
                button3.setDisable(true);
                checkState();
                System.out.println(state[1][1]);
            });

            button4.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button4.setText("X");
                    state[2][1] = 'x';
                    turnX = false;
                }
                else
                {
                    button4.setText("O");
                    state[2][1] = 'o';
                    turnX = true;
                }
                button4.setFont(new Font(96));
                button4.setDisable(true);
                checkState();
                System.out.println(state[2][1]);
            }); 

            button5.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button5.setText("X");
                    state[0][2] = 'x';
                    turnX = false;
                }
                else
                {
                    button5.setText("O");
                    state[0][2] = 'o';
                    turnX = true;
                }
                button5.setFont(new Font(96));
                button5.setDisable(true);
                    checkState();
                System.out.println(state[0][2]);
            });

            button6.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button6.setText("X");
                    state[1][2] = 'x';
                    turnX = false;
                }
                else
                {
                    button6.setText("O");
                    state[1][2] = 'o';
                    turnX = true;
                }
                button6.setFont(new Font(96));
                button6.setDisable(true);
                checkState();
                System.out.println(state[1][2]);
            });

            button7.setOnAction((javafx.event.ActionEvent e) -> {
                if(turnX)
                {
                    button7.setText("X");
                    state[2][2] = 'x';
                    turnX = false;
                }
                else
                {
                    button7.setText("O");
                    state[2][2] = 'o';
                    turnX = true;
                }
                button7.setFont(new Font(96));
                button7.setDisable(true);
                checkState();
                System.out.println(state[2][2]);
            });
        }
        else
        {
            button.setDisable(true);
            button0.setDisable(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            button5.setDisable(true);
            button6.setDisable(true);
            button7.setDisable(true);
            /* End of the game */
        }
    }
}
