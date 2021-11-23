/* Lab 2 - Task 2
   Author: Mahmoud Kamal
   Date:   03-11-2021
*/
#include <stdio.h>
#include <stdlib.h>

int main()
{
	/* Variables Declaration */
    float num;
    float sum = 0;
	
    /* Operation */
	do{ 
		/* User Inputs */
		printf("Enter The Number: ");
		scanf("%f",&num);
		sum += num;
	}while(sum <= 100);
	
	printf("\n\n\n\nSum = %0.2f",sum);
	return 0;
}