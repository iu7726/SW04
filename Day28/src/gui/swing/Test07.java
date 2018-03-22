package gui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

class Window07 extends JFrame{
	
	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton bt1 = new JButton("1��");
	private JButton bt2 = new JButton("2��");
	private JButton bt3 = new JButton("3��");
	
	
	
	public Window07() {
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
		
		mainPanel.setLayout(null);
		
		//���̾ƿ��� ������ ��ǥ�� ������ ��� �Ѵ�.
//		bt1.setLocation(50, 50);
//		bt1.setSize(200,100);
		bt1.setBounds(50, 50, 50, 30);
		bt2.setBounds(300, 100, 50, 30);
		bt3.setBounds(100, 250, 50, 30);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.add(bt1);
		mainPanel.add(bt2);
		mainPanel.add(bt3);
		
	}
	
	
	
	
}

public class Test07 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window07 window = new Window07();
	}
}

