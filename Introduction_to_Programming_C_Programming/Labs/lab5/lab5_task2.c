/* Lab 5 - Task 2
   Author: Mahmoud Kamal
   Date:   13-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<ctype.h>
#include<string.h>

void main(void)
{
	/* Variables Declaration */
	char firstName[5][20],lastName[5][20],fullName[5][20];
	/* Input */
	for (int i=0; i<5; i++)
	{
		printf("****#%d user****\n",i+1);
		printf("Enter your first name: ");
		scanf("%s",firstName[i]);
		printf("Enter your last name: ");
		scanf("%s",lastName[i]);
		printf("\n");
	}
	/* Operation */
	for (int i=0; i<5; i++)
	{
		strcat(firstName[i], " ");
		strcpy(fullName[i], (strcat(firstName[i], lastName[i])));
	}
	/* Output */
	for (int i=0; i<5; i++)
	{
		printf("****#%d user****\n",i+1);
		printf("Full Name: %s\n\n",fullName[i]);
	}
}