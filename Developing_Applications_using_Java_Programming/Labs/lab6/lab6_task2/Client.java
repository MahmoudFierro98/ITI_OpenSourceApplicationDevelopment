/** 
	Lab 6 - Task 2 - Simple Client/Server Console Example (Client Application)
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
	Socket mySocket;
	DataInputStream dis;
	PrintStream ps;
	public static void main(String[] args)
	{
		new Client();
	}
	public Client()
	{
		try
		{
			mySocket= new Socket("127.0.0.1", 5005);
			dis = new DataInputStream(mySocket.getInputStream());
			ps = new PrintStream(mySocket.getOutputStream());
			ps.println("Test Test");
			String replyMsg= dis.readLine();
			System.out.println(replyMsg);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			ps.close();
			dis.close();
			mySocket.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}