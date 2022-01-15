/** 
	Lab 6 - Task 3 - Chat App (ChatServer)
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ChatServer
{
	ServerSocket serverSocket;
	public ChatServer()
	{
		try
		{
			serverSocket= new ServerSocket(5005);
		} 
		catch (IOException e){}
		while(true)
		{
			try
			{
				Socket s = serverSocket.accept();
				System.out.println("New Client");
				new ChatHandler(s);
			} 
			catch (IOException e){}
		}
	}
	public static void main(String[] args)
	{
		new ChatServer();
	}
}