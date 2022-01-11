/** 
	Lab 3 - Task 1 - Image on Applet
	Author: Mahmoud Mohamed Kamal
	Date:   11-01-2022
*/

import java.awt.*;  
import java.applet.*;

public class DisplayImage extends Applet 
{   
	Image pic;  
  
	public void init() 
	{  
		pic = getImage(getDocumentBase(),"image.jpg");  
	}  
    
	public void paint(Graphics g) 
	{  
		g.drawImage (pic, 0, 0, getWidth(), getHeight(), this);
	}    
}  