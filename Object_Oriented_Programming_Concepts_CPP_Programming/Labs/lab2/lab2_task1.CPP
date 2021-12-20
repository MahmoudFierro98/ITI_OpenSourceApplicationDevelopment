/* Lab 2 - Task 1
   Author: Mahmoud Kamal
   Date:   18-12-2021
*/

#include<iostream.h>
#include<conio.h>

void swap(int& x, int& y)
{
	int temp;
	temp = x;
	x = y;
	y = temp;
}

int main()
{
	clrscr();
	int a = 3, b = 5;
	cout << "a= " << a << " b: " << b << endl;
	swap(a,b);
	cout << "a= " << a << " b: " << b << endl;
    getch();
	return 0;
}