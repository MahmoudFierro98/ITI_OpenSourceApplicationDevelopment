/* lab 4 - Binary Search Tree
   Author: Mahmoud Kamal
   Date:   07-12-2021
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>

struct Node
{
	int Data;
	struct Node* pLeft;
	struct Node* pRight;
};

struct Node* CreateNode(int data)
{
	struct Node* ptr;
	ptr = (struct Node*)malloc(sizeof(struct Node));
	if(ptr)
	{
		ptr->Data = data;
		ptr->pLeft = NULL;
		ptr->pRight = NULL;
	}
	return ptr;
}

struct Node* InsertNode(struct Node* pNode, int data)
{
	if(!pNode)
	{
		pNode = CreateNode(data);
	}
	else if (pNode->Data > data)
	{
		pNode->pLeft = InsertNode(pNode, data);
	}
	else
	{
		pNode->pRight = InsertNode(pNode, data);
	}
	
	return pNode;
}

void printInOrder(struct Node* pNode)
{
	if(pNode)
	{
		/* 1- Traverse Left Branch */
		printInOrder(pNode->pLeft);
		/* 2- Process the Root */
		printf("%d\n",pNode->Data);
		/* 3- Traverse Right Branch */
		printInOrder(pNode->pRight);
	}
}

void printPreOrder(struct Node* pNode)
{
	if(pNode)
	{
		/* 1- Process the Root */
		printf("%d\n",pNode->Data);
		/* 2- Traverse Left Branch */
		printPreOrder(pNode->pLeft);
		/* 3- Traverse Right Branch */
		printPreOrder(pNode->pRight);
	}
}

void printPostOrder(struct Node* pNode)
{
	if(pNode)
	{
		/* 1- Process the Root */
		printf("%d\n",pNode->Data);
		/* 2- Traverse Left Branch */
		printPostOrder(pNode->pLeft);
		/* 3- Traverse Right Branch */
		printPostOrder(pNode->pRight);
	}
}

void menu(void)
{
    printf(" 1- Add element to the tree\n");
    printf(" 2- Display InOrder\n");
    printf(" 3- Display PreOrder\n");
    printf(" 4- Display PostOrder\n");
    printf(" 5- EXIT\n");
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

void main(void)
{
	int flag = 1, select, data;
	char ch;
	struct Node* pRoot;
	pRoot = NULL;
	
	while(flag)
	{
		system("cls");
		menu();
		printf("Pleas Select: ");
		scanf("%d",&select);
		
		switch(select)
		{
			case 1:
				system("cls");
				printf("Enter data: ");
				scanf("%d",&data);
				pRoot = InsertNode(pRoot,data);
			break;
			case 2:
				system("cls");
				printf("InOrder: \n");
				printInOrder(pRoot);
				printf("\nPress any key to show menu\n");
				ch = getASCII();
			break;
			case 3:
				system("cls");
				printf("PreOrder: \n");
				printPreOrder(pRoot);
				printf("\nPress any key to show menu\n");
				ch = getASCII();
			break;
			case 4:
				system("cls");
				printf("PostOrder: \n");
				printPostOrder(pRoot);
				printf("\nPress any key to show menu\n");
				ch = getASCII();
			break;
			case 5:
				system("cls");
				printf("Bye Bye\n");
				flag = 0;
			break;
			default:
				printf("Error || Wrong Select\n");
				printf("\nPress any key to show menu\n");
				ch = getASCII();
			break;
		}
	}
}
