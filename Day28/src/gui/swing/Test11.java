package gui.swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


class Window11 extends JFrame{
	
	// 기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다.
	// Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton a = new JButton("알림창");
	private JButton b = new JButton("확인창");
	private JButton c = new JButton("입력창");
	private JButton d = new JButton("색상선택창");
	private JButton e = new JButton("파일선택창");
	
	public Window11() {
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
		a.addActionListener(e -> {
			//알림창		JOptionPane.showMessageDialog(기준컴포넌트, 메세지,타이틀,메세지타입,아이콘);
			JOptionPane.showMessageDialog(mainPanel, "알림창입니다.","알림창",JOptionPane.INFORMATION_MESSAGE);
//			JOptionPane.showInternalMessageDialog(mainPanel, "하이");//내부알림창
		});
		b.addActionListener(e -> {
			//확인창 JOptionPane.showConfirmDialog(기준, 메세지, 제목, 유형, 종류);
			int a = JOptionPane.showConfirmDialog(mainPanel, "전재산 기부?","기부",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			switch(a) {
			case 0:
				JOptionPane.showMessageDialog(mainPanel, "전재산을 기부하였습니다.");
				break;
			}
			System.out.println(a);
		});
		c.addActionListener(e -> {
			//JOptionPane.showInputDialog(기준, 메세지, 제목, 종류)
			String str = JOptionPane.showInputDialog(mainPanel,"입력","테스트",JOptionPane.QUESTION_MESSAGE);
			if(str == null) return;
			System.out.println(str);
			alert(str);
		});
		d.addActionListener(e -> {
			//JColorChooser.showDialog(컴포넌트, 타이틀, 초기색상);
			Color color = JColorChooser.showDialog(mainPanel, "색상 선택", Color.black);
			if(color == null) return;
			mainPanel.setBackground(color);
		});
		e.addActionListener(e -> {
//			파일 선택창  JFileChooser	인스턴스 생성 후 사용
			JFileChooser chooser = new JFileChooser(".");
			//선택할 대상에 대한 설정
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int a = chooser.showOpenDialog(mainPanel);
//			int a = chooser.showSaveDialog(mainPanel);
			if(a != 0) return;
			System.out.println(a);
			File file = chooser.getSelectedFile();
			System.out.println(file);
		});
		

	}
	
	public void alert(String text) {
		JOptionPane.showMessageDialog(mainPanel,text,"알림",JOptionPane.PLAIN_MESSAGE);
	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.add(a);
		mainPanel.add(b);
		mainPanel.add(c);
		mainPanel.add(d);
		mainPanel.add(e);	
	}
}

public class Test11 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window11 window = new Window11();
	}
}

