/* Lab 4 - Task 1
   Author: Mahmoud Kamal
   Date:   13-11-2021
*/
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

void main()
{
	/* Variable Delclaration */
	float nums[5]={0},temp=0;
	
	/* User Input */
	for (int i=0; i<5; i++)
	{
		printf("Enter Number %d: ",i);
		scanf("%f",&nums[i]);
	}
	
	/* Print Output Before Bubble Sorting */
	printf("\nThe Numbers Before Bubble Sorting: ");
	for (int i=0; i<5; i++)
	{
		printf("%0.2f, ",nums[i]);
	}
	
	/* Sorting */
	for (int i=0; i<4; i++)
	{
		for (int j=0; j<4-i; j++)
		{
			if (nums[j] > nums[j+1])
			{
				/* Swap */
				temp    = nums[j+1];
				nums[j+1] = nums[j];
				nums[j] = temp;
			}
		}
	}
	
	/* Print Output After Bubble Sorting */
	printf("\nThe Numbers After Bubble Sorting: ");
	for (int i=0; i<5; i++)
	{
		printf("%0.2f, ",nums[i]);
	}
	printf("\nMinimum: %0.2f\nMaximum: %0.2f",nums[0],nums[4]);
}