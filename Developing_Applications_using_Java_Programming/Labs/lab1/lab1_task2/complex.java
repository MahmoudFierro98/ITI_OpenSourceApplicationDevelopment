/** 
	Lab 1 - Task 2 - Complex Numbers
	Author: Mahmoud Mohamed Kamal
	Date:   09-01-2022
*/

class COMPLEX
{
	public static void main(String[] args)
	{
		ComplexNum c1 = new ComplexNum(2,5);
		c1.print();
		ComplexNum c2 = new ComplexNum(1,-3);
		c2.print();
		ComplexNum c3 = new ComplexNum();
		c3 = c1.add(c2);
		c3.print();
		ComplexNum c4 = new ComplexNum();
		c4 = c1.sub(c2);
		c4.print();
	}
}

class ComplexNum
{
	private float real;
	private float imeg;
	ComplexNum(){real = imeg = 0;}
	ComplexNum(float r, float i)
	{
		real = r;
		imeg = i;
	}
	public void print()
	{
		if(imeg < 0)
		{
			System.out.println(real+""+imeg+"i");	
		}
		else
		{
			System.out.println(real+"+"+imeg+"i");	
		}
	}
	public ComplexNum add(ComplexNum c)
	{
		ComplexNum temp = new ComplexNum();
		temp.real = real + c.real;
		temp.imeg = imeg + c.imeg;
		return temp;
	}
	public ComplexNum sub(ComplexNum c)
	{
		ComplexNum temp = new ComplexNum();
		temp.real = real - c.real;
		temp.imeg = imeg - c.imeg;
		return temp;
	}
}