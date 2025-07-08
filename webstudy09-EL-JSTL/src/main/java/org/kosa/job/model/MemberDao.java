package org.kosa.job.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kosa.job.common.DbConfig;

//Dao : Data Access Object 데이터 제어 로직을 담당하는 객체
public class MemberDao {
	private static MemberDao instance;
	
	private MemberDao() throws ClassNotFoundException {
		Class.forName(DbConfig.DRIVER);
	}
	// 지연된 로딩 : Lazy Loading
	public static MemberDao getInstance() throws ClassNotFoundException {
		if(instance == null)
			instance = new MemberDao();
		return instance;
	}
	/*
		method() throws SQLException {
			Connection
			try
			finally close
			return
		}
	 */
	public MemberVO findMemberById(String memberId) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO vo = null;
		try {
			
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "SELECT * FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return vo;
	}

	public void register(MemberVO memberVO) throws ClassNotFoundException, SQLException {
		
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
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
	}

	public ArrayList<MemberVO> findMemberByAddress(String address) throws ClassNotFoundException, SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection 			con = null;
		PreparedStatement	pstmt = null;
		ResultSet			rs = null;
		try {
			Class.forName(DbConfig.DRIVER);
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "SELECT id, name, address FROM member WHERE address=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"), null, rs.getString("name"), rs.getString("address")));
			}
		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			
		}
		return list;
	}
}

















