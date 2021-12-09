/* Lec 2 - Bubble Sort 
   Author: Mahmoud Kamal
   Date:   29-11-2021
   File:   BubbleSort.c
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>
#include"BubbleSort.h"

void BubbleSort(int* arr, int low, int high)
{
	int Swapped = 1, outerCounter, innerCounter, temp;
	
	for (outerCounter=low; (outerCounter<high)&&Swapped; outerCounter++)
	{
		Swapped = 0;
		for (innerCounter=0; innerCounter<high-outerCounter; innerCounter++)
		{
			if (arr[innerCounter] > arr[innerCounter+1])
			{
				temp = arr[innerCounter];
				arr[innerCounter] = arr[innerCounter+1];
				arr[innerCounter+1] = temp;
				Swapped = 1;
			}
		}
	}
}