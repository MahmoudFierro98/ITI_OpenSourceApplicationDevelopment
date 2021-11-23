/* Lab 2 - Task 4
   Author: Mahmoud Kamal
   Date:   03-11-2021
*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<windows.h>
void gotoxy(int x, int y)
{
	COORD coord;
	coord.X = x;
	coord.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}
int main()
{
  int col,row,i,size,high;
  printf("Enter size: ");
  scanf("%d",&size);
  high = size * size;
  //system("cls");
  for(i=1;i<=high;i++)
  {
	if(i==1)
	{
	row =1;
	col=(size+1)/2;
	}else if(((i-1) % size) == 0){
	row++;
	}else{
	row--; col--;
	if(row == 0)
	row = size;
	if(col == 0)
	col = size;
	}
	
    //gotoxy(col,row);
    //printf("%d",i); 
	printf("\nr=%d, c=%d : %d",row,col,i);
  }
  return 0;
}