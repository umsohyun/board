package board.user.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import board.user.dao.fileInsert.FileInsertDao;
import board.user.dao.fileInsert.FileInsertDaoInf;
import board.user.model.BoardVO;
import board.user.model.FileInsertVO;
import board.user.model.MainBoardVO;
import board.user.service.board.BoardService;
import board.user.service.board.BoardServiceInf;
import board.user.service.fileInsert.FileInsertService;
import board.user.service.fileInsert.FileInsertServiceInf;
import board.user.service.mainBoard.MainBoardService;
import board.user.service.mainBoard.MainBoardServiceInf;
import board.user.util.FileUtil;

@WebServlet("/BoardManagementServlet")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class BoardManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf bService;
	private FileInsertServiceInf fService;
	private FileInsertVO fileVo;
	private FileInsertDaoInf fileDao;
	private Map<String, Object> resultMap;
       
    public BoardManagementServlet() {
        super();
        bService = new BoardService();
        fService = new FileInsertService();
        fileVo = new FileInsertVO();
        fileDao = new FileInsertDao();
        resultMap = new HashMap<String, Object>();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String boardTitle = request.getParameter("boardTitle");
		
		String mainboardnoString = request.getParameter("input3");
		int mainboardno = Integer.parseInt(mainboardnoString);
		
		String content = request.getParameter("smarteditor");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		String file_root ="";
		
		Collection<Part> parts = request.getParts();
		for(Part part : parts){
			if(part.getName().equals("uploadfile") && part.getSize() > 0){
				String contentString =  part.getHeader("Content-disposition");
				String fileName =FileUtil.getFileName(contentString);
				String uploadPath = getServletContext().getRealPath("/upload");
				
				String filePath = "/upload/" + fileName;
				
				if(fileName != null && fileName!=""){
					file_root = filePath;
				}
				part.write(filePath);
				part.delete();
				
				FileInsertVO fileVo = new FileInsertVO(file_root, mainboardno);
				int fileInsertCnt = fService.insertFile(fileVo);
			}
			
		}
		
		BoardVO vo = new BoardVO(boardTitle, content, userId, new Date(), mainboardnoString);
		int boardInsertCnt = bService.boardInsert(vo);
		
		resultMap = bService.getBoardPageList(page, pageSize, mainboardno);
		
		MainBoardServiceInf mbService = new MainBoardService();
		List<MainBoardVO> list = mbService.getMainBoardList();
		
		if(boardInsertCnt == 1){
			request.setAttribute("mainboardnoString", mainboardnoString);
			session.setAttribute("list", list);
			session.setAttribute("boardList", resultMap.get("boardList"));
			session.setAttribute("pageNav", resultMap.get("pageNav"));
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("CRUD/boardInsert.jsp");
		}
		
	}

}









