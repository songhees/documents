package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConnectionUtil;

public class ContactDelete {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		String sql = "delete from tb_sample_contacts "
				+ "where name = ? ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		System.out.print("이름을 입력하세요: ");
		String name = scan.next();
		
		pstmt.setString(1, name);
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 삭제되었습니다.");
		
		pstmt.close();
		connection.close();
		
		scan.close();
	}
}
