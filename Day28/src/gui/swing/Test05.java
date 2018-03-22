package gui.swing;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

class Window05 extends JFrame{
	
	private JPanel mainPanel = new JPanel();
	
	//�޴� 
	//JMenuBar - JMenu - JMenuItem / JCheckboxMenuItem / JRadioButtonMenuItem(�������߿� 1���� ���� �ִ� ��ư)
	private JMenuBar bar = new JMenuBar();
	
	private JMenu file = new JMenu("����");
	private JMenuItem exit = new JMenuItem("�����ϱ�");
	
	private JRadioButtonMenuItem r1 = new JRadioButtonMenuItem("�Ϲݿ�");
	private JRadioButtonMenuItem r2 = new JRadioButtonMenuItem("���п�");
	
	
	
	
	public Window05() {
		this.display();
		this.event();
		this.menu();
		
		this.setSize(500, 400);
		this.setTitle("GUI �׽�Ʈ");
		this.setLocationByPlatform(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void menu() {
		// TODO Auto-generated method stub
		this.setJMenuBar(bar);
		bar.add(file);
		file.add(exit);
		file.add(r1);
		file.add(r2);
		
		//��ư �׷��� ����� r1,r2�� �������� �˷��ش�.
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(r1);
		bg.add(r2);
		r1.setSelected(true);
	}

	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
		
		//�޴��� ����Ű ������ ���� KeyStroke�� �̿�
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		
		//����Ű ���� - ������ �� ����Ű�� ������ ActionEvent�� �߻�
		exit.setAccelerator(esc);
		
		exit.addActionListener(e -> {
			dispose();
		});
		
		
		
	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		
		
	}
	
	
	
	
}

public class Test05 {
	public static void main(String[] args) {
		Window05 window = new Window05();
	}
}

