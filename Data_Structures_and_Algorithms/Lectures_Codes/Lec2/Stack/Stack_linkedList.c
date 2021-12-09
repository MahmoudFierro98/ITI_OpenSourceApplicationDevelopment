/* Lec 2 - Stack (linkedList) 
   Author: Mahmoud Kamal
   Date:   29-11-2021
   File:   Stack_linkedList.c
*/

/* Libraries inclusion */ 
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

/* Macros */
#define STACK_EMPTY		INT_MIN			// = -2147483648

/* Struct: node of the stack */
typedef struct 
{
	int value;
	struct node* down;
}node;

/* Initializtion of top = NULL */
node* top = NULL;

/* 
    Function: puch() 
    Push elements to Stack
    return: - true(1)  if Stack is not full 
            - false(0) if Stack is full
*/
bool push(int value) 
{
	node* newNode = (node*)malloc(sizeof(node));
    if (newNode == NULL) 
	{
        printf("Stack push cannot allocate memory!\n");
        return false;
    }
	else
	{
		newNode->value = value;
		newNode->down  = top;
		top            = newNode; 
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
int pop() 
{
	int result = STACK_EMPTY;
	node* temp = (node*)malloc(sizeof(node));
    if (isEmpty()) 
	{
        printf("Nothing to take from stack!\n");
    }
	else
	{
		result = top->value;
		temp = top;
		top = top->down;
		temp->down = NULL;
		free(temp);
	}
	return result;
}

/*
    Function: peek() (getTop())
	return: Top value "Stack is LIFO"
*/
int peek() 
{
    if (top == NULL) 
	{
        printf("Nothing to take from stack!\n");
        return STACK_EMPTY;
    }
	else
	{
		return (top->value);
	}
}

/* 
	Function: print()
	Print all elements of the Stack till top
*/	
void print(void)
{
	printf("Stack Elements: ");
	node* temp = (node*)malloc(sizeof(node));
	temp = top;
	while(temp != NULL)
	{
		printf("%d ", temp->value);
		temp = temp->down;
	}
	printf("\n");
	free(temp);
}


int main(int argc, char* argv[]) 
{
    return 0;
}