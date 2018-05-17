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

import board.user.model.MainBoardVO;
import board.user.service.mainBoard.MainBoardService;
import board.user.service.mainBoard.MainBoardServiceInf;

@WebServlet("/MainBoardIManagementServlet")
public class MainBoardManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainBoardServiceInf mbService; 
	
    public MainBoardManagementServlet() {
        super();
        mbService  = new MainBoardService(); 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mainBoardNo = request.getParameter("mainBoardNo3");
		String mainBoardName = request.getParameter("mainBoardName");
		String mainBoardReg = request.getParameter("mainBoardReg");
		String mainBoardCreator = request.getParameter("mainBoardCreator");
		
		MainBoardVO mbVo = new MainBoardVO(mainBoardName, mainBoardReg, mainBoardCreator);
		mbService.mainBoardInsert(mbVo);
		
		List<MainBoardVO> list = mbService.getMainBoardList();
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("CRUD/mainboardManagement.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mainBoardNoString = request.getParameter("input2");
		int mainBoardNo = Integer.parseInt(mainBoardNoString);
		
		mbService.mainBoardActive(mainBoardNo);
		
		List<MainBoardVO> list = mbService.getMainBoardList();
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("CRUD/mainboardManagement.jsp");
		rd.forward(request, response);
		
	}

}
