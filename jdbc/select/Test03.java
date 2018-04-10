package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Test03 {
	public static void main(String[] args) throws Exception{
		
		String search = JOptionPane.showInputDialog("순위 입력");
		
		String sql = "select * from chart where rank = ?";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sw4","sw4");
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, search+"위");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("곡명 : "+rs.getString(2)+" / 가수명 : "+rs.getString(3)+ " / 앨범명 : "+rs.getString(4));
		}else {
			System.out.println("곡 정보를 찾을 수 없습니다.");
		}
		
		con.close();
		System.out.println("완료");
		
		
	}
}
