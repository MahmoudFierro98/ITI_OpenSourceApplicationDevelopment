/* Lec 3 - Binary Search
   Author: Mahmoud Kamal
   Date:   01-12-2021
   File:   BinarySearch.c
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>
#include"BinarySearch.h"

int BinarySearch(int* arr, int LB, int UB, int data)
{
	int mid, loc=-1;
	
	while((LB<=UB) && (loc==-1))
	{
		mid = (LB+UB)/2;
		if(arr[mid]==data)
		{
			loc = mid;
		}
		else if (arr[mid] < data)
		{
			LB = mid+1;
		}
		else
		{
			UB = mid-1;
		}
	}
	return loc;
}