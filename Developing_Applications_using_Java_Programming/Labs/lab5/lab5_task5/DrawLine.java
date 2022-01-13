/** 
	Lab 4 - Task 5 - Draw Single Line Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class DrawLine extends Applet
{
	int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	
	public void init()
	{
		this.addMouseListener(new MouseListener()
		{
            public void mousePressed(MouseEvent e)
			{
                x1 = e.getX();
				y1 = e.getY();
            }
            
			public void mouseReleased(MouseEvent e)
			{
                x2 = e.getX();
				y2 = e.getY();
				repaint();
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
				x2 = e.getX();
				y2 = e.getY();
				repaint();          
			}
		});
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawLine(x1, y1, x2, y2);
	}
	
			
}