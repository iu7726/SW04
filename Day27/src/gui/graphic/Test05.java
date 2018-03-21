package gui.graphic;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Window05 extends Frame {

	private class CanvasEx extends Canvas {
		private Image img;
		BufferedImage[] slice;
		
		public void setImage(int idx) {
			img = slice[idx];
		}
			
		public CanvasEx() {
			// img = Toolkit.getDefaultToolkit().getImage("Image/run.png");
			// 편집용 이미지는 BufferedImage 형태로 불러오며 , ImageIO라는 클래스를 사용한다.
			BufferedImage origin = ImageManager.load("Image/run.png");

			slice = ImageManager.slice(origin, 6,1);
			
			img = slice[0];
			
			
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			if (img != null)
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	private CanvasEx canvas = new CanvasEx();

	public Window05() {
		this.display();
		this.event();
		this.menu();

		this.setSize(500, 400);
		this.setTitle("GUI 테스트");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		//화면에 표시된 뒤부터 이미지를 일정간격으로 연속해서 다시 그려준다.
		Thread t = new Thread() {
			@Override
			public void run() {
				int idx = 0;
				while(true) {
					canvas.setImage(idx);
					canvas.repaint();
					idx++;
					try {
//						Thread.sleep(1000 / 10);//10 FPS
						Thread.sleep(1000 / 60);//60 FPS
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idx %= 6;
				}
			}
		};
		t.setDaemon(true);
		t.start();
	}

	private void menu() {
		// TODO Auto-generated method stub

	}

	private void event() {
		// TODO Auto-generated method stub
		WindowListener wl = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}

		};
		this.addWindowListener(wl);
	}

	private void display() {
		// TODO Auto-generated method stub
		this.add(canvas);
	}

}

public class Test05 {
	public static void main(String[] args) {
		Window05 window = new Window05();
	}
}
