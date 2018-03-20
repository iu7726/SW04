package gui.menu;

import java.awt.Dialog;
import java.awt.Frame;

class Window02 extends Frame{
	
	//다이얼로그 생성
	private Dialog dialog = new Dialog(this,"다이얼로그",false);
	
	public Window02() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI 테스트");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		//창이 표시되고 나서 잠시 뒤에 다이얼로그를 표시
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//다이얼로그 역시 Frame과 동일한 명령으로 사용
		dialog.setSize(300, 300);
		dialog.setLocation(200, 200);
		dialog.setResizable(false);
		dialog.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
		// TODO Auto-generated method stub
		
	}

	private void display() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

public class Test02 {
	public static void main(String[] args) {
		Window02 window = new Window02();
	}
}

