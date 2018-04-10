package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03 {
	public static void main(String[] args) throws Exception{
		//test02는 문제가 되는 값이 있으므로 데이터를 암호화하여 처리하자
		
		//DB 접속전 데이터 준비 완료 시켜야됨
		String name = "레몬'에이드";
		int price = 3000;
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		String sql = "insert into menu values(?,?)";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		//ps의 기능 중에 데이터를 유형별로 암호화하여 설정하는 기능이 존재
		ps.setString(1, name); // 첫 번째 ?에 name을 암호화 하여 처리
		ps.setInt(2, price);
		
		ps.execute();
		
		con.close();
		System.out.println("완료");
	}
}
