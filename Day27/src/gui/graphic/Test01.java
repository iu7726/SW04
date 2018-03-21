package gui.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window01 extends Frame{
	
	//컴포넌트 : 캔버스 
	//Canvas 	도화지 역할의 컴포넌트
	//			그림을 그리는 메소드 paint를 가지고 있다.
	//			우리는 이 메소드를 "재정의"하여 사용
	
	//Image
	private Image img = Toolkit.getDefaultToolkit().createImage("image/reba.jpg");
	
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics pen) {
			//pen을 이용하여 Canvas에 그림을 그리면 된다.
			super.paint(pen);//더블 모니터에서는 없으면 안나옴
//			System.out.println("paint 실행");
			pen.drawLine(50, 50, 150, 150);//선 어디서 어디로
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
		this.setTitle("GUI 테스트");
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

