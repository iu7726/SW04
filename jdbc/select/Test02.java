package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Test02 {
	public static void main(String[] args) throws Exception{
		
		String food = JOptionPane.showInputDialog("���ĸ� �Է�");
		
		String sql = "select * from menu where name like '%'||upper(?)||'%'";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, food);
		
		ResultSet rs = ps.executeQuery();
		
		System.out.println("�˻� ��� ");
		while(rs.next()) {
			System.out.println("�޴��� : "+rs.getString(1)+" / ���� : "+rs.getInt(2));
		}
		
		con.close();
	}
}
