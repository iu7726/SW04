package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) throws Exception {
		String name = JOptionPane.showInputDialog("이름 입력");
		int js = Integer.parseInt(JOptionPane.showInputDialog("자바 점수 입력"));
		int ps = Integer.parseInt(JOptionPane.showInputDialog("파이썬 점수 입력"));
	
		String sql = "insert into student values(?,?,?)";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		PreparedStatement pres = con.prepareStatement(sql);
		
		pres.setString(1, name);
		pres.setInt(2, js);
		pres.setInt(3, ps);
		
		pres.execute();
		
		con.close();
		
		System.out.println("완료");
	
		
	}
}
