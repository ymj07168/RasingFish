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
	Font font = new Font("���� ���", Font.BOLD, 50);
	JLabel title = new JLabel("����� Ű��� ����");
	title.setFont(font);
	
	JButton start = new JButton("���� ����");
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			Thread t1 = new Thread(new GameFrame("����� Ű��� ����"));
			t1.start();
		}
	});
	
	JButton rule = new JButton("���� ���");
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
	
	setTitle("����� Ű��� ����");
	setSize(800,600);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
