package gui.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window02 extends Frame{
	
	private Label label = new Label("이용 약관에 동의하십니까?",Label.CENTER);
	
	private Button yes = new Button("예");
	private Button no = new Button("아니요");
	
	private BorderLayout border = new BorderLayout();
	private GridLayout grid = new GridLayout(1, 2);
	
	private Font font = new Font("",Font.PLAIN,30);
	
	
	private Panel p = new Panel();
	
	

	
	public Window02() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI 테스트");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
		// TODO Auto-generated method stub
		//*Listener의 경우 인터페이스라 무조건 재정의를 해야 하므로 코드 낭비가 발생
		//-> 메소드가 2개 이상인 Listener는 반드시 이를 상속한 클래스가 존재(Adapter)
		MouseListener listener = new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent event) {
				// TODO Auto-generated method stub
				yes.setBackground(Color.white);
				if(event.getSource().equals(yes)) {
					yes.setBackground(null);
				}else {
					no.setBackground(null);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent event) {
				// TODO Auto-generated method stub
				
				if(event.getSource().equals(yes)) {
					yes.setBackground(Color.YELLOW);
				}else {
					no.setBackground(Color.YELLOW);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 1) {
					yes.setEnabled(false);
					no.setEnabled(false);
					label.setText("처리가 완료되었습니다.");
				}
			}
		};
		yes.addMouseListener(listener);
		no.addMouseListener(listener);
	}

	private void display() {
		// TODO Auto-generated method stub
		
		setLayout(new GridLayout(2, 1));
		add(label);
		add(p);
		p.setLayout(grid);
		p.add(yes);
		p.add(no);
		yes.setFont(font);
		no.setFont(font);
		
	}
	
	
	
	
}

public class Test02 {
	public static void main(String[] args) {
		Window02 window = new Window02();
	}
}

