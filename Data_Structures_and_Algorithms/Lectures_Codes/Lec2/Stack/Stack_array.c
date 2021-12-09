/* Lec 2 - Stack (Array) 
   Author: Mahmoud Kamal
   Date:   29-11-2021
   File:   Stack_array.c
*/

/* Libraries inclusion */ 
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

/* Macros */
#define STACK_LENGTH 	5
#define EMPTY			(0)
#define STACK_FULL		(STACK_LENGTH-1)
#define STACK_EMPTY		INT_MIN			// = -2147483648

/* Global Variables */
int stack[STACK_LENGTH];	// Items of the Stack
int top = EMPTY;         	// Top of the Stack

/* 
	Function: puch() 
	Push elements to Stack
	return: - true(1)  if Stack is not full 
            - false(0) if Stack is full
*/
bool push(int value) 
{
    if (top >= STACK_FULL) 
	{
        printf("There's no space in the stack!\n");
        return false;
    }
	else
	{
		stack[top] = value;
		top++;
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
    if (top == EMPTY)
    {
        return true;
    }
    else
    {
        return false;
    }
}

/* 
	Function: pop()
	top--
	return: Top value "Stack is LIFO"
*/	
int pop(void) 
{
	int result = STACK_EMPTY;
    if (isEmpty()) 
	{
        printf("Nothing to take from stack!\n");
    }
	else
	{
		top--;
		result = stack[top];
	}
	return result;
}

/* 
	Function: peek() (getTop())
	return: Top value "Stack is LIFO"
*/	
int peek(void) 
{
    if (isEmpty()) 
	{
        printf("Nothing to take from stack!\n");
        return STACK_EMPTY;
    }
	else
	{
		return (stack[top-1]);
	}
}

/* 
	Function: print() 
	Print all elements of the Stack till top
*/	
void print(void)
{
	printf("Stack Elements: ");
	for (int counter=top-1; counter>=0; counter--)
	{
		printf("%d ", stack[counter]);
	}
	printf("\n");
}

int main(int argc, char* argv[]) 
{
    return 0;
}