package web_study_12.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web_study_12.dao.BoardDao;
import web_study_12.dto.Board;

public class BoardDaoImpl implements BoardDao {
	private static final BoardDaoImpl instance = new BoardDaoImpl();
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	private BoardDaoImpl() {
	}

	public static BoardDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Board> selectBoardByAll() {
		String sql = "SELECT NUM,PASS,NAME,EMAIL,TITLE,CONTENT,READCOUNT,WRITEDATE FROM board ORDER BY NUM";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			List<Board> list = new ArrayList<Board>();
			if (rs.next()) {
				do {
					list.add(getBoard(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		;
		return null;
	}

	@Override
	public int insertBoard(Board board) {
		String sql = "INSERT INTO BOARD(PASS,NAME,EMAIL,TITLE,CONTENT) " + 
				"	VALUES(?,?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public void updateReadCount(String num) {
		String sql = "UPDATE BOARD " + 
				"	SET READCOUNT = READCOUNT+1 " + 
				"	WHERE NUM =?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, num);
			pstmt.executeQuery();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}

	}

	@Override
	public Board selectBoardByNum(String num) {
		String sql = "SELECT NUM,PASS,NAME,EMAIL,TITLE,CONTENT,READCOUNT,WRITEDATE FROM board WHERE num = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, num);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBoard(rs);
				}
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "UPDATE board SET PASS =?,NAME =?,EMAIL =?,TITLE =?,CONTENT =?,READCOUNT =? WHERE num=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getReadcount());
			pstmt.setInt(7, board.getNum());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public Board checkPassword(String pass, String num) {
		String sql = "SELECT NUM,PASS,NAME,EMAIL,TITLE,CONTENT,READCOUNT,WRITEDATE FROM BOARD WHERE NUM = ? AND PASS = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getBoard(rs);
				}
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public int deleteBoard(String num) {
		String sql = "DELETE FROM BOARD WHERE NUM=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	private Board getBoard(ResultSet rs) throws SQLException {
		int num = rs.getInt("NUM");
		String name = rs.getString("NAME");
		String email = rs.getString("EMAIL");
		String pass = rs.getString("PASS");
		String title = rs.getString("TITLE");
		String content = rs.getString("CONTENT");
		int readcount = rs.getInt("READCOUNT");
		Date writedate = rs.getDate("WRITEDATE");
		return new Board(num, name, email, pass, title, content, readcount, writedate);
	}

}
