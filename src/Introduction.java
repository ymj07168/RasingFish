import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

public class Introduction extends JFrame
{	
	JScrollPane scrollPane;
	ImageIcon img;
	JLayeredPane lpane = new JLayeredPane();
	
	public Introduction()
	{				
		JFrame jf = new JFrame(); //������ ����
		jf.setPreferredSize(new Dimension(800, 600)); //������ ������ ����
		jf.setTitle("���� ���"); //â �̸� ����
		jf.setResizable(false); //����ڰ� â ������ ���� ���ϵ��� ����
		jf.setLayout(new BorderLayout());
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.add(lpane, BorderLayout.CENTER);

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
		
		scrollPane = new JScrollPane(back);
		setContentPane(scrollPane);
			
		JPanel pn = new JPanel(); //�г� ����
		pn.setBackground(new Color(211, 211, 211, 100)); //�г� ���� ���� - ������ ȸ��
		pn.setBounds(40, 40, 700, 480); //�г� ��ġ, ũ�� ����
		pn.setLayout(new BorderLayout(0, 20)); //�г� ���̾ƿ� ������
		pn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //�г� ���ο� ���� �α�
		pn.setOpaque(true);
		
		Font ft_bold = new Font("���� ���", Font.BOLD,40);
		Font ft = new Font("���� ���", Font.PLAIN,20);
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		label1.setText("���� ���");
		label2.setText("<html>"
				+ "�� ���������� ����� 15������ �ִ�.<br>"
				+ "�� ����⸦ Ŭ���Ͽ� ���̸� �ָ� ����� ������ ����ȴ�.<br>"
				+ "�� �� �����ϸ� ����� ������ ���� �پ��� ������<br>&nbsp;&nbsp;&nbsp;������ �� Ŭ���Ͽ� �����ľ� �Ѵ�.<br>"
				+ "�� ���� ���� �̻����� ���� ����������(�ʷϻ��� ���������)<br>&nbsp;&nbsp;&nbsp;����� ������ ���� �پ��� ������ ����������<br>&nbsp;&nbsp;&nbsp;������ ��ư�� ���� �������� û���ؾ��Ѵ�.<br>"
				+ "�� ������ ��ư�� �� �� Ŭ���� ������ �� 50�� �ʿ��ϴ�.<br>"
				+ "�� �� ��ư Ŭ���� ���� ���� 10�� ������ų �� �ִ�.<br>"
				+ "�� 1�� ���ѽð� ���� ����Ⱑ 5���� �̻� ��Ƴ��� ������<br>&nbsp;&nbsp;&nbsp;���� Ŭ�����.<br>"
				+ "</html>");
		label1.setFont(ft_bold);
		label2.setFont(ft);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		
		pn.add("North", label1);
		pn.add("Center", label2);
		
		lpane.add(back, new Integer(0), 0);
		lpane.add(pn, new Integer(1), 0);
		
		jf.pack();
		jf.setVisible(true);
	}
	
}