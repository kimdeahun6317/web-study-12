package web_study_12.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardUpdateModel implements Command {
	private BoardService service = new BoardService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			String url = "board/boardUpdate.jsp";

			String num = request.getParameter("num");

			service.readCount(num);
			Board board = service.findBoard(num);

			request.setAttribute("board", board);

			return url;
		}else {
			System.out.println("POST");
			Board board = new Board();
			
			board.setNum(Integer.parseInt(request.getParameter("num")));
			board.setName(request.getParameter("name"));
			board.setPass(request.getParameter("pass"));
			board.setEmail(request.getParameter("email"));
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			
			service.updateBoard(board);
			
			return "boardList.do";
		}
	}

}
