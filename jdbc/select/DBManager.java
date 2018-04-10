package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	public static boolean login(String id, String pw) throws Exception {

		String sql = "select * from member1 where id = ? and pw = ?";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, pw);
		
		ResultSet rs = ps.executeQuery();
		
		boolean ret = rs.next();
		
		con.close();
		
		return ret;
		
	}
	
	
}
