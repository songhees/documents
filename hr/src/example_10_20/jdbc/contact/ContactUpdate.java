package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConnectionUtil;

public class ContactUpdate {
	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		
		String sql = "update tb_sample_contacts "
				+ "set "
				+ "		phone_number = ?, "
				+ "		email = ?,"
				+ "		company = ? "
				+ "where no = ? ";	
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		System.out.println("순번 입력: ");
		int no = scan.nextInt();
		System.out.println("전화번호 입력: ");
		String phoneNumber = scan.next();
		System.out.println("이메일 입력: ");
		String email = scan.next();
		System.out.println("소속회사 입력: ");
		String company = scan.next();
		
		pstmt.setString(1, phoneNumber);
		pstmt.setString(2, email);
		pstmt.setString(3, company);
		pstmt.setInt(4, no);
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 갱신되었습니다.");
		
		pstmt.close();
		connection.close();
		scan.close();
	}
}
