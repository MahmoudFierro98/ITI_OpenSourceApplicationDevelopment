/** 
	Lab 1 - Task 1 - Simple Prompt Application
	Author: Mahmoud Mohamed Kamal
	Date:   09-01-2022
*/

class HelloWorld
{
	public static void main(String[] args)
	{
		int i;
		System.out.println("Hello Java");
		for(i=0; i<args.length; i++)
		{
			System.out.println(args[i]);
		}
	}
}