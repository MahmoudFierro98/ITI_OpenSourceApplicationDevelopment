package chat;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChatApp extends JFrame {
  public ChatApp() {
    setLayout(new FlowLayout());
    JTextArea textarea = new JTextArea(20, 50);
    JScrollPane scrollPane = new JScrollPane(textarea);
    JTextField textField = new JTextField(40);
    JButton sendButton = new JButton("Send");
    sendButton.addActionListener((ActionEvent event) -> {
      textarea.append(textField.getText() + "\n");
      textField.setText("");
    });
    add(scrollPane);
    add(textField);
    add(sendButton);
  }

  public static void main(String args[]) {
    ChatApp chatApp = new ChatApp();
    chatApp.setSize(400, 600);
    chatApp.setResizable(false);
    chatApp.setVisible(true);
  }
}