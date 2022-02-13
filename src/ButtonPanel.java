import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Timer;
import java.util.TimerTask;



public class ButtonPanel extends JPanel

{
	public static int money_now = 0;//ÇöÀç ÀÜ°í
	
	JButton get_money, cleanWater, how;
	
	
	
	public ButtonPanel()
	{
		
		setLayout(new GridLayout(2,1));
		
		get_money = new JButton("µ·");
		get_money.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				money_now += 10;
				GameFrame.moneyL.setText("ÀÜ°í : " + money_now);
			}
			
		});
		
		
		cleanWater = new JButton("¹°°¥ÀÌ");
		cleanWater.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				if (ButtonPanel.money_now >= 50) {
					AquaPanel.green = 0;
					money_now = money_now - 50;
				}
			}
			
		});
		
		
		add(get_money);
		add(cleanWater);

	
	}
}