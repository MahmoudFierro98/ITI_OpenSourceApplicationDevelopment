/** 
	Lab 6 - Task 3 - Chat App (ChatHandler)
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.net.Socket;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.Vector;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatHandler extends Thread 
{
	Socket socket;
	BufferedReader dis;
	PrintStream ps;
	static Vector<ChatHandler> clients = new Vector<ChatHandler>();
	
	public ChatHandler(Socket socket) 
	{
		this.socket = socket;
		try 
		{
			dis = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			ps = new PrintStream(this.socket.getOutputStream());
		} 
		catch (IOException e){}
		clients.add(this);
		start();
	}
	public void run() 
	{
		while (true) 
		{
			try 
			{
				String message = dis.readLine();
				System.out.println("Received: " + message);
				sendMessageToAll(message);
			} 
			catch (IOException e){}
		}
	}
	public void sendMessageToAll(String message) 
	{
		clients.forEach((ChatHandler client) -> 
		{
			client.ps.println(message);
		});
	}
}