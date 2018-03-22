package gui.swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


class Window11 extends JFrame{
	
	// �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������.
	// Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton a = new JButton("�˸�â");
	private JButton b = new JButton("Ȯ��â");
	private JButton c = new JButton("�Է�â");
	private JButton d = new JButton("������â");
	private JButton e = new JButton("���ϼ���â");
	
	public Window11() {
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
		a.addActionListener(e -> {
			//�˸�â		JOptionPane.showMessageDialog(����������Ʈ, �޼���,Ÿ��Ʋ,�޼���Ÿ��,������);
			JOptionPane.showMessageDialog(mainPanel, "�˸�â�Դϴ�.","�˸�â",JOptionPane.INFORMATION_MESSAGE);
//			JOptionPane.showInternalMessageDialog(mainPanel, "����");//���ξ˸�â
		});
		b.addActionListener(e -> {
			//Ȯ��â JOptionPane.showConfirmDialog(����, �޼���, ����, ����, ����);
			int a = JOptionPane.showConfirmDialog(mainPanel, "����� ���?","���",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			switch(a) {
			case 0:
				JOptionPane.showMessageDialog(mainPanel, "������� ����Ͽ����ϴ�.");
				break;
			}
			System.out.println(a);
		});
		c.addActionListener(e -> {
			//JOptionPane.showInputDialog(����, �޼���, ����, ����)
			String str = JOptionPane.showInputDialog(mainPanel,"�Է�","�׽�Ʈ",JOptionPane.QUESTION_MESSAGE);
			if(str == null) return;
			System.out.println(str);
			alert(str);
		});
		d.addActionListener(e -> {
			//JColorChooser.showDialog(������Ʈ, Ÿ��Ʋ, �ʱ����);
			Color color = JColorChooser.showDialog(mainPanel, "���� ����", Color.black);
			if(color == null) return;
			mainPanel.setBackground(color);
		});
		e.addActionListener(e -> {
//			���� ����â  JFileChooser	�ν��Ͻ� ���� �� ���
			JFileChooser chooser = new JFileChooser(".");
			//������ ��� ���� ����
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int a = chooser.showOpenDialog(mainPanel);
//			int a = chooser.showSaveDialog(mainPanel);
			if(a != 0) return;
			System.out.println(a);
			File file = chooser.getSelectedFile();
			System.out.println(file);
		});
		

	}
	
	public void alert(String text) {
		JOptionPane.showMessageDialog(mainPanel,text,"�˸�",JOptionPane.PLAIN_MESSAGE);
	}

	private void display() {
		// TODO Auto-generated method stub
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.add(a);
		mainPanel.add(b);
		mainPanel.add(c);
		mainPanel.add(d);
		mainPanel.add(e);	
	}
}

public class Test11 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window11 window = new Window11();
	}
}

