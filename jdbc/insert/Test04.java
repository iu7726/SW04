package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) throws Exception {
		String name = JOptionPane.showInputDialog("�̸� �Է�");
		int js = Integer.parseInt(JOptionPane.showInputDialog("�ڹ� ���� �Է�"));
		int ps = Integer.parseInt(JOptionPane.showInputDialog("���̽� ���� �Է�"));
	
		String sql = "insert into student values(?,?,?)";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		PreparedStatement pres = con.prepareStatement(sql);
		
		pres.setString(1, name);
		pres.setInt(2, js);
		pres.setInt(3, ps);
		
		pres.execute();
		
		con.close();
		
		System.out.println("�Ϸ�");
	
		
	}
}
