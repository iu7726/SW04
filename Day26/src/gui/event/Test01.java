package gui.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window01 extends Frame{
	
	private Button bt = new Button("미우스를 올려보세요");
	
	
	public Window01() {
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
		//마우스 이벤트를 처리할 수 있는 객체를 만들어 버튼에 설정
		//-> MouseListener
		MouseListener listener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
//				System.out.println("마우스 땜");
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
//				System.out.println("마우스 누름");
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
//				System.out.println("마우스 탈출");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
//				System.out.println("마우스 진입");
			}
			
			@Override
			public void mouseClicked(MouseEvent evnet) {
				System.out.println("마우스 클릭");
				System.out.println(evnet.getButton());
				System.out.println(evnet.getClickCount());
				System.out.println(evnet.getSource());
			}
		};
		bt.addMouseListener(listener);
	}

	private void display() {
		// TODO Auto-generated method stub
		add(bt);
	}
	
	
	
	
	
}

public class Test01 {
	public static void main(String[] args) {
		Window01 window = new Window01();
	}
}

