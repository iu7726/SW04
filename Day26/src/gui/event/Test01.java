package gui.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window01 extends Frame{
	
	private Button bt = new Button("�̿콺�� �÷�������");
	
	
	public Window01() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
		// TODO Auto-generated method stub
		//���콺 �̺�Ʈ�� ó���� �� �ִ� ��ü�� ����� ��ư�� ����
		//-> MouseListener
		MouseListener listener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
//				System.out.println("���콺 ��");
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
//				System.out.println("���콺 ����");
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
//				System.out.println("���콺 Ż��");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
//				System.out.println("���콺 ����");
			}
			
			@Override
			public void mouseClicked(MouseEvent evnet) {
				System.out.println("���콺 Ŭ��");
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

