/* Lab 2 - Task 1 
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
#define STACK_EMPTY		INT_MIN			// = -2147483648


/* Struct: node of the stack */
typedef struct 
{
	int ID;
	char Name[50];
	int Grades[4];
}Student;

typedef struct 
{
	Student Data;
	struct node* Next;
}node;

/* Initializtion of top = NULL */
node* top = NULL;

/* 
    Function: puch() 
    Push elements to Stack
    return: - true(1)  if Stack is not full 
            - false(0) if Stack is full
*/
bool push(Student data) 
{
	node* newNode = (node*)malloc(sizeof(node));
    if (newNode == NULL) 
	{
        //printf("Stack push cannot allocate memory!\n");
        return false;
    }
	else
	{
		newNode->Data = data;
		newNode->Next = top;
		top           = newNode; 
		return true;
	}
}

/* 
	Function: isEmpty() 
	return: - true(1)  if Stack is empty 
            - false(0) if Stack is not empty
*/
bool isEmpty(void)
{
    return(top == NULL);
}

/* 
	Function: pop()
	return: Top value "Stack is LIFO"
*/	
Student pop(void) 
{
	Student result;
	node* temp;
    if (isEmpty()) 
	{
		result.ID = STACK_EMPTY;
        printf("Nothing to take from stack!\n");
    }
	else
	{
		result = top->Data;
		temp = top;
		top = top->Next;
		temp->Next = NULL;
		free(temp);
	}
	return result;
}

/*
    Function: peek() (getTop())
	return: Top value "Stack is LIFO"
*/
Student peek() 
{
	Student retVal;
    if (top == NULL) 
	{
        printf("Nothing to take from stack!\n");
		retVal.ID = STACK_EMPTY;
        return retVal;
    }
	else
	{
		return (top->Data);
	}
}

/* 
	Function: print()
	Print all elements of the Stack till top
*/

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
	//printf("Stack Elements: ");
	node* temp = (node*)malloc(sizeof(node));
	temp = top;
	while(temp != NULL)
	{
		print_Student(temp->Data);
		temp = temp->Next;
	}
	//printf("\n");
	free(temp);
}


void fill_Student(void)
{
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
	push(student);	
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
    printf("\t**1-PUSH**************");
	gotoxy(5,7);
    printf("\t**2-POP***************");
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
					std = pop();
					if (std != STACK_EMPTY)
					{
						print_Student(std);
					}
					printf("Done\n");
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