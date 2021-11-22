/* Lab 2 - Task 5
   Author: Mahmoud Kamal
   Date:   03-11-2021
*/
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

int main()
{
	/* Variables Declaration */
    char input;
	int flag = 1;
	
	/* User Inputs */
	printf("\t****Please select ****");
	printf("\n\t****1- print ****");
	printf("\n\t****2- edit ****");
	printf("\n\t****3- save ****");
	printf("\n\t****4- exit ****");
	while(flag)
	{	
		printf("\n\nEnter: ");
		input = getch();
		system("cls");
		/* Operation */
		if (input == '1')
			printf("\n\nPrint");
		else if (input == '2')
			printf("\n\nEdit");
		else if (input == '3')
			printf("\n\nSave");
		else if (input == '4')
		{
			printf("\n\nExit");
			flag = 0;
		}
		else
		{	
			printf("\n\t****Please select ****");
			printf("\n\t****1- print ****");
			printf("\n\t****2- edit ****");
			printf("\n\t****3- save ****");
			printf("\n\t****4- exit ****");
		}
	}
	return 0;
}