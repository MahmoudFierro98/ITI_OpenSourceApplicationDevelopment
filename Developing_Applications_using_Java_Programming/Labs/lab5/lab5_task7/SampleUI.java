/** 
	Lab 5 - Task 7 - Create A GUI Desktop Application
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SampleUI extends JFrame 
{
	public SampleUI() 
	{
		this.setLayout(new FlowLayout());
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

	public static void main(String args[]) 
	{
		SampleUI SampleUI = new SampleUI();
		SampleUI.setSize(600, 400);
		SampleUI.setResizable(false);
		SampleUI.setVisible(true);
	}
}