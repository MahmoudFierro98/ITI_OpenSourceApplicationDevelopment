/** 
	Lab 4 - Task 3 - Animation Ball Applet
	Author: Mahmoud Mohamed Kamal
	Date:   12-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class RandBallApplet extends Applet implements Runnable
{
	Thread th; 
	int x = 0, y = 50, r = 20, xl = 10, yl = 10;
	boolean flag = true;
	Button buttonStart, buttonPause;
	
	public void init()
	{
		th = new Thread(this);
		buttonStart = new Button("Start");
		buttonPause = new Button("Pause");
		buttonStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if(flag)
				{
					th.start();
					flag = false;
				}
				else
				{
					th.resume();	//RandBallApplet.this.notify();
				}					
			}
		});
		buttonPause.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				//x = x;
				//y = y;
				th.suspend();		//wait();	
				repaint() ;
			}
		});
		add(buttonStart);
		add(buttonPause);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
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