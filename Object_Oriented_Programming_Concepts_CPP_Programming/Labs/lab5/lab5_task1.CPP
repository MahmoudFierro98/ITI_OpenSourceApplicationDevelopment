/* Lab 5 - Task 1
   Author: Mahmoud Kamal
   Date:   26-12-2021
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
	static unsigned int counter;
	static char* cname;
  public:
	Employee()
	{
		name = new char[40];
		id = 0;
		salary = 1000;
		name = " ";
		counter++;
	}
	Employee(int i)
	{
		name = new char[40];
		id = i;
		salary = 1000;
		name = " ";
		counter++;
	}
	Employee(int i, char* n)
	{
		name = new char[strlen(n)+1];
		id = i;
		salary = 1000;
		strcpy(name, n);
		counter++;
	}
	Employee(int i, char* n, float s)
	{
		name = new char[strlen(n)+1];
		id = i;
		salary = s;
		strcpy(name, n);
		counter++;
	}
	Employee(char* n)
	{
		name = new char[strlen(n)+1];
		id = 0;
		salary = 1000;
		strcpy(name, n);
		counter++;
	}
	Employee(const Employee &emp)
	{
		name = new char[strlen(emp.name)+1];
		id = emp.id;
		salary = emp.salary;
		strcpy(name, emp.name);
		counter++;
	}
	~Employee()
	{
		delete name;
		counter--;
	}      /*
	Employee& operator = (Employee &emp)
	{
		id = emp.id;
		salary = emp.salary;
		delete name;
		name = new char[strlen(emp.name)+1];
		strcpy(name, emp.name);
		return *this;
	}           */
	void Setter(int i, char* n, float s);
	void setID(int i);
	void setName(char* n);
	static void setCName(char* c){
	       //	delete cname;
	       //	cname = new char[strlen(c)+1];
		strcpy(cname, c);}
	void setSalary(float s);
	char* getName();
	static char* getCName(){return cname;}
	int getID();
	float getSalary();
	static int getCounter() {return counter;}
};
void Employee::Setter(int i, char* n, float s)
{
	id = i;
	salary = s;
	delete name;
	name = new char[strlen(n)+1];
	strcpy(name, n);
}
void Employee::setID(int i)
{
	id = i;
}
void Employee::setName(char* n)
{
	delete name;
	name = new char[strlen(n)+1];
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
unsigned int Employee::counter = 0;
char* Employee::cname = "ITI";
Employee fillEmployee()
{
	int id;
	char* name = new char;
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
	cout << endl;
	cout << "Name: " << emp.getName() << endl;
	cout << "ID: " << emp.getID() << endl;
	cout << "Salary: " << emp.getSalary() << endl;
	cout << "Company: " << Employee::getCName() << endl;
       //	cout << "OBJECT Numbers: " << Employee::getCounter() << endl;
	cout << endl;
}

int main()
{
	clrscr();
      	Employee::setCName("ITIOOP42");
	Employee e1(1,"mohamed",15000);
       //	e1 = fillEmployee();

	printEmployee(e1);
		cout << "OBJECT Numbers: " << Employee::getCounter() << endl;

      Employee e2(2,"Mahmoud",15550);
       //	e2 = fillEmployee();
       	printEmployee(e2);
	cout << "OBJECT Numbers: " << Employee::getCounter() << endl;

	getch();
	return 0;
}