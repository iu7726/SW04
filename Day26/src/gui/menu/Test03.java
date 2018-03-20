package gui.menu;

import java.awt.FileDialog;
import java.awt.Frame;

class Window03 extends Frame{
	
	//FileDialog	파일 선택용 새창
	private FileDialog fd = new FileDialog(this, "파일 저장하기", FileDialog.SAVE);
	
	public Window03() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI 테스트");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		fd.setVisible(true);//창이 꺼질 때까지 block 효과 발생(대기)
		
		//사용자가 뭘 했는지 알아야한다.
		System.out.println("사용자가 한 행동과 결과");
		System.out.println(fd.getFile());
		System.out.println(fd.getDirectory());
		
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

public class Test03 {
	public static void main(String[] args) {
		Window03 window = new Window03();
	}
}

