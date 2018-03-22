package gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


class Window04 extends JFrame{
	
	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JTextArea jta = new JTextArea();
	
	private JScrollPane jsp = new JScrollPane(jta);
	
	public Window04() {
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
		
		//�츮�� �˴� �̺�Ʈ �ܿ� Swing������ "���� ����Ű"�� ������ �� �ִ�.
		//����Ű ��ü�� ������ �Ѵ�. - keyStroke
//		KeyStroke enter = KeyStroke.getKeyStroke(�Է�Ű,����Ű);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
		KeyStroke ctrlEnter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,KeyEvent.CTRL_DOWN_MASK);
		
		Action enterAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("����!");
			}
		};
		
		Action ctrlEnterAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("�����ٷ� �̵�!");
			}
		};
		
		//jta�� �����ϴ� InputMap�� ActionMap�� ����Ű + ��Ī / ��Ī + �׼��� ���
		jta.getInputMap().put(enter, "����");
		jta.getActionMap().put("����", enterAction);
		
		jta.getInputMap().put(ctrlEnter, "����");
		jta.getActionMap().put("�ٿ�", ctrlEnterAction);
		
			
			

	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.setLayout(new BorderLayout());
		//mainPanel.add(jta);//��ũ�� �Ұ�
		mainPanel.add(jsp);//��ũ�� ����
		//��ũ�ѹ� ����
//		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
	}
	
	
	
	
}

public class Test04 {
	public static void main(String[] args) {
		Window04 window = new Window04();
	}
}

