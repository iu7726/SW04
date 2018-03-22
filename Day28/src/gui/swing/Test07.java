package gui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

class Window07 extends JFrame{
	
	// 기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다.
	// Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton bt1 = new JButton("1번");
	private JButton bt2 = new JButton("2번");
	private JButton bt3 = new JButton("3번");
	
	
	
	public Window07() {
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

	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		mainPanel.setLayout(null);
		
		//레이아웃이 없으면 좌표를 지정해 줘야 한다.
//		bt1.setLocation(50, 50);
//		bt1.setSize(200,100);
		bt1.setBounds(50, 50, 50, 30);
		bt2.setBounds(300, 100, 50, 30);
		bt3.setBounds(100, 250, 50, 30);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.add(bt1);
		mainPanel.add(bt2);
		mainPanel.add(bt3);
		
	}
	
	
	
	
}

public class Test07 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window07 window = new Window07();
	}
}

