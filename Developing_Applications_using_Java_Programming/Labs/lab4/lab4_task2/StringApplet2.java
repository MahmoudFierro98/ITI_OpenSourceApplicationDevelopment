/** 
	Lab 4 - Task 1 - Text Banner Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;

public class StringApplet2 extends Applet implements Runnable
{
	Thread th;
	String str = "Java World";
	int x = 0; 
	
	int stringWidth;
	public void init()
	{
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g)
	{
		stringWidth = g.getFontMetrics().stringWidth(str);
		g.drawString(str, x, 100);
	}
	public void run()
	{
		while(true)
		{
			if(x < getWidth())
			{				
				x++;
			}
			else
			{
				x = stringWidth * -1;
			}
			repaint();
			try{th.sleep(100);}  
			catch(Exception e){} 
		} 
	}
}