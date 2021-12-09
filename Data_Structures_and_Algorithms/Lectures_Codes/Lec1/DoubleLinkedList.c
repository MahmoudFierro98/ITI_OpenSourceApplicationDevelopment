/* Lec 1 - Double Linked List 
   Author: Mahmoud Kamal
   Date:   28-11-2021
   File:   DoubleLinkedList.c
*/

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>

struct node
{
    int Data;
    struct node* pPrev;
    struct node* pNext;
};
struct node* pHead;
struct node* pTail;

/* Prototypes */
struct node* createNode(int data);
int addNode(int data);
int insertNode(int data, int loc);
struct Node* searchNode(int data);
int deleteNode(int loc);
void freeNode(void);

int main(void)
{
	return 0;
}

struct node* createNode(int data)
{
	struct node* ptr;
	ptr = (struct node*)malloc(sizeof(struct node));
	if(ptr)
	{
		ptr->Data = data;
		ptr->pPrev = NULL;
		ptr->pNext = NULL;
	}
	else
	{
		/* Do Nothing */
	}
	return ptr;
}

int addNode(int data)
{
	int retVal = 0;
	struct node* ptr;
	ptr = createNode(data);
	if(ptr)
	{
		if(!pHead)
		{
			pHead = ptr; 
		}
		else
		{
			ptr->pPrev = pTail;
			pTail->pNext = ptr;
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

int insertNode(int data, int loc)
{
	int retVal = 0;
	struct node* ptr;
	struct node* pCur;
	ptr = createNode(data);
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
				ptr->pNext = pHead;
				pHead->pPrev = ptr;
				pHead = ptr; 
			}
			else
			{
				pCur = pHead;
				for (int i=0; (i<(loc-1))&&pCur; i++)
				{
					pCur = pCur->pNext;	
				}
				if ((pCur == NULL) || (pCur==pTail))
				{					
					ptr->pPrev = pTail;
					pTail->pNext = ptr;
					pTail = ptr;
				}
				else
				{
					ptr->pNext = pCur->pNext;
					ptr->pPrev = pCur;
					pCur->pNext->pPrev = ptr;
					pCur->pNext = ptr;
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

struct Node* searchNode(int data)
{
	struct node* ptr;
	for(ptr = pHead; ((ptr)&&((ptr->Data).ID!=id)); ptr=ptr->Next);
	return ptr;
}

int deleteNode(int loc)
{
	int retVal = 0;
	struct node* pCur;
	if(pHead)
	{
		pCur = pHead;
		if (!loc)
		{
			pHead = pHead->pNext;
			pHead->pPrev = NULL;
			free(pCur);
			retVal = 1;
		}
		else
		{
			for (int i=0; (i<loc)&&pCur; i++)
			{
				pCur = pCur->pNext;	
			}
			if(pCur)
			{
				if (pCur==pTail)
				{			
					pTail = pCur->pPrev;
					pTail->pNext = NULL;
				}
				else
				{
					pCur->pPrev->pNext = pCur->pNext;
					pCur->pNext->pPrev = pCur->pPrev;
				}
				retVal = 1;
				free(pCur);
			}
		}
	}
	return retVal;
}

void freeNode(void)
{
	struct node* ptr;
	while(pHead)
	{
		ptr = pHead;
		pHead = pHead->pNext;
		free(ptr);
	}
	pTail = NULL;
}