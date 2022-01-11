/** 
	Lab 2 - Task 1 - Command Line Calculator
	Author: Mahmoud Mohamed Kamal
	Date:   10-01-2022
*/

class Calc
{
	public static void main(String[] args)
	{
		if(args.length == 3)
		{
			double result = 0.0;
			double num1 = Double.parseDouble(args[0]);
			double num2 = Double.parseDouble(args[2]);
			
			switch(args[1])
			{
				case"+":
					result = num1 + num2;
					System.out.println("= " + result);
					break;
				case"-":
					result = num1 - num2;
					System.out.println("= " + result);
					break;
				case"/":
					result = num1 / num2;
					System.out.println("= " + result);
					break;
				case"x":
					result = num1 * num2;
					System.out.println("= " + result);
					break;
				case"%":
					result = num1 % num2;
					System.out.println("= " + result);
					break;
				default:
					System.out.println("Erro || Operations: + or - or x or / or %");
					break;
			}
		}
		else
		{
			System.out.println("Erro || Try Again Bye *_*");
		}
	}
}