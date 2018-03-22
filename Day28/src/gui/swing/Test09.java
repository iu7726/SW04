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
	
	// 기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다.
	// Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JToolBar toolbar = new JToolBar();
	
	private JButton jajang = new JButton("자장면");
	private JButton jjambbang = new JButton("짬뽕");
	private JButton rice = new JButton("볶음밥");
	private JButton rand = new JButton("아무거나");
	
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
		this.setTitle("GUI 테스트");
//		this.setLocation(100, 200);
		//위치를 운영체제가 결정하도록 하자
		this.setLocationByPlatform(true);
		//상단부분이 나오지 않도록 설정
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//프로그램 종료
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//창숨김
		//위의 것들이 다 싫을 경우 커스텀 이벤트 설정
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//기본 이벤트 방지
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
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(toolbar, BorderLayout.NORTH);
		mainPanel.add(lb, BorderLayout.CENTER);
		toolbar.add(jajang);
		toolbar.add(jjambbang);
		toolbar.add(rice);
		toolbar.add(rand);
		
		Border line = BorderFactory.createLineBorder(Color.black,3);
		Border title = BorderFactory.createTitledBorder(line,"사진");
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

