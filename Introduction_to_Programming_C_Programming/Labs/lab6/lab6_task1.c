/* Lab 6 - Task 1 
   Author: Mahmoud Kamal
   Date:   22-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>

/* Macros */
#define START_COL 	5
#define END_COL   	14
#define RIGHT_ARROW	77
#define LEFT_ARROW  75
#define ENTER_B     13
#define HOME_B      71
#define END_B      	79
#define DELETE_B    83
#define INSERT_B    82
#define BACKSPACE_B	8


/* Prototypes */
void gotoxy(int x, int y);
//char getASCII(void);

int main()
{
	/* Variables Declaration */
    char input[11] = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	char ch,temp;
	int currentCol = START_COL, flag = 0;
	
	/* User Inputs */
	system("cls");
	gotoxy(START_COL,8);
	printf("****The Line Editor****");
	
	while(1)
	{	
		gotoxy(currentCol,10);
		ch = getch();
		if (ch == -32)
		{
			ch = getch();
			flag = 1;
		}
		else
		{
			flag = 0;
		}
		if(ch == RIGHT_ARROW)
		{
			currentCol += 1;
			if(currentCol > END_COL)
			{
				currentCol = START_COL;
			}
			gotoxy(currentCol,10);
		}
		else if (ch == LEFT_ARROW)
		{
			currentCol -= 1;
			if(currentCol < START_COL)
			{
				currentCol = END_COL;
			}
			gotoxy(currentCol,10);
		}
		else if ((ch == HOME_B) && (flag == 1))
		{
			currentCol =  START_COL;
			gotoxy(currentCol,10);
		}
		else if (ch == END_B)
		{
			currentCol =  END_COL;
			gotoxy(currentCol,10);
		}
		else if (ch == ENTER_B)
		{
			gotoxy(20,20);
			printf("%s",input);
			break;
		}
		else if (ch == DELETE_B)
		{
			printf("%c",' ');
			input[currentCol-START_COL] = ' '; 
			gotoxy(currentCol,10);
		}
		else if (ch == INSERT_B)
		{
			for (int i=10; i>currentCol-START_COL; i--)
			{
				input[i] = input[i-1];
			}
			input[10] = '\0'; 
			gotoxy(START_COL,10);
			printf("%s",input);
			gotoxy(currentCol,10);
			printf("%c",' ');
			input[currentCol-START_COL] = ' '; 
		}
		else if (ch == BACKSPACE_B)
		{
			for (int i=currentCol-START_COL; i<10; i++)
			{
				input[i] = input[i+1];
			}
			input[10] = '\0';
			input[9]  = ' '; 
			gotoxy(START_COL,10);
			printf("%s",input);
			currentCol -= 1;
			gotoxy(currentCol,10);
		}
		else
		{
			if(currentCol <= END_COL)
			{
				printf("%c",ch);
				input[currentCol-START_COL] = ch; 
				currentCol += 1;
			}
			else
			{
				currentCol = END_COL+1;
			}
			gotoxy(currentCol,10);
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