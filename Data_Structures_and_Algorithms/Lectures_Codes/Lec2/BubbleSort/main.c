#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>
#include"BubbleSort.h"

int main(void)
{
	int arr[] = {8,4,7,5,6,10,11,22,55,100,555,10};
	BubbleSort(arr,0,11);
	
	for (int i=0; i<12; i++)
		printf("%d,",arr[i]);
	return 0;
}