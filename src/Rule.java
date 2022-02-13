import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rule extends JPanel{
	
	JScrollPane scrollPane;
	ImageIcon img;
	JLayeredPane lpane = new JLayeredPane();
	
	public Rule()
	{				

		setLayout(new BorderLayout());


		lpane.setBounds(0, 0, 800, 600);
		
		img = new ImageIcon("./image/background.png");
		
		JPanel back = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		back.setBounds(0, 0, 800, 600);
		back.setOpaque(true);
		

			
		JPanel pn = new JPanel(); //�г� ����
		pn.setBackground(new Color(211, 211, 211, 100)); //�г� ���� ���� - ������ ȸ��
		pn.setBounds(40, 40, 700, 410); //�г� ��ġ, ũ�� ����
		pn.setLayout(new BorderLayout(0, 20)); //�г� ���̾ƿ� ������
		pn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //�г� ���ο� ���� �α�
		pn.setOpaque(true);
		
		Font ft_bold = new Font("���� ���", Font.BOLD,40);
		Font ft = new Font("���� ���", Font.PLAIN,20);
		
		JLabel label = new JLabel();
		label.setText("<html>"
				+ "�� ���������� ����� 15������ �ִ�.<br>"
				+ "�� ����⸦ Ŭ���Ͽ� ���̸� �ָ� ����� ������ ����ȴ�.<br>"
				+ "�� �� �����ϸ� ����� ������ ���� �پ��� ������<br>&nbsp;&nbsp;&nbsp;������ �� Ŭ���Ͽ� �����ľ� �Ѵ�.<br>"
				+ "�� ���� ���� �̻����� ���� ����������(�ʷϻ��� ���������)<br>&nbsp;&nbsp;&nbsp;����� ������ ���� �پ��� ������ ����������<br>&nbsp;&nbsp;&nbsp;������ ��ư�� ���� �������� û���ؾ��Ѵ�.<br>"
				+ "�� ������ ��ư�� �� �� Ŭ���� ������ �� 50�� �ʿ��ϴ�.<br>"
				+ "�� �� ��ư Ŭ���� ���� ���� 10�� ������ų �� �ִ�.<br>"
				+ "�� 1�� ���ѽð� ���� ����Ⱑ 5���� �̻� ��Ƴ��� ������<br>&nbsp;&nbsp;&nbsp;���� Ŭ�����.<br>"
				+ "</html>");
		label.setFont(ft);
		label.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		
		pn.add("Center", label);
		
		lpane.add(back, new Integer(0), 0);
		lpane.add(pn, new Integer(1), 0);
		
		add(lpane);

		setVisible(true);
	}
}
