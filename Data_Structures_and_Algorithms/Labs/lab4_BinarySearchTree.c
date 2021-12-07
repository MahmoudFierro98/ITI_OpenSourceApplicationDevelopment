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

void main(void)
{
	struct Node* pRoot;
	pRoot = NULL;
	pRoot = InsertNode(pRoot,5);
	InsertNode(pRoot,4);
	InsertNode(pRoot,6);
	InsertNode(pRoot,3);
	InsertNode(pRoot,8);
	InsertNode(pRoot,7);
	
	printf("InOrder: \n");
	printInOrder(pRoot);
	printf("PreOrder: \n");
	printPreOrder(pRoot);
	printf("PostOrder: \n");
	printPostOrder(pRoot);
}