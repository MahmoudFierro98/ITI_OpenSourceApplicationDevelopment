/* Lab 1 - Task 3
   Author: Mahmoud Kamal
   Date:   20-12-2021
*/

#include<iostream.h>
#include<conio.h>

int BoxVolume(int l=1, int w=1, int h=1);
int main()
{
	clrscr();
	int v1;
	v1 = BoxVolume();
	cout << v1;
	getch();
	return 0;
}

int BoxVolume(int l, int w, int h)
{
	return(l*w*h);
}

