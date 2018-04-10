package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//오라클 sw4계정에 접속을 하고 싶다.
		//- 이 프로그램이 클라이언트 역할
		//- 오라클 데이터베이스가 서버 역할
		
		// - ip : localhost(127.0.0.1) port : 1521
		
		//java.sql 패키지의 내용에 의해 연결 및 작업을 진행
		
		//오라클 정보 인식(드라이버 검색)
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("접속완료");
		
		//접속
		//								드라이버 종류		ip		 port 버전
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw4", "sw4");
		System.out.println(con);
		System.out.println("Connection 완료");
		
		//종료
		con.close();
		System.out.println("접속 종료");
		
	}
}
