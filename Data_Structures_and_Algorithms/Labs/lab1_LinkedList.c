/* Lab 1 - Task 1 
   Author: Mahmoud Kamal
   Date:   29-11-2021
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>

struct Student
{
	int ID;
	char Name[50];
	int Grades[4];
};

struct node
{
       struct Student Data;
       struct node* Prev;
       struct node* Next;
};
struct node* pHead;
struct node* pTail;

/* Prototypes */
struct node* createNode(void);
int addNode(void);
int insertNode(int loc);
struct Student searchNode_ID(int id);
struct Student searchNode_Name(char* name);
int deleteNode(int loc);
void freeNode(void);
struct Student fill_Student(void);
void print_AllStudents(void);
void print_Student(struct Student student);
void gotoxy(int x, int y);
void menu(void);
char getASCII(void);

int main(void)
{
	int select,flag,loc,de;
	char ch;
	char name[50];
	struct Student std;
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
				addNode();
			break;
			case 2:
				system("cls");
				printf("Put location to insert: ");
				scanf("%d",&loc);
				insertNode(loc);
			break;
			case 3:
				system("cls");
				printf("ID: ");
				scanf("%d",&loc);
				std = searchNode_ID(loc);
				if (std.ID == -1)
				{
					printf("Not found\n");
				}
				else
				{
					print_Student(std);
				}
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
			case 4:
				system("cls");
				printf("Name: ");
				scanf("%s",name);
				std = searchNode_Name(name);
				if (std.ID == -1)
				{
					printf("Not found\n");
				}
				else
				{
					print_Student(std);
				}
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
			case 5:
				system("cls");
				printf("Location to delete: ");
				scanf("%d",&loc);
				de = deleteNode(loc);
				if(de)
				{
					printf("Are you sure?? 1-Yes | 2-No: ");
					scanf("%d",&de);
					if (de == 1)
					{
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
				}
				else
				{
					printf("Error || wrong location\n");
				}
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
			case 6:
				system("cls");
				printf("Are you sure?? 1-Yes | 2-No: ");
				scanf("%d",&de);
				if (de == 1)
				{
					printf("Done all data deleted\n");
					freeNode();
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
			case 7:
				system("cls");
				print_AllStudents();
				printf("\nPress HOME to show menu\n");
				ch = getASCII();
				if (ch == 71)
				{
					menu();
				}
			break;
			case 8:
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

struct node* createNode(void)
{
	struct node* ptr;
	ptr = (struct node*)malloc(sizeof(struct node));
	if(ptr)
	{
		ptr->Data = fill_Student();
		ptr->Prev = NULL;
		ptr->Next = NULL;
	}
	else
	{
		/* Do Nothing */
	}
}

int addNode(void)
{
	int retVal = 0;
	struct node* ptr;
	ptr = createNode();
	if (ptr)
	{
		if (!pHead)
		{
			pHead = ptr; 
		}
		else
		{
			ptr->Prev = pTail;
			pTail->Next = ptr;
		}
		pTail = ptr;
		retVal = 1;
	}
	else
	{
		/* Do Nothing */ 
	}
	return retVal;
}

int insertNode(int loc)
{
	int retVal = 0;
	struct node* ptr;
	struct node* cur;
	ptr = createNode();
	if (ptr)
	{
		if (!pHead)
		{
			pHead = pTail = ptr; 
		}
		else
		{
			if (!loc)
			{
				ptr->Next = pHead;
				pHead->Prev = ptr;
				pHead = ptr; 
			}
			else
			{
				cur = pHead;
				for (int i=0; (i<(loc-1))&&cur; i++)
				{
					cur = cur->Next;	
				}
				if ((cur == NULL) || (cur==pTail))
				{					
					ptr->Prev = pTail;
					pTail->Next = ptr;
					pTail = ptr;
				}
				else
				{
					ptr->Next = cur->Next;
					cur->Next->Prev = ptr;
					cur->Next = ptr;
					ptr->Prev = cur;
				}
			}
		}
		retVal = 1;
	}
	else
	{
		/* Do Nothing */ 
	}
	return retVal;
}

struct Student searchNode_ID(int id)
{
	struct node* ptr;
	struct Student st;
	for(ptr = pHead; ((ptr)&&((ptr->Data).ID!=id)); ptr=ptr->Next);
	if(!ptr)
	{
		st.ID = -1;
	}
	else
	{
		st = ptr->Data;
	}
	return st;
}

struct Student searchNode_Name(char* name)
{
	struct node* ptr;
	struct Student st;
	for(ptr = pHead; ((ptr)&&strcmp((ptr->Data).Name,name)); ptr=ptr->Next);
	if(!ptr)
	{
		st.ID = -1;
	}
	else
	{
		st = ptr->Data;
	}
	return st;
}

int deleteNode(int loc)
{
	int retVal = 0;
	struct node* cur;
	if(pHead)
	{
		cur = pHead;
		if (!loc)
		{
			pHead = pHead->Next;
			pHead->Prev = NULL;
			free(cur);
			retVal = 1;
		}
		else
		{
			for (int i=0; (i<loc)&&cur; i++)
			{
				cur = cur->Next;	
			}
			if(cur)
			{
				if (cur==pTail)
				{				
					pTail = cur->Prev;
					pTail->Next = NULL;
				}
				else
				{
					cur->Prev->Next = cur->Next;
					cur->Next->Prev = cur->Prev;
				}
				retVal = 1;
				free(cur);
			}
		}
	}
	return retVal;
}

void freeNode(void)
{
	struct node* ptr;
	while (pHead)
	{
		ptr = pHead;
		pHead = pHead->Next;
		free(ptr);
	}
	pTail = NULL;
}

struct Student fill_Student(void)
{
	struct Student student;
	printf("\nEnter ID of the student: ");
	scanf("%d",&(student.ID));
	printf("Student Name: ");
	scanf("%s",student.Name);
	for(int i=0; i<4; i++)
	{	
		printf("Grade of subject#%d: ",i+1);
		scanf("%d",&student.Grades[i]);
	}
	return student;	
}

void print_AllStudents(void)
{
	struct node* ptr;
	int sum = 0;
	
	for(ptr = pHead; ptr; ptr=ptr->Next)
	{
		sum = 0;
		printf("\nStudent ID: %d, Name: %s\n",(ptr->Data).ID,(ptr->Data).Name);
		for (int i=0; i<4; i++)
		{
			sum += (ptr->Data).Grades[i];
		}
		printf("Sum of grades = %d\n\n",sum);
	}
}

void print_Student(struct Student student)
{
	int sum = 0;
	printf("\nStudent ID: %d, Name: %s\n",student.ID,student.Name);
	for (int i=0; i<4; i++)
	{
		sum += student.Grades[i];
	}
	printf("Sum of grades = %d\n\n",sum);
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
	printf("\t****Please Select************");
	gotoxy(5,6);
    printf("\t**1-Add Student**************");
	gotoxy(5,7);
    printf("\t**2-Insert Student***********");
	gotoxy(5,8);
    printf("\t**3-Search Students by ID****");
	gotoxy(5,9);
    printf("\t**4-Search Students by Name**");
	gotoxy(5,10);
    printf("\t**5-Delete Student***********");
	gotoxy(5,11);
    printf("\t**6-Free the list************");
	gotoxy(5,12);
    printf("\t**7-Display******************");
	gotoxy(5,13);
    printf("\t**8-Exit*********************");
	gotoxy(5,14);
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