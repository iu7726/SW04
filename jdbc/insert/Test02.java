package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02 {
	public static void main(String[] args) throws Exception{
		String name = "레몬에이드";
		int price = 3000;
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
//		String sql = "insert into menu values('"+name+"',"+price+")";
		String sql = String.format("insert into menu values('%s',%d)", name,price);
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		con.close();
		System.out.println("완료");
	}
}
