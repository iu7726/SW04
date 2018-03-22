package gui.swing;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

class Window13 extends JFrame {

	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private BufferedImage img;
	private JPanel mainPanel = new JPanel() {
		protected void paintComponent(java.awt.Graphics g) {
			if (img != null) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
	};

	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("���");
	private JMenuItem capture = new JMenuItem("��ũ���� ĸ��");

	// swing������ Panel�� Canvas����� �ִ�.
	public Window13() {
		this.display();
		this.event();
		this.menu();

		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
		// this.setLocation(100, 200);
		// ��ġ�� �ü���� �����ϵ��� ����
		this.setLocationByPlatform(true);
		// ��ܺκ��� ������ �ʵ��� ����
		// this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		this.setJMenuBar(bar);
		bar.add(menu);
		menu.add(capture);
	}

	private void event() {
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// â ����
		// this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â����
		// ���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
		// this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
		//���콺 ���� �ڵ� MouseInfo ���� 3��
		KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
		// f5�� menu�� ����Ű�� ����
		capture.setAccelerator(f5);
		capture.addActionListener(e -> {
			try {
				Robot r = new Robot();
				//Toolkit�� �̿��� ����� ũ�⸦ ���
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				System.out.println(d);
				Rectangle rect = new Rectangle(0, 0, d.width, d.height);
				Thread t = new Thread() {
					public void run() {
						// TODO Auto-generated method stub
						while (true) {
							img = r.createScreenCapture(rect);
							mainPanel.repaint();
							try {
								Thread.sleep(1000/60);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				};
				t.setDaemon(true);
				t.start();
			} catch (Exception err) {
				// TODO: handle exception
			}
		});

	}

	private void display() {
		// TODO Auto-generated method stub
		// mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);

		// ��� ������Ʈ�� �߰��� mainPanel�� ����

	}

}

public class Test13 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window13 window = new Window13();
	}
}
