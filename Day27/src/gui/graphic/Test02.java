package gui.graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window02 extends Frame{
	
	private Image image = Toolkit.getDefaultToolkit().createImage("Image/reba.jpg");
	
	private int x = 20;
	private int y = 20;
	
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image, x, y, 100, 100,this);
			
		}
	};
	
	private Button bt = new Button("�̵�");
	
	public Window02() {
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
		//��ư�� ActionEvnet ó�� ��ü�� ����(���ε�)
		bt.addActionListener((e) -> {
			//��ǥ�� �ٲ۵� �ٽ� �׸����� ���� -> Canvas���� ����
			x += 20;
			y += 20;
			canvas.repaint();//paint()�� �ڵ����� ��������
		});
	}

	private void display() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		this.add(canvas);
		this.add(bt,BorderLayout.SOUTH);
	}
	
	
	
	
}

public class Test02 {
	public static void main(String[] args) {
		Window02 window = new Window02();
	}
}

