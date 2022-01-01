/* Lab 7 - Task 1
   Author: Mahmoud Kamal
   Date:   01-01-2022
*/

#include<iostream.h>
#include<conio.h>
#include<string.h>

class Shape
{
protected:
	int dim1,dim2;
public:
	Shape(){dim1=dim2=0;}
	Shape(int m){dim1=dim2=m;}
	Shape(int m, int n)
	{
		dim1 = m;
		dim2 = n;
	}
	void setDim1(int m)
	{
		dim1 = m;
	}
	void setDim2(int m)
	{
		dim2 = m;
	}
	int getDim1(){return dim1;}
	int getDim2(){return dim2;}
	virtual float Area() = 0;
};

class Circle : public Shape
{
public:
	Circle(){}
	Circle(int r):Shape(r){}
	void setR(int r){dim1=dim2=r;}
	int getR(){return dim1;}
	float Area(){return (3.14*dim1*dim1);}
};

class Rectangle : public Shape
{
public:
	Rectangle(){}
	Rectangle(int l, int w):Shape(l,w){}
	void setLength(int l){dim1=l;}
	void setWidth(int w){dim2=w;}
	int getLength(){return dim1;}
	int getWidth(){return dim2;}
	float Area(){return (1.0*dim1*dim2);}
};

class Triangle : public Shape
{
public:
	Triangle(){}
	Triangle(int b, int h):Shape(b,h){}
	void setBase(int b){dim1=b;}
	void setHeight(int h){dim2=h;}
	int getBase(){return dim1;}
	int getHeight(){return dim2;}
	float Area(){return (0.5*dim1*dim2);}
};

class Square : public Rectangle
{
public:
	Square(){}
	Square(int s):Rectangle(s,s){}
	void setLength(int s){dim1=dim2=s;}
	int getLength(){return dim1;}
};

class GeoShape
{
	Shape** p;
	int c;
public:
	GeoShape(Shape* p1, Shape* p2, Shape* p3, Shape* p4)
	{
		p = new Shape*[4];
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		p[3] = p4;
		c = 4;
	}
	GeoShape(int size, Shape** pt);
	float TotalArea();
};
GeoShape::GeoShape(int size, Shape** pt)
{
	c = size;
	p = new Shape*[c];
	for(int i=0; i<c; i++)
	{
	       p[i] = pt[i];
	}
}
float GeoShape::TotalArea()
{
	float sum = 0.0f;
	for(int i=0; i<c; i++)
	{
		sum += p[i]->Area();
	}
	return sum;
}

int main()
{
	clrscr();
	Triangle t(5,10);
	Rectangle r(2,10);
	Square s(2);
	Circle c(4);
	
	GeoShape g(&t, &r, &s, &c);

	Shape* ptr[4] = {&t, &r, &s, &c};
	GeoShape f(4, ptr);

	cout << g.TotalArea() << endl;
	cout << f.TotalArea() << endl;
	getch();
	return 0;
}