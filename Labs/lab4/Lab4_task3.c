/* Lab 4 - Task 3
   Author: Mahmoud Kamal
   Date:   13-11-2021
*/
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

int Pow(int base, int index)
{
	if (index != 0)
	{
		return(base*Pow(base, index-1));
	}
	else
	{
		return 1;
	}
}
void main()
{
	int base=0, index=0, result=0;
    printf("Enter base number: ");
    scanf("%d", &base);
    printf("Enter power number(positive integer): ");
    scanf("%d", &index);
    result = Pow(base, index);
    printf("%d^%d = %d", base, index, result);
}
