package gui.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window01 extends Frame{
	
	//������Ʈ : ĵ���� 
	//Canvas 	��ȭ�� ������ ������Ʈ
	//			�׸��� �׸��� �޼ҵ� paint�� ������ �ִ�.
	//			�츮�� �� �޼ҵ带 "������"�Ͽ� ���
	
	//Image
	private Image img = Toolkit.getDefaultToolkit().createImage("image/reba.jpg");
	
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics pen) {
			//pen�� �̿��Ͽ� Canvas�� �׸��� �׸��� �ȴ�.
			super.paint(pen);//���� ����Ϳ����� ������ �ȳ���
//			System.out.println("paint ����");
			pen.drawLine(50, 50, 150, 150);//�� ��� ����
			pen.drawRect(50, 50, 100, 100);
			pen.fillRect(200, 50, 100, 100);
			pen.setColor(Color.blue);
			pen.drawOval(50, 50, 100, 100);
//			pen.drawOval(40, 40, 145, 145);
			pen.setFont(new Font("",Font.BOLD,30));
			pen.drawString("Hello pen", 100, 300);
			
			pen.drawImage(img, 50, 50, 300, 200, this);
			
		}
	};
	
	
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
		
	}

	private void display() {
		// TODO Auto-generated method stub
		this.add(canvas);
	}
	
	
	
	
}

public class Test01 {
	public static void main(String[] args) {
		Window01 window = new Window01();
	}
}

