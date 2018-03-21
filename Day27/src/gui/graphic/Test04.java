package gui.graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

class Window04 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	//ĵ������ ���õ� ���� ������ �޼ҵ带 ��� ���⼭�� ���ϰ� �� �� �ִ� Ŭ������ Ȯ�� ����
	// Canvas�� Ȯ���Ͽ� CanvasEx�� ����
	private class CanvasEx extends Canvas{
		private Image image = Toolkit.getDefaultToolkit().createImage("Image/reba.jpg");
		
		private int width = 200;
		private int height = 200;
		
		public static final int MIN_WIDTH = 100;
		public static final int MAX_WIDTH = 300;
		public static final int MIN_HEIGHT = 100;
		public static final int MAX_HEIGHT = 300;
		public static final int WIDTH_INCREMENT = 20;
		public static final int HEIGHT_INCREMENT = 20;
		
		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 30, 30, width, height, this);
		}
		
		public void change(int width, int height) {
			if(width < MIN_WIDTH) width = MIN_WIDTH;
			if(width > MAX_WIDTH) width = MAX_WIDTH;
			if(height < MIN_HEIGHT) height = MIN_HEIGHT;
			if(height > MAX_HEIGHT) height = MAX_HEIGHT;
			this.width = width;
			this.height = height;
			this.repaint();
		}
		public void minimize() {
			change(MIN_WIDTH, MIN_HEIGHT);
		}
		public void maximize() {
			change(MAX_WIDTH, MAX_HEIGHT);
		}
		public void increase() {
			change(width + WIDTH_INCREMENT, height + HEIGHT_INCREMENT);
		}
		public void decrease() {
			change(width - WIDTH_INCREMENT, height - HEIGHT_INCREMENT);
		}
	}
	
	private Panel panel = new Panel();
	private Button min = new Button("�ּ�");
	private Button dec = new Button("���");
	private Button inc = new Button("Ȯ��");
	private Button max = new Button("�ִ�");
	
	private CanvasEx canvas = new CanvasEx();
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window04() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		this.setLayout(new BorderLayout());
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(min);
		panel.add(dec);
		panel.add(inc);
		panel.add(max);
	}

	private void event() {
		//�ּ�ȭ �̺�Ʈ
		min.addActionListener(e->{
			canvas.minimize();
		});
		//�ִ�ȭ �̺�Ʈ
		max.addActionListener(e->{
			canvas.maximize();
		});
		
		//��� �̺�Ʈ
		dec.addActionListener(e->{
			canvas.decrease();
		});
		
		//Ȯ�� �̺�Ʈ
		inc.addActionListener(e->{
			canvas.increase();
		});
	}

	private void menu() {
		
	}
}

public class Test04 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window04 window = new Window04();
	}
}
