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

class Window06 extends Frame {

	private class CanvasEx extends Canvas {
		private Image img;
		BufferedImage[] slice;
		
		public void setImage(int idx) {
			img = slice[idx];
		}
			
		public CanvasEx() {
			// img = Toolkit.getDefaultToolkit().getImage("Image/run.png");
			// 편집용 이미지는 BufferedImage 형태로 불러오며 , ImageIO라는 클래스를 사용한다.
			BufferedImage origin = ImageManager.load("Image/attack.JPG");

			slice = ImageManager.slice(origin, 4,2);
			
			img = slice[0];
			
			
		}

		@Override
		public void paint(Graphics g) {
			//이미지를 하나 가지고 지웠다 그렸다 하므로 끊김이 발생
			super.paint(g);
//			if (img != null)
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			//더블 버퍼링 : 백그라운드에서 관련된 모든 그림작업을 처리하고 나서 덮어쓰기
			
			//비어있는 이미지를 캔스버스와 똑같은 크기로 생성
			Image back = createImage(getWidth(),getHeight());
			
			//이미지에 사용할 펜을 추출
			Graphics pen = back.getGraphics();
			
			//백그라운드 이미지에 그리고 싶은것들을 그린다.
			pen.drawImage(img, 0, 0, getWidth(), getHeight(), null);
			
			//완성된 백그라운드 이미지를 캔버스(this)에 그린다.
			g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		}
		
		//paint가 호출되기 전에 청소를 담당하는 메소드가 존재 update메소드
		@Override
		public void update(Graphics g) {
//			g.clearRect(0, 0, getWidth(),getHeight());
			paint(g);
		}
	}

	private CanvasEx canvas = new CanvasEx();

	public Window06() {
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
						Thread.sleep(1000 / 10);//10 FPS
//						Thread.sleep(1000 / 60);//60 FPS
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idx %= 4;
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

public class Test06 {
	public static void main(String[] args) {
		Window06 window = new Window06();
	}
}
