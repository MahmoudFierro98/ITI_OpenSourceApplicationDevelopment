/**
	Lab 2 - Task 2 - String Separator - Get IP
	Author: Mahmoud Mohamed Kamal
	Date:   10-01-2022
*/

class GetIP
{
	public static void main(String[] args)
	{
		String str = args[0];
        int index = str.indexOf(".");
		while (index != -1)
		{
			String s1 = str.substring(0,index);
			System.out.println(s1);
			str = str.substring(index+1);
			index = str.indexOf(".");
			if (index == -1)
				System.out.println(str);
		}
	}
}