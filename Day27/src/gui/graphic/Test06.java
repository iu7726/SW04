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
			// ������ �̹����� BufferedImage ���·� �ҷ����� , ImageIO��� Ŭ������ ����Ѵ�.
			BufferedImage origin = ImageManager.load("Image/attack.JPG");

			slice = ImageManager.slice(origin, 4,2);
			
			img = slice[0];
			
			
		}

		@Override
		public void paint(Graphics g) {
			//�̹����� �ϳ� ������ ������ �׷ȴ� �ϹǷ� ������ �߻�
			super.paint(g);
//			if (img != null)
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			//���� ���۸� : ��׶��忡�� ���õ� ��� �׸��۾��� ó���ϰ� ���� �����
			
			//����ִ� �̹����� ĵ�������� �Ȱ��� ũ��� ����
			Image back = createImage(getWidth(),getHeight());
			
			//�̹����� ����� ���� ����
			Graphics pen = back.getGraphics();
			
			//��׶��� �̹����� �׸��� �����͵��� �׸���.
			pen.drawImage(img, 0, 0, getWidth(), getHeight(), null);
			
			//�ϼ��� ��׶��� �̹����� ĵ����(this)�� �׸���.
			g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		}
		
		//paint�� ȣ��Ǳ� ���� û�Ҹ� ����ϴ� �޼ҵ尡 ���� update�޼ҵ�
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
		this.setTitle("GUI �׽�Ʈ");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
		
		//ȭ�鿡 ǥ�õ� �ں��� �̹����� ������������ �����ؼ� �ٽ� �׷��ش�.
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
