/* Lec 2 - Queue (Array) 
   Author: Mahmoud Kamal
   Date:   29-11-2021
   File:   Queue_array.c
*/

/* Libraries inclusion */ 
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
int queue[QUEUE_LENGTH];	// Items of the Queue
int last = EMPTY;         		// Last of the Queue
int front = EMPTY;         		// Front of the Queue

/* 
    Function: enqueue()
*/
bool enqueue(int data) 
{
	if (last >= QUEUE_FULL) 
	{
        printf("There's no space in the Queue!\n");
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

/* 
	Function: isEmpty() 
	return: - true(1)  if Queue is empty 
            - false(0) if Queue is not empty
*/
bool isEmpty(void)
{
    if (last == EMPTY)
    {
        return true;
    }
    else
    {
        return false;
    }
}

/* 
	Function: dequeue()
	return: First value "Queue is FIFO"
*/	
int dequeue() 
{
	int result = QUEUE_EMPTY;
    if (front == EMPTY)
    {
        printf("Queue Underflow \n");
    }
    else
    {
		result = queue[front];
		for(int i=0; i<last; i++)
		{
			queue[i] = queue[i+1];
		}
		last--;
		if(last == EMPTY)
		{
			front = EMPTY;
		}
    }
	return result;
}

int main(int argc, char* argv[]) 
{
    return 0;
}