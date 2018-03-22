package gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.Border;

class Window09 extends JFrame{
	
	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JToolBar toolbar = new JToolBar();
	
	private JButton jajang = new JButton("�����");
	private JButton jjambbang = new JButton("«��");
	private JButton rice = new JButton("������");
	private JButton rand = new JButton("�ƹ��ų�");
	
	private JLabel lb = new JLabel();
	
	private String name;
	
	private ImageIcon jajangimg = new ImageIcon("image/jajang.jpg");
	private ImageIcon jjamimg = new ImageIcon("image/jjambbang.jpg");
	private ImageIcon ricegimg = new ImageIcon("image/rice.jpg");
	

	
	public Window09() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
//		this.setLocation(100, 200);
		//��ġ�� �ü���� �����ϵ��� ����
		this.setLocationByPlatform(true);
		//��ܺκ��� ������ �ʵ��� ����
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â����
		//���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
		jajang.addActionListener(e -> {
			lb.setIcon(jajangimg);
		});
		jjambbang.addActionListener(e -> {
			lb.setIcon(jjamimg);
		});
		rice.addActionListener(e -> {
			lb.setIcon(ricegimg);
		});
		rand.addActionListener(e -> {
			Thread t = new Thread() {
				public void run() {
					// TODO Auto-generated method stub
					for(int i = 0 ; i < 30 ; i++) {
						switch(i%3) {
						case 0:
							lb.setIcon(jajangimg);
							break;
						case 1:
							lb.setIcon(jjamimg);
							break;
						case 2:
							lb.setIcon(ricegimg);
							break;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					switch((int)(Math.random()*3)) {
					case 0:
						lb.setIcon(jajangimg);
						break;
					case 1:
						lb.setIcon(jjamimg);
						break;
					case 2:
						lb.setIcon(ricegimg);
						break;
					}
				}
			};
			t.setDaemon(true);
			t.start();
		});

	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(toolbar, BorderLayout.NORTH);
		mainPanel.add(lb, BorderLayout.CENTER);
		toolbar.add(jajang);
		toolbar.add(jjambbang);
		toolbar.add(rice);
		toolbar.add(rand);
		
		Border line = BorderFactory.createLineBorder(Color.black,3);
		Border title = BorderFactory.createTitledBorder(line,"����");
		mainPanel.setBorder(title);
		
		
	}
	
	
	
	
}

public class Test09 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window09 window = new Window09();
	}
}

