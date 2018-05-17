package board.user.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.user.model.MainBoardVO;
import board.user.service.board.BoardService;
import board.user.service.board.BoardServiceInf;
import board.user.service.mainBoard.MainBoardService;
import board.user.service.mainBoard.MainBoardServiceInf;

@WebServlet("/MainBoardServlet")
public class MainBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> resultMap;
	
    public MainBoardServlet() {
        super();
        resultMap = new HashMap<String, Object>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		String mainBoardNoString = request.getParameter("input");
		int mainBoardNo = mainBoardNoString == null ? 1 : Integer.parseInt(mainBoardNoString);
		
		MainBoardServiceInf mbService = new MainBoardService();
		List<MainBoardVO> list = mbService.getMainBoardList();
		
		MainBoardVO mainBoardName = mbService.getMainInfo(mainBoardNo);
		String boardName = mainBoardName.getMain_board_name();
		
		BoardServiceInf bService = new BoardService();
		resultMap = bService.getBoardPageList(page, pageSize, mainBoardNo);
		
			session.setAttribute("boardName", boardName);
			session.setAttribute("list", list);
			session.setAttribute("boardList", resultMap.get("boardList"));
			session.setAttribute("pageNav", resultMap.get("pageNav"));
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
