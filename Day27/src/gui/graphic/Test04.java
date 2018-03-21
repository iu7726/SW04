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
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	//캔버스와 관련된 각종 변수와 메소드를 묶어서 여기서만 편하게 쓸 수 있는 클래스로 확장 구현
	// Canvas를 확장하여 CanvasEx로 구현
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
	private Button min = new Button("최소");
	private Button dec = new Button("축소");
	private Button inc = new Button("확대");
	private Button max = new Button("최대");
	
	private CanvasEx canvas = new CanvasEx();
	
	//main에 하던 설정들을 생성자에서 진행
	public Window04() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("GUI테스트");
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
		//최소화 이벤트
		min.addActionListener(e->{
			canvas.minimize();
		});
		//최대화 이벤트
		max.addActionListener(e->{
			canvas.maximize();
		});
		
		//축소 이벤트
		dec.addActionListener(e->{
			canvas.decrease();
		});
		
		//확대 이벤트
		inc.addActionListener(e->{
			canvas.increase();
		});
	}

	private void menu() {
		
	}
}

public class Test04 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window04 window = new Window04();
	}
}
