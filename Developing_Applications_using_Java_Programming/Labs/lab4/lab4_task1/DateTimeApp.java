/** 
	Lab 4 - Task 1 - Date and Time Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;

public class DateTimeApp extends Applet implements Runnable
{
	Thread th; 
	Date d;
	
	public void init()
	{
		th = new Thread(this);
		th.start();
		d = new Date();
	}
	
	public void paint(Graphics g)
	{
		g.drawString(d.toString(), 50, 100);
	}
	public void run()
	{
		while(true)
		{
			d = new Date();
			repaint();
			try{th.sleep(1000);}  
  			catch(Exception e){} 
		} 
	}
}