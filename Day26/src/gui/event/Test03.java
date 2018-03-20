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
		this.setTitle("GUI 테스트");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		
	}

	private void event() {
		
		//유니코드를 유일하게 식별할 수 있는 메소드가 keyType
		KeyListener listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("누름");
				
				//뭘눌렀냐
//				System.out.println(e.getKeyCode());
//				System.out.println(e.getKeyChar());//특수키 감지가 불가능
				switch(e.getKeyCode()) {
				case KeyEvent.VK_F5:
					Format f = new SimpleDateFormat("a h:mm y - MM - dd");
					ta.append(f.format(new Date()));
					break;
				case KeyEvent.VK_ESCAPE:
//					System.exit(0);//다 끔
					dispose();//나만 끔 JFrame명령
					break;
				}
				//조합키 처리(alt+f4 / ctrl + a)
				//e.getModifierEx();
				System.out.println(e.getModifiersEx());
				//Ctrl 키를 눌렀다면 .. 을 조건으로 구현
				if(e.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
					System.out.println("컨트롤 조합키");
				}
				
				//ctrl + alt 일경우 or연산을 통해 계싼
//				System.out.println(128|512);
				if(e.getModifiersEx() == (KeyEvent.CTRL_DOWN_MASK|KeyEvent.ALT_DOWN_MASK)) {
					System.out.println("ctrl + alt 조합키 ");
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

