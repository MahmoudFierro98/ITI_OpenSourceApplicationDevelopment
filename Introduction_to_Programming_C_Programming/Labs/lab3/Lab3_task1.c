/* Lab 3 - Task 1 
   Author: Mahmoud Kamal
   Date:   09-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>

/* Macros */
#define START_ROW 5
#define ADD_ROW   START_ROW+1
#define SUB_ROW   START_ROW+2
#define MUL_ROW   START_ROW+3
#define DIV_ROW   START_ROW+4
#define EXIT_ROW  START_ROW+5

/* Prototypes */
void gotoxy(int x, int y);
void Menu();
char getASCII(void);
float Add(float num1, float num2);
float Subtract(float num1, float num2);
float Multiply(float num1, float num2);
float Divided(float num1, float num2);

int main()
{
	/* Variables Declaration */
    int input = START_ROW, num1,num2,output;
	int flag = 1;
	char ch;
	
	/* User Inputs */
	Menu();
	input = ADD_ROW;
	
	while(flag)
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
				printf("Enter Num1: ");
				scanf("%d",&num1);
				printf("Enter Num2: ");
				scanf("%d",&num2);
				output = Add(num1,num2);
				printf("%d + %d = %d",num1,num2,output);
				printf("\n\nPress Enter to repeat operation");
				printf("\nPress HOME  to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					Menu();
					input = ADD_ROW;
				}
			}
			else if (input == SUB_ROW)
			{
				printf("Enter Num1: ");
				scanf("%d",&num1);
				printf("Enter Num2: ");
				scanf("%d",&num2);
				output = Subtract(num1,num2);
				printf("%d - %d = %d",num1,num2,output);
				printf("\n\nPress Enter to repeat operation");
				printf("\nPress HOME  to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					Menu();
					input = ADD_ROW;
				}
			}
			else if (input == MUL_ROW)
			{
				printf("Enter Num1: ");
				scanf("%d",&num1);
				printf("Enter Num2: ");
				scanf("%d",&num2);
				output = Multiply(num1,num2);
				printf("%d * %d = %d",num1,num2,output);
				printf("\n\nPress Enter to repeat operation");
				printf("\nPress HOME  to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					Menu();
					input = ADD_ROW;
				}
			}
			else if (input == DIV_ROW)
			{
				printf("Enter Num1: ");
				scanf("%d",&num1);
				printf("Enter Num2: ");
				scanf("%d",&num2);
				output = Divided(num1,num2);
				printf("%d / %d = %d",num1,num2,output);
				printf("\n\nPress Enter to repeat operation");
				printf("\nPress HOME  to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					Menu();
					input = ADD_ROW;
				}
			}
			else if (input == EXIT_ROW)
			{
				flag = 0;
			}
		}
	}
	return 0;
}

void gotoxy(int x, int y)
{
	COORD coord;
	coord.X = x;
	coord.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void Menu(int startRow)
{
	system("cls");
	gotoxy(5,START_ROW);
	printf("\t****Please Select***");
	gotoxy(5,ADD_ROW);
	printf("\t****1-Add***********");
	gotoxy(5,SUB_ROW);
	printf("\t****2-Subtract******");
	gotoxy(5,MUL_ROW);
	printf("\t****3-Multiply******");
	gotoxy(5,DIV_ROW);
	printf("\t****4-Divided*******");
	gotoxy(5,EXIT_ROW);
	printf("\t****5-Exit**********");
	gotoxy(5,ADD_ROW);
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

float Add(float num1, float num2)
{
	return (num1+num2);
}

float Subtract(float num1, float num2)
{
	return (num1-num2);
}

float Multiply(float num1, float num2)
{
	return (num1*num2);
}

float Divided(float num1, float num2)
{
	if (!num2)
		return -1;
	else
		return (num1/num2);
}