package gui.swing;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

class Window05 extends JFrame{
	
	private JPanel mainPanel = new JPanel();
	
	//메뉴 
	//JMenuBar - JMenu - JMenuItem / JCheckboxMenuItem / JRadioButtonMenuItem(여러개중에 1개만 고를수 있는 버튼)
	private JMenuBar bar = new JMenuBar();
	
	private JMenu file = new JMenu("파일");
	private JMenuItem exit = new JMenuItem("종료하기");
	
	private JRadioButtonMenuItem r1 = new JRadioButtonMenuItem("일반용");
	private JRadioButtonMenuItem r2 = new JRadioButtonMenuItem("공학용");
	
	
	
	
	public Window05() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI 테스트");
		this.setLocationByPlatform(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		this.setJMenuBar(bar);
		bar.add(file);
		file.add(exit);
		file.add(r1);
		file.add(r2);
		
		//버튼 그룹을 만들어 r1,r2가 묶음임을 알려준다.
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(r1);
		bg.add(r2);
		r1.setSelected(true);
	}

	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
		
		//메뉴의 단축키 지정할 때도 KeyStroke를 이용
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		
		//단축키 지정 - 지정한 뒤 단축키를 누르면 ActionEvent가 발생
		exit.setAccelerator(esc);
		
		exit.addActionListener(e -> {
			dispose();
		});
		
		
		
	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		
		
	}
	
	
	
	
}

public class Test05 {
	public static void main(String[] args) {
		Window05 window = new Window05();
	}
}

