/** 
	Lab 5 - Task 2 - Moving Text Using Keyboard
	Author: Mahmoud Mohamed Kamal
	Date:   13-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class Arrow extends Applet
{
	int x = 100, y = 20, dx = 1, dy = 1;
	String str = "JAVA";
	int stringWidth;
	
	public void init()
	{
		this.addKeyListener(new KeyListener()
		{
            public void keyPressed(KeyEvent e) 
			{
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					x += dx;
                    repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_LEFT )
				{
					x -= dx;
                    repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					y -= dy;
                    repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					y += dy;
                    repaint();
                }
            }
			
            public void keyTyped(KeyEvent e){}
            public void keyReleased(KeyEvent e){}
		});
	}
	public void paint(Graphics g)
	{
		stringWidth = g.getFontMetrics().stringWidth(str);
		g.drawString(str, x, y);
	}
}