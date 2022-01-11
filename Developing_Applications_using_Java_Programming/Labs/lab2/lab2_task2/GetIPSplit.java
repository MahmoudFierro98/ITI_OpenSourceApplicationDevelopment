/**
	Lab 2 - Task 2 - String Separator - Get IP (Split)
	Author: Mahmoud Mohamed Kamal
	Date:   10-01-2022
*/

class GetIPSplit
{
	public static void main(String[] args)
	{
		String str = args[0]; 
        String[] arrOfStr = str.split("\\.", 4);
 
        for (String a : arrOfStr)
            System.out.println(a);
	}
}