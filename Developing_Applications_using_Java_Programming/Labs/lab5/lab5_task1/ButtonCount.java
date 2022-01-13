/** 
	Lab 5 - Task 1 - Button Count Applet
	Author: Mahmoud Mohamed Kamal
	Date:   13-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class ButtonCount extends Applet
{
	int x = 0;
	Button buttonInc, buttonDec;
	
	public void init()
	{
		buttonInc = new Button("Increment");
		buttonDec = new Button("Decrement");
		buttonInc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				x++ ;
				repaint() ;
			}
		});
		buttonDec.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				x-- ;
				repaint() ;
			}
		});
		add(buttonInc);
		add(buttonDec);
	}
	
	public void paint(Graphics g)
	{
		g.drawString("ClickCount = " + x, 50, 200);
	}
}