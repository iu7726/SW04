package gui.swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

class Window14 extends JFrame {

	private BufferedImage img;
	private JPanel mainPanel = new JPanel() {
		protected void paintComponent(java.awt.Graphics g) {
			if (img != null) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
	};

	private JMenuBar bar = new JMenuBar();
	private JMenu fuction = new JMenu("���");
	private JMenuItem start = new JMenuItem("����");
	private JMenuItem exit = new JMenuItem("����");
	private JLabel lb = new JLabel("f1 ���� esc ����");
	
	private int size = 300;
	private int zoom = 3;//���� ����
	private int megascope = size/zoom;

	public Window14() {
		this.display();
		this.event();
		this.menu();
		

		this.setSize(size, size);
		this.setLocationByPlatform(true);
		// ��ܺκ��� ������ �ʵ��� ����
		 this.setUndecorated(true);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

	private void menu() {
		this.setJMenuBar(bar);
		bar.add(fuction);
		fuction.add(start);
		fuction.add(exit);
	}
	
	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// â ����
		
		
		KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		
		exit.setAccelerator(esc);
		exit.addActionListener(e -> {
			dispose();
		});
		
		start.setAccelerator(f1);
		start.addActionListener(e -> {
			try {
				lb.setVisible(false);
				Robot r = new Robot();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				Thread t = new Thread() {
					public void run() {
						while (true) {
							int x = MouseInfo.getPointerInfo().getLocation().x;//���콺 ������ x��ǥ
							int y = MouseInfo.getPointerInfo().getLocation().y;//���콺 ������ y��ǥ
							//���콺 ����Ʈ �ֺ��� Ȯ��
							Rectangle rect = new Rectangle(x-(megascope/2), y-(megascope/2), megascope, megascope);
							//���콺 �����͸� ���� JFrame�̵�
							Window14.this.setLocation(x+(megascope/2), y-(size));
							img = r.createScreenCapture(rect);
							mainPanel.repaint();
							try {
								Thread.sleep(1000/60);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
				t.setDaemon(true);
				t.start();
			} catch (Exception err) {
				err.printStackTrace();
			}
		});

	}

	private void display() {
		this.setContentPane(mainPanel);
		mainPanel.add(lb);
		lb.setFont(new Font("",Font.BOLD,30));

	}

}

public class Test14 {
	public static void main(String[] args) {
		Window14 window = new Window14();
	}
}
