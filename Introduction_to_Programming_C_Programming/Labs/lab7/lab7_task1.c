/* Lab 7 - Task 1 
   Author: Mahmoud Kamal
   Date:   23-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
#include<string.h>

/* Prototypes */
struct Student fill_Student(void);
void print_Student(struct Student student);

struct Student
{
	int id;
	char name[50];
	int grades[4];
};

int main()
{
	/* For only one student */
	struct Student student; 
	student = fill_Student();
	print_Student(student);
	
	printf("\n\n\n\n");
	/* For array of 3 students */
	struct Student studentArr[3]; 
	for (int i=0; i<3; i++)
	{
		studentArr[i] = fill_Student(); 
	}
	for (int i=0; i<3; i++)
	{
		print_Student(studentArr[i]);
	}
	
	printf("\n\n\n\n");
	/* Dynamic Allocation */
	int Students_Number;
	struct Student* studentDyn; 
	printf("Enter the number of students: ");
	scanf("%d",&Students_Number);
	studentDyn = (struct Student*)malloc(Students_Number*sizeof(struct Student));
	for (int i=0; i<Students_Number; i++)
	{
		studentDyn[i] = fill_Student(); 
	}
	for (int i=0; i<Students_Number; i++)
	{
		print_Student(studentDyn[i]);
	}
}

struct Student fill_Student(void)
{
	struct Student student;
	printf("\nEnter ID of the student: ");
	scanf("%d",&(student.id));
	printf("Student Name: ");
	scanf("%s",student.name);
	for(int i=0; i<4; i++)
	{	
		printf("Grade of subject#%d: ",i+1);
		scanf("%d",&student.grades[i]);
	}
	return student;	
}

void print_Student(struct Student student)
{
	int sum = 0;
	printf("\nStudent ID: %d, Name: %s\n",student.id,student.name);
	for (int i=0; i<4; i++)
	{
		sum += student.grades[i];
	}
	printf("Sum of grades = %d\n\n",sum);
}