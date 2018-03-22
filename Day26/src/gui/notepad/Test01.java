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
	private FileDialog fileSave = new FileDialog(this, "파일 저장하기", FileDialog.SAVE);
	private FileDialog fileOpen = new FileDialog(this, "파일 불러오기", FileDialog.LOAD);

	private MenuBar mb = new MenuBar();

	private Menu file = new Menu("파일");
	private Menu view = new Menu("보기");

	private MenuItem nFile = new MenuItem("새 파일");
	private MenuItem open = new MenuItem("열기");
	private MenuItem save = new MenuItem("저장");
	private MenuItem exit = new MenuItem("종료");
	private MenuItem sizeup = new MenuItem("크게");
	private MenuItem sizedown = new MenuItem("작게");

	private TextArea ta = new TextArea();

	private int base = 20;

	public Window01() {
		this.display();
		this.event();
		this.menu();

		this.setSize(500, 400);
		this.setTitle("제목 없음 - 메모장");
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
		// Frame 닫기
		WindowListener windolistener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		};

		// X버튼으로 닫기
		ActionListener exitActListener = (e) -> {
			dispose();
		};

		// 새파일
		ActionListener newActListener = (e) -> {
			ta.setText(null);//null보다는 ""을 사용해야함
		};
		// 글씨 크기 증가
		ActionListener fontUp = (e) -> {
			if (base < 100) {
				base += 5;
				ta.setFont(new Font("", Font.PLAIN, base));
			}
		};
		// 글씨 크기 감소
		ActionListener fontDown = (e) -> {
			if (base > 10) {
				base -= 5;
				ta.setFont(new Font("", Font.PLAIN, base));
			}
		};
		// 파일 저장
		ActionListener save = (e) -> {
			fileSave.setVisible(true);
			fmg.save(fileSave.getDirectory(), fileSave.getFile(), ta.getText());
			setTitle(fileSave.getFile()+" - 메모장");
		};
		// 파일 열기
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
				setTitle(fileOpen.getFile()+" - 메모장");
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
