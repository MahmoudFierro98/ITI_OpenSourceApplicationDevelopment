/** 
	Lab 4 - Task 6 - Draw Multiple Lines Applet (Vector)
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class DrawLines extends Applet
{
	int x1 = 0, y1 = 0, x2 = 0, y2 = 0, linesCounter = 0;
	boolean flag = false;
	
	class Points
	{
		int x1;
		int y1;
		int x2;
		int y2;
	}
	//Points[] savedPointsRecord = new Points[4];
	Vector<Points> savedPointsRecord = new Vector<Points>();
	public void init()
	{
		linesCounter = 0;
		this.addMouseListener(new MouseListener()
		{
            public void mousePressed(MouseEvent e)
			{
				//if(linesCounter < 4)
				//{
                    flag = true;
                    x1 = e.getX();
                    y1 = e.getY();
				//}
            }
            
			public void mouseReleased(MouseEvent e)
			{
                x2 = e.getX() ;
                y2 = e.getY() ;
                //if(linesCounter < 4)
				//{
					flag = false ;
                    Points line = new Points();
                    line.x1 = x1 ;
                    line.y1 = y1 ;
                    line.x2 = x2 ;
                    line.y2 = y2 ;
                    savedPointsRecord.add(line);
                    repaint();
                    //linesCounter++;
				//}
            }
			
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		});

		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent e){}
        
			public void mouseDragged(MouseEvent e)
			{
				if(flag == true)
				{
                    x2 = e.getX() ;
                    y2 = e.getY() ;
					repaint();  
				}					
			}
		});
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		//for(int i=0; i<linesCounter; i++)
		//{
		savedPointsRecord.forEach((Points point) -> 
		{
			g.drawLine(point.x1, point.y1, point.x2, point.y2);
		});
			
		//}
        g.drawLine(x1, y1, x2, y2);
	}		
}