/** 
	Lab 6 - Task 1 - Write to text file
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileInputStream;

public class WriteFile
{
	public static void main (String[] args)
	{ 
		FileWriter fileWriter= null;
		PrintWriter printWriter= null;
		try{
			//Opening a file in append mode using FileWriter
			fileWriter = new FileWriter("sample.txt", true);
			//Wrapping BufferedWriterobject in PrintWriter
			printWriter = new PrintWriter(fileWriter);
			//Bringing cursor to next line
			printWriter.println();
			//Writing text to file
			for(String data : args)
			{
				printWriter.print(data);
				printWriter.print(" ");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{ //Closing the resources
			try
			{
				printWriter.close();
				fileWriter.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}