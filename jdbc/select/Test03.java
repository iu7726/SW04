package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Test03 {
	public static void main(String[] args) throws Exception{
		
		String search = JOptionPane.showInputDialog("���� �Է�");
		
		String sql = "select * from chart where rank = ?";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, search+"��");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("��� : "+rs.getString(2)+" / ������ : "+rs.getString(3)+ " / �ٹ��� : "+rs.getString(4));
		}else {
			System.out.println("�� ������ ã�� �� �����ϴ�.");
		}
		
		con.close();
		System.out.println("�Ϸ�");
		
		
	}
}
