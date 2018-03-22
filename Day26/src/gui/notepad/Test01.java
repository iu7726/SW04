package gui.notepad;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

class Window01 extends Frame {
	private FileManager fmg = new FileManager();
	private FileDialog fileSave = new FileDialog(this, "���� �����ϱ�", FileDialog.SAVE);
	private FileDialog fileOpen = new FileDialog(this, "���� �ҷ�����", FileDialog.LOAD);

	private MenuBar mb = new MenuBar();

	private Menu file = new Menu("����");
	private Menu view = new Menu("����");

	private MenuItem nFile = new MenuItem("�� ����");
	private MenuItem open = new MenuItem("����");
	private MenuItem save = new MenuItem("����");
	private MenuItem exit = new MenuItem("����");
	private MenuItem sizeup = new MenuItem("ũ��");
	private MenuItem sizedown = new MenuItem("�۰�");

	private TextArea ta = new TextArea();

	private int base = 20;

	public Window01() {
		this.display();
		this.event();
		this.menu();

		this.setSize(500, 400);
		this.setTitle("���� ���� - �޸���");
		this.setLocation(100, 200);
		this.setResizable(true);
		this.setVisible(true);
	}

	private void menu() {
		this.setMenuBar(mb);
		mb.add(file);
		mb.add(view);
		file.add(nFile);
		file.addSeparator();
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		view.add(sizeup);
		view.add(sizedown);
	}

	private void event() {
		// Frame �ݱ�
		WindowListener windolistener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		};

		// X��ư���� �ݱ�
		ActionListener exitActListener = (e) -> {
			dispose();
		};

		// ������
		ActionListener newActListener = (e) -> {
			ta.setText(null);//null���ٴ� ""�� ����ؾ���
		};
		// �۾� ũ�� ����
		ActionListener fontUp = (e) -> {
			if (base < 100) {
				base += 5;
				ta.setFont(new Font("", Font.PLAIN, base));
			}
		};
		// �۾� ũ�� ����
		ActionListener fontDown = (e) -> {
			if (base > 10) {
				base -= 5;
				ta.setFont(new Font("", Font.PLAIN, base));
			}
		};
		// ���� ����
		ActionListener save = (e) -> {
			fileSave.setVisible(true);
			fmg.save(fileSave.getDirectory(), fileSave.getFile(), ta.getText());
			setTitle(fileSave.getFile()+" - �޸���");
		};
		// ���� ����
		ActionListener open = (e) -> {
			fileOpen.setVisible(true);
			List<String> text = new ArrayList<>();
			text = fmg.open(fileOpen.getDirectory(), fileOpen.getFile());
			if (text != null) {
				ta.setText(null);
				for (String i : text) {
					ta.append(i);
					ta.append("\n");
				}
				text.removeAll(text);
				setTitle(fileOpen.getFile()+" - �޸���");
			}
		};

		this.save.addActionListener(save);
		this.open.addActionListener(open);
		sizeup.addActionListener(fontUp);
		sizedown.addActionListener(fontDown);
		nFile.addActionListener(newActListener);
		exit.addActionListener(exitActListener);
		this.addWindowListener(windolistener);
	}

	private void display() {
		this.add(ta);
		ta.setFont(new Font("", Font.PLAIN, base));
	}
}

public class Test01 {
	public static void main(String[] args) {
		Window01 window = new Window01();
	}
}
