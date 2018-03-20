package gui.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window02 extends Frame{
	
	private Label label = new Label("�̿� ����� �����Ͻʴϱ�?",Label.CENTER);
	
	private Button yes = new Button("��");
	private Button no = new Button("�ƴϿ�");
	
	private BorderLayout border = new BorderLayout();
	private GridLayout grid = new GridLayout(1, 2);
	
	private Font font = new Font("",Font.PLAIN,30);
	
	
	private Panel p = new Panel();
	
	

	
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
		//*Listener�� ��� �������̽��� ������ �����Ǹ� �ؾ� �ϹǷ� �ڵ� ���� �߻�
		//-> �޼ҵ尡 2�� �̻��� Listener�� �ݵ�� �̸� ����� Ŭ������ ����(Adapter)
		MouseListener listener = new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent event) {
				// TODO Auto-generated method stub
				yes.setBackground(Color.white);
				if(event.getSource().equals(yes)) {
					yes.setBackground(null);
				}else {
					no.setBackground(null);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent event) {
				// TODO Auto-generated method stub
				
				if(event.getSource().equals(yes)) {
					yes.setBackground(Color.YELLOW);
				}else {
					no.setBackground(Color.YELLOW);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 1) {
					yes.setEnabled(false);
					no.setEnabled(false);
					label.setText("ó���� �Ϸ�Ǿ����ϴ�.");
				}
			}
		};
		yes.addMouseListener(listener);
		no.addMouseListener(listener);
	}

	private void display() {
		// TODO Auto-generated method stub
		
		setLayout(new GridLayout(2, 1));
		add(label);
		add(p);
		p.setLayout(grid);
		p.add(yes);
		p.add(no);
		yes.setFont(font);
		no.setFont(font);
		
	}
	
	
	
	
}

public class Test02 {
	public static void main(String[] args) {
		Window02 window = new Window02();
	}
}

