/** 
	Lab 4 - Task 3 (Bonuce) - Animation Balls Applet
	Author: Mahmoud Mohamed Kamal
	Date:   15-01-2022
*/

import java.awt.*;  
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class RandBallsApplet extends Applet implements Runnable
{
	Thread th; 
	int x = 0, y = 50, r = 20, xl = 10, yl = 10;
	boolean flagThread = false;
	boolean flagSub = false;
	Button buttonStart, buttonPause;
	
	class Ball
	{
		int x;
		int y;
		int xl;
		int yl;
	}
	Vector<Ball> savedBallsRecord = new Vector<Ball>();
	Vector<Ball> savedSubBallsRecord = new Vector<Ball>();
	
	public void init()
	{
		th = new Thread(this);
		buttonStart = new Button("Start");
		buttonPause = new Button("Pause");
		buttonStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				flagThread = true;
			}
		});
		buttonPause.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				flagThread = false;
			}
		});
		add(buttonStart);
		add(buttonPause);
		th.start();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
		savedBallsRecord.forEach((Ball ball) -> 
		{
			g.fillOval(ball.x, ball.y, r * 2, r * 2);
		});
		g.setColor(Color.RED);
		g.fillOval(x, y , r*2, r*2);
	}
	
	public void run()
	{
		while(true)
		{
			if(flagThread)
			{
				if ((x + xl < 0) || (x + 2*r + xl > getWidth())) 
				{
					xl = -xl;
                    Ball ball = new Ball();
                    ball.x  = x ;
                    ball.y  = y ;
                    ball.xl = xl;
                    ball.yl = -yl;
                    savedBallsRecord.add(ball);
                    repaint();
				}
				if ((y + yl < 0) || (y + 2*r + yl > getHeight())) 
				{
					yl = -yl;
                    Ball ball = new Ball();
                    ball.x  = x ;
                    ball.y  = y ;
                    ball.xl = -xl;
                    ball.yl = yl;
                    savedBallsRecord.add(ball);
                    repaint();
				}
				x += xl;
				y += yl;
				savedSubBallsRecord.clear();
				for (Ball ball: savedBallsRecord)
				{
					if ((ball.x + ball.xl < 0) || (ball.x + 2*r + ball.xl > getWidth())) 
					{
						ball.xl = -ball.xl;
						Ball subBall = new Ball();
						subBall.x  = ball.x ;
						subBall.y  = ball.y ;
						subBall.xl = ball.xl;
						subBall.yl = -ball.yl;
						savedSubBallsRecord.add(subBall);
						repaint();
					}						
					if ((ball.y + ball.yl < 0) || (ball.y + 2*r + ball.yl > getHeight())) 
					{
						ball.yl = -ball.yl;
						Ball subBall = new Ball();
						subBall.x  = ball.x ;
						subBall.y  = ball.y ;
						subBall.xl = -ball.xl;
						subBall.yl = ball.yl;
						savedSubBallsRecord.add(subBall);
						repaint();
					}
					ball.x += ball.xl;
					ball.y += ball.yl;
				}
				savedBallsRecord.addAll(savedSubBallsRecord);
				repaint();
			} 
			try{th.sleep(200);}  
			catch(Exception e){} 
		}
	}			
}