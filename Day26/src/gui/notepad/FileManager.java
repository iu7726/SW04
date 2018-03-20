package gui.notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class FileManager {
	private File file;
	public FileManager() {}
	private List<String> openText = new ArrayList<>();
	
	//���� ����
	public List<String> open(String dic, String name) {
		file = new File(dic,name);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			while(true) {
				String text = in.readLine();
				if(text == null) break;
				openText.add(text);
			}
			return openText;
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("�Է� ����");
			return null;
		} 
	}
	
	//���� ����
	public void save(String dic, String name, String text) {
		file = new File(dic,name);
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			System.out.println(text);
			out.println(text);
			out.flush();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("��� ����");
		}
		
	}
}
