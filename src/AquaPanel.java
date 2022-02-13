import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class AquaPanel extends JPanel
{
	ImageIcon icon;
	public static int green = 0;
	public static int f_size = 15;
	
	public static Fish[] fish;
	ImageIcon back, f;
	int click_x = 0, click_y = 0;
	int attack_x = 0, attack_y = 0;
	BufferedImage feed = null;
	int count = 0;
	public static int i;
	
	Enemy enm;
	ImageIcon img;
	
	ImageIcon over, clear;
	
	boolean effect = false;
	boolean attack = false;
	ImageIcon food, damage;
	
	AquaPanel()
	{
		
		fish = new Fish[f_size];
		for(i = 0; i < f_size; i++) {
			fish[i] = new Fish(this, 250, 250);
			fish[i].start();
			count++;
		}


		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				click_x = e.getX();
				click_y = e.getY();
				
				for (int i = 0; i < count; i++) {
					if ((fish[i].x< click_x && click_x < fish[i].x+100)&&(fish[i].y < click_y && click_y < fish[i].y+100)) {
						fish[i].Life();
						effect = true;
					}
				}
			}
			public void mouseReleased(MouseEvent e) {
				effect = false;
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}	
		});
		
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				click_x = e.getX();
				click_y = e.getY();
				repaint();
			}
		});
		
		try {
			feed = ImageIO.read(new File("./image/먹이.png"));
		} catch (IOException e1) {
			System.out.println("no image");
			System.exit(1);
		}
		

		addMouseListener(new MouseListener() 
		{
			public void mousePressed(MouseEvent e)
			{
				attack_x = e.getX();
				attack_y = e.getY();
				if((enm.x < attack_x && attack_x < enm.x+200) && (enm.y < attack_y && attack_y < enm.y+200))
				{
					effect=false;
					attack=true;
					Enemy.life--;
				}
				
			}
			public void mouseClicked(MouseEvent e) 
			{
			}
			public void mouseReleased(MouseEvent e) 
			{
				attack = false;
			}
			public void mouseEntered(MouseEvent e) 
			{
			}
			public void mouseExited(MouseEvent e) 
			{
			}
		});
	
		int start_x = (int)(Math.random() * 700) + 1;
		int start_y = (int)(Math.random() * 500) + 1;
		
		enm = new Enemy(this, start_x, start_y);	
		enm.start();
		

		setVisible(true);
		
		

		icon = new ImageIcon("image/background.png");
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Dimension d = getSize();
		g.drawImage(icon.getImage(), 0,0,d.width, d.height, null);
		
		Color c = new Color(0,255,0,green*2);
		g.setColor(c);
		
		g.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
		

		f = new ImageIcon("./image/fish3 - 복사본.png");

		for (int i = 0; i < count; i++) {
			g.drawImage(f.getImage(), fish[i].x, fish[i].y, null);
		}
		g.drawImage(feed, click_x-30, click_y-30, null);
		if (effect) {
			food = new ImageIcon("./image/먹이효과.png");
			g.drawImage(food.getImage(), click_x, click_y, null);
		}
		
		if (GameFrame.Over) {
			over = new ImageIcon("./image/over.png");
			g.drawImage(over.getImage(), 80, 100, null);
		}
		else if (GameFrame.Clear) {
			clear = new ImageIcon("./image/clear.png");
			g.drawImage(clear.getImage(), 100, 100, null);
		}
	
		img = new ImageIcon("./image/shark.png");
		
		g.drawImage(img.getImage(), enm.x, enm.y, null);
		
		if (attack) {
			damage = new ImageIcon("./image/공격.png");
			g.drawImage(damage.getImage(), attack_x-50, attack_y, null);
		}

	}
}


