package gui.menu;

import java.awt.Dialog;
import java.awt.Frame;

class Window02 extends Frame{
	
	//���̾�α� ����
	private Dialog dialog = new Dialog(this,"���̾�α�",false);
	
	public Window02() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		//â�� ǥ�õǰ� ���� ��� �ڿ� ���̾�α׸� ǥ��
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���̾�α� ���� Frame�� ������ ������� ���
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

