package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03 {
	public static void main(String[] args) throws Exception{
		//test02�� ������ �Ǵ� ���� �����Ƿ� �����͸� ��ȣȭ�Ͽ� ó������
		
		//DB ������ ������ �غ� �Ϸ� ���Ѿߵ�
		String name = "����'���̵�";
		int price = 3000;
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		String sql = "insert into menu values(?,?)";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		//ps�� ��� �߿� �����͸� �������� ��ȣȭ�Ͽ� �����ϴ� ����� ����
		ps.setString(1, name); // ù ��° ?�� name�� ��ȣȭ �Ͽ� ó��
		ps.setInt(2, price);
		
		ps.execute();
		
		con.close();
		System.out.println("�Ϸ�");
	}
}
