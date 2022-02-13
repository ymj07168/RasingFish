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
		

			
		JPanel pn = new JPanel(); //패널 생성
		pn.setBackground(new Color(211, 211, 211, 100)); //패널 색상 설정 - 반투명 회색
		pn.setBounds(40, 40, 700, 410); //패널 위치, 크기 설정
		pn.setLayout(new BorderLayout(0, 20)); //패널 레이아웃 나누기
		pn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //패널 내부에 공백 두기
		pn.setOpaque(true);
		
		Font ft_bold = new Font("맑은 고딕", Font.BOLD,40);
		Font ft = new Font("맑은 고딕", Font.PLAIN,20);
		
		JLabel label = new JLabel();
		label.setText("<html>"
				+ "★ 수족관에는 물고기 15마리가 있다.<br>"
				+ "★ 물고기를 클릭하여 먹이를 주면 물고기 수명이 연장된다.<br>"
				+ "★ 상어가 등장하면 물고기 수명이 빨리 줄어들기 때문에<br>&nbsp;&nbsp;&nbsp;빠르게 상어를 클릭하여 물리쳐야 한다.<br>"
				+ "★ 일정 수준 이상으로 물이 더러워지면(초록색에 가까워지면)<br>&nbsp;&nbsp;&nbsp;물고기 수명이 빨리 줄어들기 때문에 지속적으로<br>&nbsp;&nbsp;&nbsp;물갈이 버튼을 통해 수족관을 청소해야한다.<br>"
				+ "★ 물갈이 버튼을 한 번 클릭할 때마다 돈 50이 필요하다.<br>"
				+ "★ 돈 버튼 클릭을 통해 돈을 10씩 증가시킬 수 있다.<br>"
				+ "★ 1분 제한시간 내에 물고기가 5마리 이상 살아남아 있으면<br>&nbsp;&nbsp;&nbsp;게임 클리어다.<br>"
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
