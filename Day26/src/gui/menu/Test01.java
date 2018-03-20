package gui.menu;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;

class Window01 extends Frame{
	
	//메뉴를 객체로 생성
	//MenuBar -> Menu -> Menu, MenuItem, CheckboxMenuItem
	private MenuBar mb = new MenuBar();
	
	private Menu file = new Menu("file");
	private Menu window = new Menu("Window");
	
	private MenuItem n = new MenuItem("new");
	private MenuItem exit = new MenuItem("exit"); 
	
	private Menu sv = new Menu("Show view");
	private CheckboxMenuItem console = new CheckboxMenuItem("Console");
	private CheckboxMenuItem outLine = new CheckboxMenuItem("Outline");
	
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
		this.setMenuBar(mb);
	}

	private void event() {
		// TODO Auto-generated method stub
		ActionListener listener = (e) -> {
			dispose();
		};
		
		console.addItemListener(e -> {
			System.out.println(console.getState());
		});
		exit.addActionListener(listener);
	}

	private void display() {
		// TODO Auto-generated method stub
		mb.add(file);
		file.add(n);
		file.add(exit);
		mb.add(window);
		window.add(sv);
		sv.add(console);
		sv.add(outLine);
	}
	
	
	
	
}

public class Test01 {
	public static void main(String[] args) {
		Window01 window = new Window01();
	}
}

