package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//����Ŭ sw4������ ������ �ϰ� �ʹ�.
		//- �� ���α׷��� Ŭ���̾�Ʈ ����
		//- ����Ŭ �����ͺ��̽��� ���� ����
		
		// - ip : localhost(127.0.0.1) port : 1521
		
		//java.sql ��Ű���� ���뿡 ���� ���� �� �۾��� ����
		
		//����Ŭ ���� �ν�(����̹� �˻�)
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("���ӿϷ�");
		
		//����
		//								����̹� ����		ip		 port ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw4", "sw4");
		System.out.println(con);
		System.out.println("Connection �Ϸ�");
		
		//����
		con.close();
		System.out.println("���� ����");
		
	}
}
