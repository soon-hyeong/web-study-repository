package org.kosa.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DbConfig;

//Dao : Data Access Object 데이터 제어 로직을 담당하는 객체
public class MemberDao {
	public MemberDao() throws ClassNotFoundException {
		Class.forName(DbConfig.DRIVER);
	}

	/*
	 * method() throws SQLException { Connection try finally close return }
	 */
	public MemberVo findMemberById(String memberId) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberVo vo = null;
		try {

			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "SELECT * FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return vo;
	}

	public void register(MemberVo memberVO) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DbConfig.DRIVER);
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);

			String sql = "INSERT INTO member VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getAddress());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

	}

	public ArrayList<MemberVo> findMemberByAddress(String address) throws ClassNotFoundException, SQLException {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DbConfig.DRIVER);
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "SELECT id, name, address FROM member WHERE address=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVo(rs.getString("id"), null, rs.getString("name"), rs.getString("address")));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		}
		return list;
	}

	public int getMemberCount() throws SQLException, ClassNotFoundException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			Class.forName(DbConfig.DRIVER);
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "SELECT COUNT(1) FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return count;
	}
}
