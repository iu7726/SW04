package gui.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class Window03 extends JFrame{
	
	// 기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다.
	// Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JLabel lb1 = new JLabel("라벨1",JLabel.CENTER);
	private JLabel lb2 = new JLabel("라벨2",JLabel.CENTER);
	private JLabel lb3 = new JLabel("라벨3",JLabel.CENTER);
	private JLabel lb4 = new JLabel("라벨4",JLabel.CENTER);
	
	public Window03() {
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
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.setLayout(new GridLayout(2, 2));
		mainPanel.add(lb1);
		mainPanel.add(lb2);
		mainPanel.add(lb3);
		mainPanel.add(lb4);
		
		//Border를 만들어서 Swing Component에 설정
//		LineBorder line = new LineBorder(Color.black, 1, false);//직접 제작
		Border line = BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true);
		lb1.setBorder(line);
		
//		Border title = BorderFactory.createTitledBorder("오늘의 할일");
		Border title = BorderFactory.createTitledBorder(line, "오늘의 할일");
		lb2.setBorder(title);
		
		Border mt = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		lb3.setBorder(mt);
		lb3.setOpaque(true);
		lb3.setBackground(Color.cyan);
		
		Border dual = BorderFactory.createCompoundBorder(mt, line);
		lb4.setBorder(dual);
		
	}
	
	
	
	
}

public class Test03 {
	public static void main(String[] args) {
		Window03 window = new Window03();
	}
}

