package gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


class Window04 extends JFrame{
	
	// 기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다.
	// Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JTextArea jta = new JTextArea();
	
	private JScrollPane jsp = new JScrollPane(jta);
	
	public Window04() {
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
		
		//우리가 알던 이벤트 외에 Swing에서는 "내장 단축키"를 변경할 수 있다.
		//단축키 객체를 만들어야 한다. - keyStroke
//		KeyStroke enter = KeyStroke.getKeyStroke(입력키,조합키);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
		KeyStroke ctrlEnter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,KeyEvent.CTRL_DOWN_MASK);
		
		Action enterAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("전송!");
			}
		};
		
		Action ctrlEnterAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("다음줄로 이동!");
			}
		};
		
		//jta에 존재하는 InputMap과 ActionMap에 단축키 + 별칭 / 별칭 + 액션을 등록
		jta.getInputMap().put(enter, "전송");
		jta.getActionMap().put("전송", enterAction);
		
		jta.getInputMap().put(ctrlEnter, "다음");
		jta.getActionMap().put("다움", ctrlEnterAction);
		
			
			

	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.setLayout(new BorderLayout());
		//mainPanel.add(jta);//스크롤 불가
		mainPanel.add(jsp);//스크롤 가능
		//스크롤바 설정
//		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
	}
	
	
	
	
}

public class Test04 {
	public static void main(String[] args) {
		Window04 window = new Window04();
	}
}

