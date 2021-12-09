/* Lec 3 - Merge Sort 
   Author: Mahmoud Kamal
   Date:   01-12-2021
   File:   MergeSort.c
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>
//#include"MergeSort.h"

int arr[5] = {8,4,100,7,5};

void Merge(int low, int mid, int high)
{
	int temp[5];
	int list1, list2, counter;
	
	list1 = counter =low;
	list2 = mid+1;
	
	while((list1 <= mid) && (list2 <= high))
	{
		if(arr[list1] < arr[list2])
		{
			temp[counter] = arr[list1];
			list1 ++;
		}
		else
		{
			temp[counter] = arr[list2];
			list2 ++;
		}
		counter++;
	}
	while(list1 <= mid)
	{
		temp[counter] = arr[list1];
		list1 ++;
		counter++;
	}
	while(list2 <= high)
	{
		temp[counter] = arr[list2];
		list2 ++;
		counter++;
	}
	for (int iterator=low; iterator<=high; iterator++)
	{
		arr[iterator] = temp[iterator];
	}
}

void MergeSort(int low, int high)
{
	int mid,size;

	if (low < high)
	{
		mid = (low+high)/2;
		MergeSort(low,mid);
		MergeSort(mid+1,high);
		Merge(low,mid,high);
	}
}

int main(void)
{
	//int arr[] = {8,4,7,5,6,10,11,22,55,100,555,10};
	MergeSort(0,4);
	
	for (int i=0; i<5; i++)
		printf("%d,",arr[i]);
	printf("\n");
	return 0;
}