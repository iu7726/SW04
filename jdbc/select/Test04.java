package select;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) throws Exception{
		
		String id = JOptionPane.showInputDialog("���̵� �Է�");
		String pw = JOptionPane.showInputDialog("��й�ȣ �Է�");
		
		if(DBManager.login(id, pw)) {
			System.out.println("�α��� ����");
		}else {
			System.out.println("�α��� ����");
		}
		

		System.out.println("�Ϸ�");
		
	}
}
