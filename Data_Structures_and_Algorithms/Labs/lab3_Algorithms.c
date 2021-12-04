/* lab 3 - Algorithms
   Author: Mahmoud Kamal
   Date:   04-12-2021
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>

typedef struct 
{
	int ID;
	char Name[50];
}Student;

Student arr1[5] = {{102, "Mahmoud"}, {104, "Mohamed"}, {100, "Ahmed"}, {105, "Ibra"}, {101, "Liva"}};

/* Bubble Sort */
/* By Name */
void BubbleSort(Student* arr, int low, int high)
{
	int Swapped = 1, outerCounter, innerCounter;
	Student temp;
	
	for (outerCounter=low; (outerCounter<high)&&Swapped; outerCounter++)
	{
		Swapped = 0;
		for (innerCounter=0; innerCounter<high-outerCounter; innerCounter++)
		{
			if (strcmp(arr[innerCounter].Name,arr[innerCounter+1].Name) > 0)
			{
				temp = arr[innerCounter];
				arr[innerCounter] = arr[innerCounter+1];
				arr[innerCounter+1] = temp;
				Swapped = 1;
			}
		}
	}
}

/* Merge Sort */
/* By ID */
void Merge(int low, int mid, int high)
{
	Student temp[5];
	int list1, list2, counter;
	
	list1 = counter =low;
	list2 = mid+1;
	
	while((list1 <= mid) && (list2 <= high))
	{
		if(arr1[list1].ID < arr1[list2].ID)
		{
			temp[counter] = arr1[list1];
			list1 ++;
		}
		else
		{
			temp[counter] = arr1[list2];
			list2 ++;
		}
		counter++;
	}
	while(list1 <= mid)
	{
		temp[counter] = arr1[list1];
		list1 ++;
		counter++;
	}
	while(list2 <= high)
	{
		temp[counter] = arr1[list2];
		list2 ++;
		counter++;
	}
	for (int iterator=low; iterator<=high; iterator++)
	{
		arr1[iterator] = temp[iterator];
	}
}
void MergeSort(int low, int high)
{
	int mid;

	if (low < high)
	{
		mid = (low+high)/2;
		MergeSort(low,mid);
		MergeSort(mid+1,high);
		Merge(low,mid,high);
	}
}

/* Binary Search */
/* By ID */
int BinarySearch_ID(Student* arr, int LB, int UB, int data)
{
	int mid, loc=-1;
	
	while((LB<=UB) && (loc==-1))
	{
		mid = (LB+UB)/2;
		if(arr[mid].ID==data)
		{
			loc = mid;
		}
		else if (arr[mid].ID < data)
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
/* By Name */
int BinarySearch_Name(Student* arr, int LB, int UB, char* data)
{
	int mid, loc=-1;
	
	while((LB<=UB) && (loc==-1))
	{
		mid = (LB+UB)/2;
		if(strcmp(arr[mid].Name,data) == 0)
		{
			loc = mid;
		}
		else if(strcmp(arr[mid].Name,data) < 0)
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



int main(void)
{
	int ret, id;
	char* name;
	
	printf("Before Bubble Sort:\n");
	for(int i=0; i<5; i++)
		printf("ID: %d - Name: %s\n",arr1[i].ID,arr1[i].Name);
	BubbleSort(arr1, 0, 4);
	printf("\nAfter Bubble Sort:\n");
	for(int i=0; i<5; i++)
		printf("ID: %d - Name: %s\n",arr1[i].ID,arr1[i].Name);
	
	
	printf("\nBefore Merge Sort:\n");
	for(int i=0; i<5; i++)
		printf("ID: %d - Name: %s\n",arr1[i].ID,arr1[i].Name);
	MergeSort(0, 4);
	printf("\nAfter Merge Sort:\n");
	for(int i=0; i<5; i++)
		printf("ID: %d - Name: %s\n",arr1[i].ID,arr1[i].Name);
	
	
	printf("\nSearch by ID\n");
	printf("ID: ");
	scanf("%d",&id);
	ret = BinarySearch_ID(arr1, 0, 4, id);
	(ret == -1)? printf("Not found\n"):printf("Found || ID: %d - Name: %s\n",arr1[ret].ID,arr1[ret].Name);
	
	
	printf("\nSearch by Name\n");
	printf("Name: ");
	scanf("%s",name);
	ret = BinarySearch_Name(arr1, 0, 4, name);
	(ret == -1)? printf("Not found\n"):printf("Found || ID: %d - Name: %s\n",arr1[ret].ID,arr1[ret].Name);
	return 0;
}
