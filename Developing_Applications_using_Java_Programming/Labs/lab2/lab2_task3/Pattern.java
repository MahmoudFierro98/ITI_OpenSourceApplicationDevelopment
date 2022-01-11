/**
	Lab 2 - Task 3 - Pattern
	Author: Mahmoud Mohamed Kamal
	Date:   10-01-2022
*/

class Pattern
{
	public static void main(String[] args)
	{
		int counter1 = 0;
		int counter2 = 0;
		//int counter3 = 0;
		//int counter4 = 0;
		for(counter1=0; counter1<4; counter1++)
		{
			for(counter2=0; counter2<=counter1; counter2++)
			{
				System.out.printf("*");
			}
			for(counter2=10; counter2>counter1*2; counter2--)
			{
				System.out.printf(" "); 
			}
			for(counter2=0; counter2<=counter1; counter2++)
			{
				System.out.printf("* ");
			}
			System.out.printf(" \n");
		}		
		/*
		for(counter3=0; counter3<5; counter3++)
		{
			for(counter4=0; counter4<5-counter3-1; counter4++)
			{
				System.out.printf(" "); 
			}
			for(counter4=0; counter4<=counter3; counter4++)
			{
				System.out.printf(" * ");
			}
			System.out.printf(" \n");
		}*/
	}
}