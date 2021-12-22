/* Lab 4 - Task 1
   Author: Mahmoud Kamal
   Date:   22-12-2021
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
		name = new char[40];
		id = 0;
		salary = 1000;
		name = " ";
	}
	Employee(int i)
	{
		name = new char[40];
		id = i;
		salary = 1000;
		name = " ";
	}
	Employee(int i, char* n)
	{
		name = new char[strlen(n)+1];
		id = i;
		salary = 1000;
		strcpy(name, n);
	}
	Employee(int i, char* n, float s)
	{
		name = new char[strlen(n)+1];
		id = i;
		salary = s;
		strcpy(name, n);
	}
	Employee(char* n)
	{
		name = new char[strlen(n)+1];
		id = 0;
		salary = 1000;
		strcpy(name, n);
	}
	Employee(const Employee &emp)
	{
		name = new char[strlen(emp.name)+1];
		id = emp.id;
		salary = emp.salary;
		strcpy(name, emp.name);
	}
	~Employee()
	{
		delete name;
	}
	Employee operator +(Employee emp)
	{
		Employee temp;
		temp.id = id;
		temp.salary = salary+emp.salary;
	      //  strcat(name," ");
		strcpy(temp.name, name);
		strcat(temp.name," ");
		strcat(temp.name,emp.name);
		return temp;
	}
	Employee& operator = (Employee &emp)
	{
		id = emp.id;
		salary = emp.salary;
		delete name;
		name = new char[strlen(emp.name)+1];
		strcpy(name, emp.name);
		return *this;
	}
	int operator == (Employee emp)
	{
		return ((id==emp.id) && (salary==emp.salary) && !(strcmp(name,emp.name)));
	}
	Employee operator +(char* n)
	{
		Employee temp;
		temp.id = id;
		temp.salary = salary;
	      //  strcat(name," ");
		strcpy(temp.name, name);
	       // strcat(temp.name," ");
		strcat(temp.name,n);
		return temp;
	}
	Employee operator +(float n)
	{
		salary = salary + n;
		return *this;
	}
	friend Employee operator +(float n, Employee e)
	{
		return (e+n);
	}
	Employee operator ++()
	{
		salary++;
		return *this;
	}
	operator char* ()
	{
		return name;
	}

	operator int ()
	{
		return id;
	}

	Employee operator ++(int d)
	{
		Employee old;
		old = *this;
		salary++;
		return old;
	}
	friend Employee operator +(char* n, Employee emp)
	{
		Employee temp;
		temp.id = emp.id;
		temp.salary = emp.salary;
	      //  strcat(name," ");
		strcpy(temp.name, n);
	       // strcat(temp.name," ");
		strcat(temp.name,emp.name);
		return temp;
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
	Employee e,e1(1, "Ahmed", 1500),e2(2, "Ali", 1500),e3;
      // e = fillEmployee();
       //	cout << endl;
	printEmployee(e1);
	printEmployee(e2);
	e3 = e1+e2;
	printEmployee(e3);
	printEmployee(e1+"Mohamed");
      //	printEmployee("Mohamed"+e2);
	printEmployee(e2++);
	printEmployee(e2);
	 e3=e1;
	 printEmployee(e3);
	 printEmployee(e3+1000);
	 printEmployee(1000+e3);
	 if (e1==e1)
	 cout<<"l"<<endl;
	 if (e1==e2)
	 cout<<"l"<<endl;
	 else
	 cout<<"j"<<endl;
	   cout << (char*)e1<<endl;
	   cout << (int)e1<<endl;
	getch();
	return 0;
}