/** 
	Lab 4 - Task 4 - Drag Ball Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class OvalDrag extends Applet
{
	int x = 0, y = 50, r = 20;
	boolean flag = false;
	
	public void init()
	{
		this.addMouseListener(new MouseListener()
		{
            public void mousePressed(MouseEvent e)
			{
                if((e.getX()>=x) && (e.getX()<x+2*r) && (e.getY()>=y) && (e.getY()<y+2*r))
				{
                    flag = true;
                }
            }
            
			public void mouseReleased(MouseEvent e)
			{
                flag = false;
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
				if(flag)
				{
					x = e.getX();
					y = e.getY();
					repaint();
				}                  
			}
		});
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x, y, r*2, r*2);
	}
	
			
}