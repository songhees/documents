package org.zerock.mapper;

import org.zerock.domain.MemberVO;

import java.sql.*;

public class SampleDAO {

    public MemberVO getMe() throws ClassNotFoundException, SQLException {

        Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");

        Connection con = DriverManager.getConnection("jdbc:log4jdbc:oracle:thin:@183.98.24.70:51522:orcl11", "SONG", "zxcv1234");
        PreparedStatement pstmt = con.prepareStatement("select userid, userpw from tbl_member where userid = ? ");
        pstmt.setString(1, "admin99");
        ResultSet rs = pstmt.executeQuery();

        MemberVO vo = new MemberVO();
        vo.setUserid(rs.getString("userid"));
        vo.setUserpw(rs.getString("userpw"));
        return vo;
    }
}
