/**
	Lab 2 - Task 2 - String Separator - Get IP (Tokenizer)
	Author: Mahmoud Mohamed Kamal
	Date:   10-01-2022
*/

import java.util.*;

class GetIPTokenizer
{
	public static void main(String[] args)
	{
		String str = args[0]; 
		StringTokenizer st1 = new StringTokenizer(str, ".");
  
        while (st1.hasMoreTokens())
			System.out.println(st1.nextToken());
	}
}