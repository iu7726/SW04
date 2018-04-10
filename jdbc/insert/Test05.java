package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) throws Exception{
		String name = JOptionPane.showInputDialog("호텔명 입력");
		String region = JOptionPane.showInputDialog("지역 입력");
		int inwon = Integer.parseInt(JOptionPane.showInputDialog("인원수 입력"));
		int price = Integer.parseInt(JOptionPane.showInputDialog("가격 입력"));
		
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
		
		System.out.println("완료");
	}
}
