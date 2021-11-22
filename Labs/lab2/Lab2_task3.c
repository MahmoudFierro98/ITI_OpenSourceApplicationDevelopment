/* Lab 2 - Task 3
   Author: Mahmoud Kamal
   Date:   03-11-2021
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
	/* Variables Declaration */
    float a,b,c,root;
    float x1,x2;

	/* User Inputs */
	printf("\t****Program to solve the second degree equation (ax^2 +bx+c=0 )****");
    printf("\nEnter a: ");
    scanf("%f",&a);
    printf("Enter b: ");
    scanf("%f",&b);
    printf("Enter c: ");
    scanf("%f",&c);
	
    /* Operation */
	root = (b*b)-4*a*c;
	if (root > 0)
	{
		/* +ve */
		x1 = (-b + sqrt(root)) / (2*a);
		x2 = (-b - sqrt(root)) / (2*a);
		printf("\nx1 = %0.2f, x2 = %0.2f",x1,x2);
	}
	else if (root < 0)
	{
		/* -ve */
		root *= -1;
		x1 = -b/(2*a);  			// Real
		x2 = sqrt(root) / (2*a);	// Imag
		printf("\nx1 = %0.2f+i%0.2f, x2 = %0.2f-i%0.2f",x1,x2,x1,x2);
	}
	else
	{
		/* 0 */
		x1 = -b/(2*a);
		printf("\nx1 = x2 = %0.2f",x1);
	}
	
	return 0;
}