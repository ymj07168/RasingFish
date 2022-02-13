import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.*;


public class GameFrame extends JFrame implements Runnable
{
	JTabbedPane tabpane;
	JPanel top;
	JPanel aqua, rule;
	JPanel money, fish_num, time;
	public static JLabel moneyL, fishL, timeL;
	int time_now;
	
	public static boolean Over = false;
	public static boolean Clear = false;
	
	//center Panel�� ���� �ڵ�
	JScrollPane scrollPane;
	Label shop_name;

	
	public GameFrame(String msg)
	{	
		setTitle(msg);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font font = new Font("�޸�����ü", Font.BOLD, 30);
		
		
		
		
//		--top ����-------------------------------------------------------------
		
		//top => ���� �ܰ�, ����� ��, ���� �ð�
		top = new JPanel();
		top.setLayout(new GridLayout(1,3));
		
		money = new JPanel();
		money.setSize(200, 50);
		moneyL = new JLabel("�ܰ� : " + ButtonPanel.money_now);
		moneyL.setFont(font);
		money.add(moneyL);
		
		fish_num = new JPanel();
		fish_num.setSize(200,50);
		fishL = new JLabel("����� �� : " + AquaPanel.f_size);
		fishL.setFont(font);
		fish_num.add(fishL);
		
		time = new JPanel();
		time.setSize(200,50);
		timeL = new JLabel("���� �ð� : " + time_now);
		timeL.setFont(font);
		time.add(timeL);
		
		
		top.add(money);
		top.add(fish_num);
		top.add(time);
		
		add("North", top);
		
//		-----------------------------------------------------top ��------
//		--center ����----------------------------------------------------

//		aquaPanel------------------------------------------------------
		aqua = new JPanel();
		
		aqua.setLayout(new BorderLayout());
		
		aqua.add("East", new ButtonPanel());
		JPanel aquaPanel = new AquaPanel();
		
		aqua.add("Center", aquaPanel);
		
		
//		rulePanel--------------------------------------------
		rule = new Rule();
		
		
		tabpane = new JTabbedPane();
		tabpane.addTab("������", aqua);
		tabpane.addTab("���� ���", rule);	
		
		add("Center", tabpane);
				
		setSize(800, 600);
		setVisible(true);
		
	}
	
	public void run()
	{

		for (time_now=60; time_now>=0; time_now--)
		{
						timeL.setText("���� �ð� : " + (int)time_now/60 + " �� " + time_now%60 + "��");

						
						//���� �ʷϻ����� ���Ѵ�
						if(AquaPanel.green == 0)
						{
							repaint();
							moneyL.setText("�ܰ� : " + ButtonPanel.money_now);
						}
						AquaPanel.green++;
						

						fishL.setText("����� ��: "+ AquaPanel.f_size);
						
						
						try
						{
							Thread.sleep(1000);
						} catch(Exception e)
						{
						}
						
					}
		
		if (AquaPanel.f_size >= 5)
		{
			Clear = true;
		}
		else if (AquaPanel.f_size < 5) {
			Over = true;

		}
				
	}
}
