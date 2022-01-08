/* Lab 1 - Task 2
   Author: Mahmoud Kamal
   Date:   20-12-2021
*/

#include<iostream.h>
#include<conio.h>

int n = 5;						// Global Variable
int main()
{
	clrscr();
	int n=7;					// Local Variable
	n = 8;                 	 	// Access the Local Variable
	cout << n << endl;
	cout << ::n << endl;
	::n = 8;             		// Access 2the Global Variable
	n = 5;                 	 	// Access the Local Variable
	cout << n << endl;
	cout << ::n << endl;
	getch();
	return 0;
}

