/** 
	Lab 6 - Task 2 - Simple Client/Server Console Example (Server Application)
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	ServerSocket myServerSocket;
	Socket s;
	DataInputStream dis;
	PrintStream ps;
	public static void main(String[] args)
	{
		new Server();
	}
	public Server()
	{
		try
		{
			myServerSocket= new ServerSocket(5005);
			s = myServerSocket.accept();
			dis = new DataInputStream(s.getInputStream());
			ps= new PrintStream(s.getOutputStream());
			String msg= dis.readLine();
			System.out.println(msg);
			ps.println("Data Received");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			ps.close();
			dis.close();
			s.close();
			myServerSocket.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}