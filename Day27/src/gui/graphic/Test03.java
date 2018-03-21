package gui.graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Window03 extends Frame {

	private Button minDown = new Button("최소");
	private Button down = new Button("축소");
	private Button up = new Button("확대");
	private Button maxUp = new Button("최대");

	private Panel p = new Panel();
	private int w = 200;
	private int h = 200;

	private Image img = Toolkit.getDefaultToolkit().createImage("Image/reba.jpg");

	public static final int MIN = 100;
	public static final int MAX = 300;
	public static final int INCREMENTUP = 20;
	public static final int INCREMENTDOWN = 20;
	public void change(int w, int h) {
		if(w < MIN) w = MIN;
		if(w > MAX) w = MAX;
		if(h < MIN) h = MIN;
		if(h > MAX) h = MAX;
		this.w = w;
		this.h = h;
		canvas.repaint();
	}
	
	public void miniSize() {
		change(MIN,MIN);
	}
	
	public void maxSize() {
		change(MAX,MAX);
	}
	
	public void sizeUp() {
		change(w + INCREMENTUP, h + INCREMENTUP);
	}
	
	public void sizeDown() {
		change(w - INCREMENTDOWN, h - INCREMENTDOWN);
	}
	
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(img, 100, 25, w, h, this);
		}
	};

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
		// TODO Auto-generated method stub

	}

	private void event() {
		WindowListener wl = new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		};
		
		// TODO Auto-generated method stub
		ActionListener listener = (e) -> {
			System.out.println(e.getActionCommand());
			switch (e.getActionCommand()) {
			case "최소":
				miniSize();
				break;
			case "축소":
				sizeDown();
				break;
			case "확대":
				sizeUp();
				break;
			case "최대":
				maxSize();
				break;

			}
		};
		minDown.addActionListener(listener);
		down.addActionListener(listener);
		up.addActionListener(listener);
		maxUp.addActionListener(listener);
		this.addWindowListener(wl);

	}

	private void display() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
		p.setLayout(new GridLayout(1, 2, 20, 20));
		p.add(minDown);
		p.add(down);
		p.add(up);
		p.add(maxUp);
	}

}

public class Test03 {
	public static void main(String[] args) {
		Window03 window = new Window03();
	}
}
