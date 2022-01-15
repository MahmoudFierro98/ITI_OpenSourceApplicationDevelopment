/** 
	Lab 6 - Task 1 - Read from text file
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileReader;

public class ReadFile
{
	public static void main (String[] args)
	{
		FileReader file = null;
		try
		{
			char[] myFile = new char[100];
			file = new FileReader("sample.txt");
			file.read(myFile);
			System.out.println(myFile);
		}
		catch(IOException e)
		{
				e.printStackTrace();
		}
		finally
		{
			try
			{
				file.close();
			}
			catch(IOException e)
			{
					e.printStackTrace();
			}
		}
	}
}
