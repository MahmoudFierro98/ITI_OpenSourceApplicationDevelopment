/* Lec 6 - Multiple Inheritance (virtual) 
   Author: Mahmoud Kamal
   Date:   27-12-2021
   File:   lec6.c
*/

#include<iostream.h>
#include<conio.h>
#include<string.h>

class Base
{
 protected:
	int z;
 public:
	Base(){z = 0;}
	Base(int m){z = m;}
	void setZ(int m){z = m;}
	int getZ(){return z;}
};

class Base1 : virtual public Base
{
 protected:
	int x;
 public:
	Base1(){x = 0;}
	Base1(int m):Base(m)
	{x = m;}
	void setX(int m){x = m;}
	int getX(){return x;}
};

class Base2 : virtual public Base
{
 protected:
	int y;
 public:
	Base2(){y = 0;}
	Base2(int m):Base(m)
	{y = m;}
	void setY(int m){y = m;}
	int getY(){return y;}
};

class Derived : public Base1, public Base2
{
 public:
	Derived(){}
	Derived(int m, int n) : Base2(m), Base1(n)
	{}
	int Product(){return (x*y*z);}
	int Sum(){return (x+y+z);}
};

int main()
{
	clrscr();
	Derived drv(3,4);
	cout << drv.Product() << endl;
	getch();
	return 0;
}