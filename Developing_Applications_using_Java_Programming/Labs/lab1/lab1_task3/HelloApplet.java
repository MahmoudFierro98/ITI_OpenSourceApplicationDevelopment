/** 
	Lab 1 - Task 3 - Basic Applet
	Author: Mahmoud Mohamed Kamal
	Date:   09-01-2022
*/

import java.applet.Applet;
import java.awt.Graphics;
public class HelloApplet extends Applet
{
	public void paint(Graphics g)
	{
		g.drawString("Hello Java", 50, 100);
		String str = getParameter("msg");
		g.drawString(str, 50, 120);
		System.out.println(str);
	}
}