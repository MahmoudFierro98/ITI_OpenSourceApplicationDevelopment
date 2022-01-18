package javafxnotepad;

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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final MenuItem menuItem1;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem menuItem2;
    protected final Menu menu0;
    protected final MenuItem menuItem3;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem menuItem4;
    protected final MenuItem menuItem5;
    protected final MenuItem menuItem6;
    protected final MenuItem menuItem7;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem menuItem8;
    protected final Menu menu1;
    protected final MenuItem menuItem9;
    protected final TextArea textArea;    
    protected final Stage stage;
    String currentText = null;
    String currentPath = null; 
    String noteName = null;
    FileChooser fileChooser = null;
   
    static Stage s = new Stage();

    public FXMLDocumentBase(Stage stage) {

        this.stage = stage;

        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menuItem1 = new MenuItem();
        separatorMenuItem = new SeparatorMenuItem();
        menuItem2 = new MenuItem();
        menu0 = new Menu();
        menuItem3 = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        menuItem4 = new MenuItem();
        menuItem5 = new MenuItem();
        menuItem6 = new MenuItem();
        menuItem7 = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        menuItem8 = new MenuItem();
        menu1 = new Menu();
        menuItem9 = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(605.0);
        setPrefWidth(800.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        /* File Menu */  
        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("New");
        menuItem.setAccelerator(KeyCombination. keyCombination("CTRL+N"));
        menuItem.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                textArea.clear();
                Stage stage = (Stage) textArea.getScene().getWindow();
                Parent root = new FXMLDocumentBase(stage);
                stage.setTitle("Untitled - FX Notepad");
                fileChooser = null;
                currentText = null;
                currentPath = null; 
                noteName = null;
            }
        });

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Open");
        menuItem0.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
        menuItem0.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                menuItem0.setOnAction(new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent e) 
                    {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Select File");
                        File selectedFile = fileChooser.showOpenDialog(stage);

                        if (selectedFile != null) 
                        {
                            String path = selectedFile.getPath();
                            currentPath = path;
                            try 
                            {
                                FileInputStream fileInputStream = new FileInputStream(path);
                                byte[] text = new byte[fileInputStream.available()];
                                fileInputStream.read(text);
                                textArea.setText(new String(text));
                                currentText = textArea.getText();
                                String noteName = selectedFile.getName();
                                stage.setTitle(noteName);
                                fileInputStream.close();
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
            }
        });

        
        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Save");
        menuItem1.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        menuItem1.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                if (currentPath == null) 
                {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save File");
                    File selectedFile = fileChooser.showSaveDialog(stage);
                    if (selectedFile != null) 
                    {
                        String path = selectedFile.getPath();
                        currentPath = path;
                        noteName = selectedFile.getName();
                        stage.setTitle(noteName);
                    }
                }
                if (currentPath != null) 
                {
                    try 
                    {
                        try (FileOutputStream fileOutputStream = new FileOutputStream(currentPath)) 
                        {
                            byte[] text = textArea.getText().getBytes();
                            fileOutputStream.write(text);
                            textArea.setText(new String(text));
                            currentText = textArea.getText();
                        }
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        separatorMenuItem.setMnemonicParsing(false);

        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("Exit");
        menuItem2.setAccelerator(KeyCombination. keyCombination("ALT+F4"));
        menuItem2.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                stage.close();
                System.exit(0);
                Platform.exit();
            }
        });
        /* Edit Menu */
        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("Undo");
        menuItem3.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
        menuItem3.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
               textArea.undo();
            }

        });

        separatorMenuItem0.setMnemonicParsing(false);

        menuItem4.setMnemonicParsing(false);
        menuItem4.setText("Cut");
        menuItem4.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        menuItem4.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                textArea.cut();
            }
        });

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Copy");
        menuItem5.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        menuItem5.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                textArea.copy();
            }
        });

        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Paste");
        menuItem6.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        menuItem6.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                textArea.paste();
            }
        });

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Delete");
        menuItem7.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        menuItem7.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                textArea.deleteText(textArea.getSelection());
            }
        });

        separatorMenuItem1.setMnemonicParsing(false);

        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("Select All");
        menuItem8.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        menuItem8.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                textArea.selectAll();
            }
        });

        /* Help Menu */
        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        menuItem9.setMnemonicParsing(false);
        menuItem9.setText("About FX NotePad");
        menuItem9.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
        menuItem9.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                Alert alert = new Alert(AlertType.INFORMATION, "FX NotePad Version 0.0 \nCreated by: Mahmoud Mohamed Kamal");
                alert.show();
            }
        });

        setTop(menuBar);


        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(menuItem);
        menu.getItems().add(menuItem0);
        menu.getItems().add(menuItem1);
        menu.getItems().add(separatorMenuItem);
        menu.getItems().add(menuItem2);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(menuItem3);
        menu0.getItems().add(separatorMenuItem0);
        menu0.getItems().add(menuItem4);
        menu0.getItems().add(menuItem5);
        menu0.getItems().add(menuItem6);
        menu0.getItems().add(menuItem7);
        menu0.getItems().add(separatorMenuItem1);
        menu0.getItems().add(menuItem8);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(menuItem9);
        menuBar.getMenus().add(menu1);
    }
}