/* Lab 6 - Task 1
   Author: Mahmoud Kamal
   Date:   27-12-2021
*/

#include<iostream.h>
#include<conio.h>
#include<string.h>

class Person
{
 protected:
	int id;
	char name[10];
 public:
	Person()
	{
		id = 0;
		strcpy(name, "NO Name");
	}
	Person(int i):id(i){}
	Person(char* n)
	{
	 strcpy(name, n);
	}
	Person(int i, char* n)
	{
		id = i;
		strcpy(name, n);
	}
	void setName(char* n)
	{
	 strcpy(name, n);
	}
	void setID(int i)
	{
		id = i;
	}
	void print()
	{
		cout << "ID: " << id << endl;
		cout << "Name: " << name << endl;
	}
	int getID(){return id;}
	char* getName(){return name;}
};

class Customer:public Person
{
 protected:
	int AccountID;
 public:
	Customer():AccountID(0){}
	Customer(int i, char* n, int a):Person(i,n)
	{AccountID = a;}
	void setAccountID(int a){AccountID = a;}
	int getID(){return id;}
	void print()
	{
		cout << "ID: " << id << endl;
		cout << "Name: " << name << endl;
		cout << "Account ID: " << AccountID << endl;
	}
	char* getName(){return name;}
	int getAccID(){return AccountID;}
};

class Employee:public Person
{
 protected:
	int salary;
 public:
	Employee():salary(0){}
	Employee(int i, char* n, int a):Person(i,n)
	{salary = a;}
	void print()
	{
		cout << "ID: " << id << endl;
		cout << "Name: " << name << endl;
		cout << "Salary: " << salary << endl;
	}
	void setSalary(int a){salary = a;}
	int getID(){return id;}
	char* getName(){return name;}
	int getSalary(){return salary;}
};

int main()
{
	clrscr();
	Employee e(1, "Kamal", 15000);
	Customer c(2, "mahmoud", 152);

	e.print();
	cout << endl;
    c.print();
	getch();
	return 0;
}