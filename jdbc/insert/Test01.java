package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("���ӿϷ�");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw4", "sw4");
		System.out.println(con);
		System.out.println("Connection �Ϸ�");
		
		//��� ����
		String sql = "insert into menu values('¥�İ�Ƽ',2500)";//;������
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();//����
		//�ڵ� Ŀ�� ���(���ϰԵ� �Ҽ� ����)
		System.out.println("��� ���� �Ϸ�");
		
		con.close();
		System.out.println("���� ����");
	}
}
