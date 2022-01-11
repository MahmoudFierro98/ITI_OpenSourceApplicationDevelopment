/**
	Lab 2 - Task 2 - String Separator - Get IP (Bonuce)
	Author: Mahmoud Mohamed Kamal
	Date:   10-01-2022
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetIPBonuce
{
	public static void main(String[] args)
	{
		String str = args[0]; 
		String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
 
        String regex = "^" + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "$";
 
        Pattern p = Pattern.compile(regex);
 
        Matcher m = p.matcher(str);
 
        if(m.find())
		{
			String[] arrOfStr = str.split("\\.", 4);
 
			for (String a : arrOfStr)
				System.out.println(a);
		}
		else
		{
			System.out.println("Error || Wrong IP");
		}
	}
}