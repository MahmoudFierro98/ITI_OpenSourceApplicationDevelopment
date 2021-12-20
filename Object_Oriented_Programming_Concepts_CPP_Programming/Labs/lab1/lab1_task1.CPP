/* Lab 1 - Task 1
   Author: Mahmoud Kamal
   Date:   20-12-2021
*/

#include<iostream>
#include<conio>

struct Student
{
	char name[5];
	int grade[4];
};

Student fillStudent(void)
{
	Student std;
	cout<<"Please Enter Name: ";
	cint>>std.name;
	for(int i=0; i<4; i++)
	{
		cout<<"Please Enter grade #" << i << ": ";
		cint>>std.grade[i];
	}
	return std;
}

void printStudent(Student std)
{
	cout<<"Name: "<<std.name<<endl;
	for(int i=0; i<4; i++)
	{
		cout<<"Please Enter grade #" << i << ": " << std.grade[i] << endl;
	}
	cout << endl;
}
int main()
{
	clrscr();
	Student std;
	std = fillStudent();
	printStudent(std);
	getch();
	return 0;
}