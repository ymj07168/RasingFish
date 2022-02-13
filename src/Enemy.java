import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;

public class Enemy extends Thread
{
	int x, y;
	int speed;
	int dir;
	public static int life;
	int term;
	JPanel app;
	Random ran = new Random();
	
	public Enemy(JPanel _app, int w, int h)
	{
		app = _app;
		x = w;
		y = h;
	}
	
	public void run()
	{		
		/*
		1 : ���� ������� 
		2 : ���� �������
		3 : ���� �ϴ�����
		4 : ���� �ϴ�����
		*/
		
		while(true)
		{	
			x = 250; y = -400;
			term = (int)(Math.random() * 10000) + 5000; // �� �ٽ� Ȱ���ϱ������ �ð��� �����ϰ� ����
			
			try
			{
				sleep(term);
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			dir = ran.nextInt(4)+1; // �ʱⰪ ���� ���� �߰�
			life = (int)(Math.random() * 5) + 1; // ����� ����� ���ܳ���
			
			//����� �ִµ��� �� �������� ����
			while(life>0)
			{
				// ������� ������ �پ��� �ڵ带 �̰��� �߰�
				
				speed = (int)(Math.random() * 50);
				
				if(dir == 1)
				{
					x += speed;
					y -= speed;
				}
				else if(dir == 2)
				{
					x -= speed;
					y -= speed;
				}
				else if(dir == 3)
				{
					x -= speed;
					y += speed;
				}
				else if(dir == 4)
				{
					x += speed;
					y += speed;
				}
				app.repaint();
				
				if(dir == 1)
				{
					if(x>=500)
						dir = 2;
					else if(y<=0)
						dir = 4;
				}
				else if(dir == 2)
				{
					if(x<=0)
						dir = 1;
					else if(y<=0)
						dir = 3;
				}
				else if(dir == 3)
				{
					if(x<=0)
						dir = 4;
					else if(y>=400)
						dir = 2;
				}
				else if(dir == 4)
				{
					if(x>=500)
						dir = 3;
					else if(y>=400)
						dir = 1;
				}
				
				try 
				{
					sleep(100);
				} 
				catch(InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
