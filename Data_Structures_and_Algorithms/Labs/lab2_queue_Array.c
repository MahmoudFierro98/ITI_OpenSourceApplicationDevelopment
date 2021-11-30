/* Lab 2 - Task 2
   Author: Mahmoud Kamal
   Date:   30-11-2021
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>
#include<stdbool.h>
#include<limits.h>


/* Macros */
#define QUEUE_LENGTH 	5
#define EMPTY			(-1)
#define QUEUE_FULL		(QUEUE_LENGTH-1)
#define QUEUE_EMPTY		INT_MIN			// = -2147483648

/* Global Variables */
typedef struct 
{
	int ID;
	char Name[50];
	int Grades[4];
}Student;

Student queue[QUEUE_LENGTH];	// Items of the Queue
int last = EMPTY;         		// Last of the Queue
int front = EMPTY;         		// Front of the Queue

/* 
	Function: puch() 
	Push elements to Stack
	return: - true(1)  if Stack is not full 
            - false(0) if Stack is full
*/
bool enqueue(Student data) 
{
    if (last >= QUEUE_FULL) 
	{
        printf("There's no space in the stack!\n");
        return false;
    }
	else
	{
		if (front == EMPTY)
			front = 0;
		last++;
		queue[last] = data;
		return true;
	}
} 
 
Student dequeue(void)
{
	Student result;
    if (front == EMPTY)
    {
        //printf("Queue Underflow \n");
		result.ID = QUEUE_EMPTY;
    }
    else
    {
		result = queue[front];
		for(int i=front; i<last; i++)
		{
			queue[i] = queue[i+1];
		}
		last--;
    }
	return result;
}

void fill_Student(void)
{
	bool flag;
	Student student;
	printf("\nEnter ID of the student: ");
	scanf("%d",&(student.ID));
	printf("Student Name: ");
	scanf("%s",student.Name);
	for(int i=0; i<4; i++)
	{	
		printf("Grade of subject#%d: ",i+1);
		scanf("%d",&student.Grades[i]);
	}
	flag = enqueue(student);
	if (!flag)
	{
        printf("There's no space in the stack!\n");
	}		
}

void print_Student(Student student)
{
	int sum = 0;
	printf("\nStudent ID: %d, Name: %s\n",student.ID,student.Name);
	for (int i=0; i<4; i++)
	{
		sum += student.Grades[i];
	}
	printf("Sum of grades = %d\n\n",sum);
}
	
void print(void)
{
	int sum = 0;
	for (int i=0; i<=last; i++)
	{
		print_Student(queue[i]);
	}
	//printf("\n");
}

void gotoxy(int x, int y)
{
	COORD coord;
	coord.X = x;
	coord.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void menu(void)
{
	system("cls");
	gotoxy(5,5);
	printf("\t****Please Select*****");
	gotoxy(5,6);
    printf("\t**1-ENQUEUE***********");
	gotoxy(5,7);
    printf("\t**2-DEQUEUE***********");
	gotoxy(5,8);
    printf("\t**3-Display***********");
	gotoxy(5,9);
    printf("\t**4-Exit**************");
	gotoxy(5,10);
}

char getASCII(void)
{
	char ch;
	ch = getch();
	if (ch == -32)
	{
		ch = getch();
	}
	return ch;
}

int main(int argc, char* argv[]) 
{
	int select,flag,loc,de;
	char ch;
	Student std;std;
	flag = 1;
	while(flag)
	{
		menu();
		printf("Pleas Select: ");
		scanf("%d",&select);
		
		switch(select)
		{
			case 1:
				system("cls");
				fill_Student();
			break;
			case 2:
				system("cls");
				printf("Are you sure?? 1-Yes | 2-No: ");
				scanf("%d",&de);
				if (de == 1)
				{
					std = dequeue();
					if (std.ID != QUEUE_EMPTY)
					{
						print_Student(std);
						printf("Done\n");
					}
				}
				else if (de == 2)
				{
					printf("Nothing deleted\n");
				}
				else
				{
					printf("Error || wrong select\n");
				}
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
			case 3:
				system("cls");
				print();
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
			case 4:
				system("cls");
				printf("Bye see you next time :)");
				flag = 0;
			break;
			default:
				system("cls");
				printf("Error :: Wrong select!");
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
		}
	}
	return 0;
}