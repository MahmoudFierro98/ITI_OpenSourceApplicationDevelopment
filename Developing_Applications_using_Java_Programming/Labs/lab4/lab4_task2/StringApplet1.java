/** 
	Lab 4 - Task 1 - Date and Time Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;

public class StringApplet1 extends Applet implements Runnable
{
	Thread th; 
	int x = 0;
	public void init()
	{
		th = new Thread(this);
		th.start();
		x = 0;
	}
	
	public void paint(Graphics g)
	{
		g.drawString("Java World", x, 100);
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
				x = 0;
			}
			repaint();
			try{th.sleep(100);}  
			catch(Exception e){} 
		} 
	}
}