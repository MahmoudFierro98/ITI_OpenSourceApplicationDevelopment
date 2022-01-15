/** 
	Lab 6 - Task 3 - Chat App (ChatAppGUI)
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.awt.*;
import java.net.Socket;
import java.net.InetAddress;
import javafx.application.Platform;

public class ChatApp extends JFrame implements Runnable 
{
	Socket socket;
	JTextArea textarea = new JTextArea(20, 50);
	JScrollPane scrollPane = new JScrollPane(textarea);
	JTextField textField = new JTextField(40);
	JButton sendButton = new JButton("Send");
	PrintStream ps;
	BufferedReader dis;
	
	public ChatApp() 
	{
		try 
		{
			socket = new Socket(InetAddress.getLocalHost(), 5005);
			dis = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
		} 
		catch (IOException e){}
		setLayout(new FlowLayout());
		sendButton.addActionListener((ActionEvent event) -> 
		{
			String message = textField.getText();
			ps.println(message);
			// textarea.append(textField.getText() + "\n");
			textField.setText("");
		});
		add(scrollPane);
		add(textField);
		add(sendButton);
		new Thread(this).start();
	}
	
	public static void main(String args[]) 
	{
		ChatApp chatApp = new ChatApp();
		chatApp.setSize(600, 400);
		chatApp.setResizable(true);
		chatApp.setVisible(true);
	}
	
	public void run() 
	{
		while (true) 
		{
			try 
			{
				String message = dis.readLine();
				textarea.append(message + "\n");
			} 
			catch (IOException e){}
		}
	}
}