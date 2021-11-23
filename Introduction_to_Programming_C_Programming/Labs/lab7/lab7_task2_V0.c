/* Lab 7 - Task 2 - Version 0
   Author: Mahmoud Kamal
   Date:   23-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>
#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>

/* Macros */
#define START_ROW 	5
#define ADD_ROW  	START_ROW+1
#define DIS_ROW  	START_ROW+2
#define DIS_ALL_ROW START_ROW+3
#define EXIT_ROW  	START_ROW+4

/* Global Variables */
int studentsNumber;

/* Struct */
struct Student
{

    int id;
    char name[50];
    int grades[4];
};

/* Prototypes */
void gotoxy(int x, int y);
char getASCII(void);
void menu(void);
struct Student* fill_Student(void);
void print_Student(struct Student* student,int ID);
void print_All_Students(struct Student* student);

int main()

{
	/* Variables Declaration */
    int input = START_ROW, ID;
	int flag = 1;
	char ch;
	struct Student* student;
	
	/* User Inputs */
	menu();
	input = ADD_ROW;

    while (flag)
    {
		ch = getASCII();
		if(ch == 80)
		{
			input += 1;
			if(input > EXIT_ROW)
			{
				input = ADD_ROW;
			}
			gotoxy(5,input);
		}
		else if (ch == 72)
		{
			input -= 1;
			if(input < ADD_ROW)
			{
				input = EXIT_ROW;
			}
			gotoxy(5,input);
		}
		else if (ch == 13)
		{
			system("cls");
			if (input == ADD_ROW)
			{
				student = fill_Student();
				system("cls");
				menu();
				input = ADD_ROW;
			}
			else if (input == DIS_ROW)
			{
                printf("Enter ID of the student: ");
                scanf("%d",&ID);
                print_Student(student,ID);
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
					input = ADD_ROW;
				}
			}
			else if (input == DIS_ALL_ROW)
			{
				print_All_Students(student);
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
					input = ADD_ROW;
				}
			}
			else if (input == EXIT_ROW)
			{
				system("cls");
				flag = 0;
			}
        }
    }
}

void gotoxy(int x, int y)
{
	COORD coord;
	coord.X = x;
	coord.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
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

void menu(void)
{
	system("cls");
	gotoxy(5,START_ROW);
	printf("\t****Please Select********");
	gotoxy(5,ADD_ROW);
    printf("\t****Add Students*********");
	gotoxy(5,DIS_ROW);
    printf("\t****Disply Student*******");
	gotoxy(5,DIS_ALL_ROW);
    printf("\t****Disply all Students**");
	gotoxy(5,EXIT_ROW);
    printf("\t****4-Exit***************");
	gotoxy(5,ADD_ROW);
}

struct Student* fill_Student(void)
{
    struct Student* student;
	printf("Enter the number of students: ");
    scanf("%d",&studentsNumber);
    student = (struct student*)malloc((studentsNumber)*sizeof(struct Student));
    for (int i=0; i<studentsNumber; i++)
	{
		printf("\nSTUDENT #%d \n",i+1);
		printf("Enter student ID: ");
		scanf("%d",&student[i].id);
		printf("Name: ");
		scanf("%s",student[i].name);
		for (int j=0; j<4; j++)
		{
		printf("Grade of subject#%d: ",j+1);
		scanf("%d",&student[i].grades[j]);
		}
	}
	return student;
}

void print_Student(struct Student* student,int ID)
{
    int sum=0,flag = 0;
	for (int i=0; i<studentsNumber; i++)
    {
        if (ID == student[i].id)
        {
			printf("Student ID: %d, Name: %s\n",student[i].id,student[i].name);
			for (int j=0;j<4;j++)
			{
				sum += student[i].grades[j];
			}
			printf("Sum of grades = %d\n\n",sum);
			flag = 1;
		}
		else
		{
			/* Do Nothing */
		}
    }
	if (!flag)
	{
		printf("Wrong ID || There is no student with this ID\n\n");
	}
	else
	{
		/* Do Nothing */
	}
}

void print_All_Students(struct Student* student)
{
    int sum=0;
	for (int i=0; i<studentsNumber; i++)
    {
		sum=0;
		printf("Student ID: %d, Name: %s\n",student[i].id,student[i].name);
        for (int j=0;j<4;j++)
        {
            sum += student[i].grades[j];
        }
		printf("Sum of grades = %d\n\n",sum);
    }
}
