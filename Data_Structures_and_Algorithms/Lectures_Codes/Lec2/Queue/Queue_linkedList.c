/* Lec 2 - Queue (linkedList) 
   Author: Mahmoud Kamal
   Date:   29-11-2021
   File:   Queue_linkedList.c
*/

/* Libraries inclusion */ 
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

/* Macros */
#define QUEUE_EMPTY		INT_MIN			// = -2147483648

/* Struct: node of the queue */
typedef struct 
{
	int Data;
	struct node* pNext;
}node;

/* Initializtion of Head & Tail = NULL */
node* pHead = NULL;
node* pTail = NULL;

/* 
    Function: enqueue()
*/
bool enqueue(int data) 
{
	node* newNode = (node*)malloc(sizeof(node));
    if (newNode == NULL) 
	{
        printf("Queue cannot allocate memory!\n");
        return false;
    }
	else
	{
		newNode->Data = data;
		newNode->pNext = NULL;
		if(!pHead)
		{
			pHead = newNode;
		}
		else
		{
			pTail->pNext = newNode;
		}
		pTail = newNode;
		return true;
	}
}

/* 
	Function: isEmpty() 
	return: - true(1)  if Queue is empty 
            - false(0) if Queue is not empty
*/
bool isEmpty(void)
{
    return(pHead == NULL);
}

/* 
	Function: dequeue()
	return: First value "Queue is FIFO"
*/	
int dequeue() 
{
	int result = QUEUE_EMPTY;
	node* temp = (node*)malloc(sizeof(node));
    if (isEmpty()) 
	{
        printf("Nothing to take from Queue!\n");
    }
	else
	{
		result = pHead->Data;
		temp = pHead;
		pHead = pHead->pNext;
		free(temp);
	}
	return result;
}

int main(int argc, char* argv[]) 
{
    return 0;
}