package gui.menu;

import java.awt.FileDialog;
import java.awt.Frame;

class Window03 extends Frame{
	
	//FileDialog	���� ���ÿ� ��â
	private FileDialog fd = new FileDialog(this, "���� �����ϱ�", FileDialog.SAVE);
	
	public Window03() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		fd.setVisible(true);//â�� ���� ������ block ȿ�� �߻�(���)
		
		//����ڰ� �� �ߴ��� �˾ƾ��Ѵ�.
		System.out.println("����ڰ� �� �ൿ�� ���");
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

