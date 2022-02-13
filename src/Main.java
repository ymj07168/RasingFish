import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame{

	JScrollPane scrollPane;
	ImageIcon icon;
	JLabel title;
	JButton start, rule;

	public Main() {
		icon = new ImageIcon("./image/background.png");
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
	background.setLayout(null);
	Font font = new Font("맑은 고딕", Font.BOLD, 50);
	JLabel title = new JLabel("물고기 키우기 게임");
	title.setFont(font);
	
	JButton start = new JButton("게임 시작");
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			Thread t1 = new Thread(new GameFrame("물고기 키우기 게임"));
			t1.start();
		}
	});
	
	JButton rule = new JButton("게임 방법");
	rule.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new Introduction();
		}
	});
	
	title.setBounds(170, 150, 700, 100);
	start.setBounds(350, 300, 100, 30);
	rule.setBounds(350, 350, 100, 30);
	
	background.add(title);
	background.add(start);
	background.add(rule);

	add(background);
	
	setTitle("물고기 키우기 게임");
	setSize(800,600);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
