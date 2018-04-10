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
		
//		ps.execute(); // 단순 실행만 처리
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("데이터 발견");
			//현재 접근 중인 줄에서 name 이라는 이름을 가져오세요
			System.out.println(rs.getString("name") + " / " +rs.getInt("price"));
			System.out.println(rs.getString(1)+" / "+rs.getInt(2));
		}
		
		con.close();
		System.out.println("완료");
		
	}
}
