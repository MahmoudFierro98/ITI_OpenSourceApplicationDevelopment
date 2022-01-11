/** 
	Lab 3 - Task 2 - List of Fonts on Applet (1)
	Author: Mahmoud Mohamed Kamal
	Date:   11-01-2022
*/

import java.awt.*;  
import java.applet.*;

public class Fonts1 extends Applet 
{   
	public void paint(Graphics g) 
	{   
		String[] fonts = Toolkit.getDefaultToolkit().getFontList();
		
		for(int i=0; i<fonts.length; i++)
		{
			Font font = new Font(fonts[i], Font.BOLD, 14);
			g.setFont(font);
			g.drawString(fonts[i], 0, (15*i));
		}
	}    
}  