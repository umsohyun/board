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
import board.user.model.WebMemberVO;
import board.user.service.board.BoardService;
import board.user.service.board.BoardServiceInf;
import board.user.service.mainBoard.MainBoardService;
import board.user.service.mainBoard.MainBoardServiceInf;
import board.user.service.webmember.WebMemberService;
import board.user.service.webmember.WebMemberServiceInf;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Object> resultMap;
    public Login() {
        super();
        resultMap = new HashMap<String, Object>();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		String mainBoardNoString = request.getParameter("mainBoardNo");
		int mainBoardNo = mainBoardNoString == null ? 1 : Integer.parseInt(mainBoardNoString);
		
		WebMemberServiceInf wmService = new WebMemberService();
		WebMemberVO wmvo = wmService.userCheck(userId, password);
		
		MainBoardServiceInf mbService = new MainBoardService();
		List<MainBoardVO> list = mbService.getMainBoardList();
		String boardName = list.get(0).getMain_board_name();
		
		BoardServiceInf bService = new BoardService();
		resultMap = bService.getBoardPageList(page, pageSize, mainBoardNo);
		
		HttpSession session = request.getSession();
		
		if(wmvo != null){
			session.setAttribute("boardName", boardName);
			session.setAttribute("userId", userId);
			session.setAttribute("password", password);
			session.setAttribute("list", list);
			session.setAttribute("boardList", resultMap.get("boardList"));
			session.setAttribute("pageNav", resultMap.get("pageNav"));
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("login/login.jsp");
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		String mainBoardNoString = request.getParameter("mainBoardNo");
		int mainBoardNo = mainBoardNoString == null ? 1 : Integer.parseInt(mainBoardNoString);
		
		MainBoardServiceInf mbService = new MainBoardService();
		List<MainBoardVO> list = mbService.getMainBoardList();
		
		BoardServiceInf bService = new BoardService();
		resultMap = bService.getBoardPageList(page, pageSize, mainBoardNo);
		
			session.setAttribute("list", list);
			session.setAttribute("boardList", resultMap.get("boardList"));
			session.setAttribute("pageNav", resultMap.get("pageNav"));
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		
	}
}
