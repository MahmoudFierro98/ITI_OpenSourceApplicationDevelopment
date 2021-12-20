/* Lab 3 - Task 1
   Author: Mahmoud Kamal
   Date:   20-12-2021
*/

#include<iostream.h>
#include<conio.h>
#include<string.h>

class Employee
{
  private:
	int id;
	char* name;
	float salary;
  public:
	Employee()
	{
		name = new char[10];
		id = 0;
		salary = 1000;
		name = " ";
	}
	Employee(int i)
	{
		name = new char[10];
		id = i;
		salary = 1000;
		name = " ";
	}
	Employee(int i, char* n)
	{
		name = new char[10];
		id = i;
		salary = 1000;
		strcpy(name, n);
	}
	Employee(int i, char* n, float s)
	{
		name = new char[10];
		id = i;
		salary = s;
		strcpy(name, n);
	}
	Employee(char* n)
	{
		name = new char[10];
		id = 0;
		salary = 1000;
		strcpy(name, n);
	}
	Employee(const Employee &emp)
	{
		name = new char[10];
		id = emp.id;
		salary = emp.salary;
		strcpy(name, emp.name);
	}
	~Employee()
	{
		delete name;
	}
	void Setter(int i, char* n, float s);
	void setID(int i);
	void setName(char* n);
	void setSalary(float s);
	char* getName();
	int getID();
	float getSalary();
};
void Employee::Setter(int i, char* n, float s)
{
	id = i;
	salary = s;
	strcpy(name, n);
}
void Employee::setID(int i)
{
	id = i;
}
void Employee::setName(char* n)
{
	strcpy(name, n);
}
void Employee::setSalary(float s)
{
	salary = s;
}
char* Employee::getName()
{
	return name;
}
int Employee::getID()
{
	return id;
}
float Employee::getSalary()
{
	return salary;
}

Employee fillEmployee()
{
	int id;
	char name[10];
	float salary;
	Employee emp;

	cout << "Name: ";
	cin >> name;
	cout << "ID: ";
	cin >> id;
	cout << "Salary: ";
	cin >> salary;
	emp.Setter(id, name, salary);
	return emp;
}

void printEmployee(Employee emp)
{
	cout << "Name: " << emp.getName() << endl;
	cout << "ID: " << emp.getID() << endl;
	cout << "Salary: " << emp.getSalary() << endl;
}

int main()
{
	clrscr();
	Employee e;
	e = fillEmployee();
    cout << endl;
	printEmployee(e);
    getch();
	return 0;
}