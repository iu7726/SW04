package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		String sql = "select * from menu where price < 3000";
		PreparedStatement ps = con.prepareStatement(sql);
		
//		ps.execute(); // �ܼ� ���ุ ó��
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("������ �߰�");
			//���� ���� ���� �ٿ��� name �̶�� �̸��� ����������
			System.out.println(rs.getString("name") + " / " +rs.getInt("price"));
			System.out.println(rs.getString(1)+" / "+rs.getInt(2));
		}
		
		con.close();
		System.out.println("�Ϸ�");
		
	}
}
