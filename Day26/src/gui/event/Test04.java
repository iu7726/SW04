package gui.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class Window04 extends Frame{
	
	
	public Window04() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI Å×½ºÆ®");
		this.setLocation(100, 200);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
		// TODO Auto-generated method stub
		WindowListener listener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getWindow());
				dispose();
			}
		};
		this.addWindowListener(listener);
	}

	private void display() {
		// TODO Auto-generated method stub
	}
	
	
	
	
}

public class Test04 {
	public static void main(String[] args) {
		Window04 window = new Window04();
	}
}

