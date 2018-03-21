package gui.swing;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Window02 extends JFrame{
	
	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton bt = new JButton("��ư!");
	
	//Swing������ ImageIcon�̶�� Ŭ������ �̿��ؼ� �̹��� ó�� ���� ���� ������ ����
	private ImageIcon icon = new ImageIcon("image/reba.jpg");
	
	public Window02() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
//		this.setLocation(100, 200);
		//��ġ�� �ü���� �����ϵ��� ����
		this.setLocationByPlatform(true);
		//��ܺκ��� ������ �ʵ��� ����
//		this.setUndecorated(true);
		this.setResizable(true);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â����
		//���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����

	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(bt);
		
		//bt�� icon�� ����
		bt.setIcon(icon);
		bt.setText("");
		
	}
	
	
	
	
}

public class Test02 {
	public static void main(String[] args) {
		Window02 window = new Window02();
	}
}

