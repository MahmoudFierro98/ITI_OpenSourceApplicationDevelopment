/** 
	Lab 4 - Task 3 - Animation Ball Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;

public class RandBallApplet extends Applet implements Runnable
{
	Thread th; 
	int x = 150, y = 50, r = 20, xl = 10, yl = 8;
	
	public void init()
	{
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(x, y , r * 2, r * 2);
	}
	
	public void run()
	{
		while(true)
		{
			if ((x + xl < 0) || (x + 2*r + xl > getWidth())) xl = -xl;
			if ((y + yl < 0) || (y + 2*r + yl > getHeight())) yl = -yl;
			x += xl;
			y += yl;
			repaint();
			try{th.sleep(100);}  
			catch(Exception e){} 
		} 
	}
}
