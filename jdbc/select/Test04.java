package select;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) throws Exception{
		
		String id = JOptionPane.showInputDialog("아이디 입력");
		String pw = JOptionPane.showInputDialog("비밀번호 입력");
		
		if(DBManager.login(id, pw)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		

		System.out.println("완료");
		
	}
}
