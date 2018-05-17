package board.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.user.model.BoardVO;
import board.user.model.MainBoardVO;
import board.user.service.board.BoardService;
import board.user.service.board.BoardServiceInf;
import board.user.service.mainBoard.MainBoardService;
import board.user.service.mainBoard.MainBoardServiceInf;

@WebServlet("/BoardFormServlet")
public class BoardFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFormServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String inputSeqNoString = request.getParameter("inputSeqNo");
		int inputSeqNo = Integer.parseInt(inputSeqNoString);
		
		String inputTitle = request.getParameter("inputTitle");
		String inputContent = request.getParameter("inputContent");
		String inputReg_id = request.getParameter("inputReg_id");
		
		System.out.println(inputTitle);
		System.out.println(inputContent);
		System.out.println(inputReg_id);
		
		BoardServiceInf bService = new BoardService();
		BoardVO bvo = bService.getBoardOneData(inputSeqNo);
		
		MainBoardServiceInf mbService = new MainBoardService();
		List<MainBoardVO> list = mbService.getMainBoardList();
		
		if(bvo != null){
			session.setAttribute("list", list);
			session.setAttribute("bvo", bvo);
			RequestDispatcher rd = request.getRequestDispatcher("CRUD/boardForm.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("main.jsp");
		}
		
	}

}
