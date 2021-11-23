package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionUtil;

public class ContactSelect1 {
	public static void main(String[] args) throws SQLException {
		String sql = "select no, name, phone_number, email, company "
				+ "from tb_sample_contacts ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("순번\t이름\t전화번호\t	이메일\t	소속회사");
		
		while (rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phoneNumber = rs.getString("phone_number");
			String email = rs.getString("email");
			String company = rs.getString("company");
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", no, name, phoneNumber, email, company);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
	}
}
