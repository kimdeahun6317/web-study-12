package web_study_12.service;

import java.sql.Connection;
import java.util.List;

import web_study_12.dao.impl.BoardDaoImpl;
import web_study_12.ds.JndiDS;
import web_study_12.dto.Board;

public class BoardService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public BoardService() {
		dao.setCon(con);
	}

	public List<Board> getBoard() {
		return dao.selectBoardByAll();
	}
	
	public int addBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public Board findBoard(String num) {
		return dao.selectBoardByNum(num);
	}

	public void readCount(String num) {
		dao.updateReadCount(num);
	}
	
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
	
	public int deleteBoard(String num) {
		return dao.deleteBoard(num);
	}
}
