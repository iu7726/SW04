package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) throws Exception{
		String name = JOptionPane.showInputDialog("ȣ�ڸ� �Է�");
		String region = JOptionPane.showInputDialog("���� �Է�");
		int inwon = Integer.parseInt(JOptionPane.showInputDialog("�ο��� �Է�"));
		int price = Integer.parseInt(JOptionPane.showInputDialog("���� �Է�"));
		
		String sql = "insert into hotel values(hotel_seq.nextval,?,?,?,?)";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, region);
		ps.setInt(3, inwon);
		ps.setInt(4, price);
		
		ps.execute();
		
		con.close();
		
		System.out.println("�Ϸ�");
	}
}
