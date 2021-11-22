/* Lab 4 - Task 2
   Author: Mahmoud Kamal
   Date:   13-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>

void main()
{
	float grades[5][6] = {0}; // Col4: Total, Col5: Average, Row3: Total For each Subject, Row4: Average For each Subject
	
	for (int i=0; i<3; i++)
	{
		printf("**Enter Grades Student#%d**\n",i+1);
		for (int j=0; j<4; j++)
		{	
			printf("Subject#%d: ",j+1);
			scanf("%f",&grades[i][j]);
			grades[i][4] += grades[i][j];
		}
		printf("\n\n");
	}
	
	/* Average */
	for (int i=0; i<4; i++)
	{
		grades[i][5] = grades[i][4]/4;
	}
	/* For each Subject */
	for (int i=0; i<4; i++)
	{
		for (int j=0; j<3; j++)
		{
			grades[3][i] += grades[j][i];
		}
	}
	/* Average */
	for (int i=0; i<4; i++)
	{
		grades[4][i] = grades[3][i]/3;
	}
	
	system("cls");
	for (int i=0; i<3; i++)
	{
		printf("\t**Grades of Student#%d**\n",i+1);
		for (int j=0; j<6; j++)
		{	
			if (j==4)
				printf("\tTotal: %0.2f\n",grades[i][j]);
			else if (j==5)
				printf("\tAverage: %0.2f\n",grades[i][j]);
			else
				printf("\tSubject#%d: %0.2f\n",j+1,grades[i][j]);
		}
		printf("\n\n");
	}
	for (int i=0; i<4; i++)
	{
		printf("\t**Subject#%d**\n",i+1);
		printf("\tTotal: %0.2f\n",grades[3][i]);	
		printf("\tAverage: %0.2f\n",grades[4][i]);
		printf("\n\n");
	}
	
}