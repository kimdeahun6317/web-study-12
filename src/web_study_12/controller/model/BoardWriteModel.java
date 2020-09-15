package web_study_12.controller.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardWriteModel implements Command {
	private BoardService service = new BoardService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("BoardWriteModel GET");
			return "board/boardWrite.jsp";
		} else {
			System.out.println("BoardWriteModel POST");
			Gson gson = new Gson();
//			try(BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))){
//				System.out.println("JSON:"+br.readLine());
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
			Board board = gson.fromJson(new InputStreamReader(request.getInputStream(), "UTF-8"),Board.class);
			System.out.println(board);
			
			
//			String name = request.getParameter("name");
//			String email = request.getParameter("email");
//			String pass = request.getParameter("pass");
//			String title = request.getParameter("title");
//			String content = request.getParameter("content");
//			Date date = new Date();
//
//			Board board = new Board(0, name, email, pass, title, content, 0, date);
			
			
			
			//인트로 할경우 responseText를 할필요가 없음
			String res = String.valueOf(service.addBoard(board));
			//response.sendRedirect("boardList.do");
			
			response.getWriter().print(res);
			return null;

		}

	}

}
