/* Lab 5 - Task 2 (Composition)
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

class RectangleC
{
  private:
	Point pt1,pt2;
	int length,width;
  public:
	RectangleC(int x1,int y1, int x2, int y2):pt1(x1,y1),pt2(x2,y2)
	{
		length = abs(x1-x2);
		width = abs(y1-y2);
	}
	void setP1(int x, int y)
	{
		pt1.setX(x);
		pt1.setY(y);
		length = abs(pt2.getX()-x);
		width = abs(pt2.getY()-y);
	}
	void setP2(int x, int y)
	{
		pt2.setX(x);
		pt2.setY(y);
		length = abs(pt1.getX()-x);
		width = abs(pt1.getY()-y);
	}
	int getWidth() {return width;}
	int getLength() {return length;}
	int Area(){return (width*length);}
};
int main()
{
	clrscr();
	RectangleC c(0,0,4,4);
	cout << c.Area();
	getch();
	return 0;
}