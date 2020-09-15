package web_study_12.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.generics.visitor.Reifier;
import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardCheckPassModel implements Command {
	private BoardService service = new BoardService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			String num = request.getParameter("num");
			request.setAttribute("num", num);
			return "board/boardCheckPass.jsp";
		}else {
			System.out.println("POST");
			String url = null;
			
			String num = request.getParameter("num");
			System.out.println("num :"+num);
			String pass = request.getParameter("pass");
			System.out.println("pass :"+pass);
	
			Board board = service.findBoard(num);
			System.out.println(board);
			
			if(board.getPass().equals(pass)) {
				url = "board/boardCheckSuccess.jsp";
			}else {
				url = "board/boardCheckPass.jsp";
				request.setAttribute("num", num);
				request.setAttribute("message", "비밀번호가  틀렸습니다");
			}
			return url;
		}
		
	}

}
