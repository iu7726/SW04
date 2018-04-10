package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("접속완료");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw4", "sw4");
		System.out.println(con);
		System.out.println("Connection 완료");
		
		//명령 전송
		String sql = "insert into menu values('짜파게티',2500)";//;빼야함
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();//실행
		//자동 커밋 모드(안하게도 할수 있음)
		System.out.println("명령 전송 완료");
		
		con.close();
		System.out.println("접속 종료");
	}
}
