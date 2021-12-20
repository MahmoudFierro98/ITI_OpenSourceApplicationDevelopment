/* Lab 2 - Task 2
   Author: Mahmoud Kamal
   Date:   18-12-2021
*/

#include<iostream.h>
#include<conio.h>
#include<string.h>
class Employee
{
  private:
	int id;
	char name[10];
	float salary;
  public:
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
	cout << "Salary :";
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