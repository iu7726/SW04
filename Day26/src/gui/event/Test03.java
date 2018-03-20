package gui.event;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

class Window03 extends Frame{
	
	private TextArea ta = new TextArea();
	
	public Window03() {
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
		
	}

	private void event() {
		
		//�����ڵ带 �����ϰ� �ĺ��� �� �ִ� �޼ҵ尡 keyType
		KeyListener listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("����");
				
				//��������
//				System.out.println(e.getKeyCode());
//				System.out.println(e.getKeyChar());//Ư��Ű ������ �Ұ���
				switch(e.getKeyCode()) {
				case KeyEvent.VK_F5:
					Format f = new SimpleDateFormat("a h:mm y - MM - dd");
					ta.append(f.format(new Date()));
					break;
				case KeyEvent.VK_ESCAPE:
//					System.exit(0);//�� ��
					dispose();//���� �� JFrame���
					break;
				}
				//����Ű ó��(alt+f4 / ctrl + a)
				//e.getModifierEx();
				System.out.println(e.getModifiersEx());
				//Ctrl Ű�� �����ٸ� .. �� �������� ����
				if(e.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
					System.out.println("��Ʈ�� ����Ű");
				}
				
				//ctrl + alt �ϰ�� or������ ���� ���
//				System.out.println(128|512);
				if(e.getModifiersEx() == (KeyEvent.CTRL_DOWN_MASK|KeyEvent.ALT_DOWN_MASK)) {
					System.out.println("ctrl + alt ����Ű ");
				}
				
			}
		};
		ta.addKeyListener(listener);
	}

	private void display() {
		this.add(ta);
		ta.setFont(new Font("",Font.BOLD,30));
	}
	
	
	
	
}

public class Test03 {
	public static void main(String[] args) {
		Window03 window = new Window03();
	}
}

