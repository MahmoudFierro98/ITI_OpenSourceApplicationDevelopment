/* Lab 5 - Task 1
   Author: Mahmoud Kamal
   Date:   13-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<ctype.h>
#include<string.h>

void copyArr(char arr[], const int size)
{
	char arrCopy[size];
	for (int i=0; i<size; i++)
	{
		arrCopy[i] = arr[i];
	}
	
	for (int i=0; i<size; i++)
	{
		printf("%c",arrCopy[i]);
	}
}

void main(void)
{
	char arr[] = "Mahmoud Kamal";
	copyArr(arr, strlen(arr));
}