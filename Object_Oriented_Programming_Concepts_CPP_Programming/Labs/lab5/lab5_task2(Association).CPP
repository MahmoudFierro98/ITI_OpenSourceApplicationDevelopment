/* Lab 5 - Task 2 (Association)
   Author: Mahmoud Kamal
   Date:   26-12-2021
*/

#include<iostream.h>
#include<conio.h>
#include<string.h>
#include<math.h>
class Point
{
	int x,y;
  public:
	Point(){x=y=0;}
	Point(int n){x=y=n;}
	Point(int m, int n){x=m; y=n;}
	void setX(int m){x=m;}
	void setY(int m){y=m;}
	int getX(){return x;}
	int getY(){return y;}
};

class RectangleA
{
  private:
	Point *pt1,*pt2;
	int length,width;
  public:
	RectangleA()
	{
		pt1 = pt2 = NULL;
		width = length = 0;
	}
	RectangleA(Point* p1, Point* p2)
	{
		pt1 = p1;
		pt2 = p2;
		if (pt1 && pt2)
		{
			length = abs(pt1->getX() - pt2->getX());
			width = abs(pt1->getY() - pt2->getY());
		}
	}
	void setP1(Point* p1)
	{

		pt1 = p1;

		if (pt1 && pt2)
		{
			length = abs(pt1->getX() - pt2->getX());
			width = abs(pt1->getY() - pt2->getY());
		}
	}
	void setP2(Point* p2)
	{

		pt1 = p2;

		if (pt1 && pt2)
		{
			length = abs(pt1->getX() - pt2->getX());
			width = abs(pt1->getY() - pt2->getY());
		}
	}
	int getWidth() {return width;}
	int getLength() {return length;}
	int Area(){return (width*length);}
};
int main()
{
	clrscr();
	Point pa(0,0),pb(4,4);
	RectangleA c(&pa,&pb);
	cout << c.Area();
	getch();
	return 0;
}