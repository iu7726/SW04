package gui.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class Window03 extends JFrame{
	
	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JLabel lb1 = new JLabel("��1",JLabel.CENTER);
	private JLabel lb2 = new JLabel("��2",JLabel.CENTER);
	private JLabel lb3 = new JLabel("��3",JLabel.CENTER);
	private JLabel lb4 = new JLabel("��4",JLabel.CENTER);
	
	public Window03() {
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
		this.setResizable(false);
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
		mainPanel.setLayout(new GridLayout(2, 2));
		mainPanel.add(lb1);
		mainPanel.add(lb2);
		mainPanel.add(lb3);
		mainPanel.add(lb4);
		
		//Border�� ���� Swing Component�� ����
//		LineBorder line = new LineBorder(Color.black, 1, false);//���� ����
		Border line = BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true);
		lb1.setBorder(line);
		
//		Border title = BorderFactory.createTitledBorder("������ ����");
		Border title = BorderFactory.createTitledBorder(line, "������ ����");
		lb2.setBorder(title);
		
		Border mt = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		lb3.setBorder(mt);
		lb3.setOpaque(true);
		lb3.setBackground(Color.cyan);
		
		Border dual = BorderFactory.createCompoundBorder(mt, line);
		lb4.setBorder(dual);
		
	}
	
	
	
	
}

public class Test03 {
	public static void main(String[] args) {
		Window03 window = new Window03();
	}
}

