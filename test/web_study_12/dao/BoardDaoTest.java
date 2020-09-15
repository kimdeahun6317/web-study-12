package web_study_12.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import web_study_11.ds.JdbcUtil;
import web_study_12.dao.impl.BoardDaoImpl;
import web_study_12.dto.Board;

public class BoardDaoTest {
	private Connection con;
	private BoardDaoImpl dao;

	@Before
	public void setUp() throws Exception {
		con = JdbcUtil.getConnection();
		dao = BoardDaoImpl.getInstance();
		dao.setCon(con);
		
	}

	@Test
	public void testSelectBoardByAll() {
		System.out.println("testSelectBoardByAll()");
		List<Board> list = new ArrayList<Board>(); 
		list = dao.selectBoardByAll();
		Assert.assertNotNull(list);
		System.out.println(list);
		
	}

	@Test
	public void testInsertBoard() {
		System.out.println("testInsertBoard()");
		Date date = new Date();
		Board newBoard = new Board(0, "쏘대장", "ss@naver.com", "12345", "두번째방문", "오랜만", 2,date );
		int res = dao.insertBoard(newBoard);
		Assert.assertEquals(1, res);
		System.out.println(res);
	}

	@Test
	public void testUpdateReadCount() {
		System.out.println("testUpdateReadCount()");
		dao.updateReadCount("5");
		Board board = dao.selectBoardByNum("5");
		System.out.println(board);
	}

	@Test
	public void testSelectBoardByNum() {
		System.out.println("testSelectBoardByNum()");
		Board board = dao.selectBoardByNum("6");
		Assert.assertNotNull(board);
		System.out.println(board);
	}

	@Test
	public void testUpdateBoard() {
		System.out.println("testUpdateBoard()");
		Board before = dao.selectBoardByNum("6");
		before.setName("유소나");
		int res = dao.updateBoard(before);
		Assert.assertEquals(1, res);
		System.out.println(res);

	}

	@Test
	public void testCheckPassword() {
		System.out.println("testDeleteBoard()");
		Board board = dao.checkPassword("1238", "5");
		Assert.assertNotNull(board);
		System.out.println(board);
	}

	@Test
	public void testDeleteBoard() {
		System.out.println("testDeleteBoard()");
		int res = dao.deleteBoard("6");
		System.out.println(res);
	}

}
