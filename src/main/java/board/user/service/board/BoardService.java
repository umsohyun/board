package board.user.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.user.dao.board.BoardDao;
import board.user.dao.board.BoardDaoInf;
import board.user.model.BoardVO;

public class BoardService implements BoardServiceInf {
	private BoardDaoInf boardDao;
	
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @return
	 * Method 설명 : 해당 페이지에 있는 게시물 리스트 출력
	 */
	@Override
	public Map<String, Object> getBoardPageList(int page, int pageSize, int mainBoardNo) {
		boardDao = new BoardDao();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(page);
		System.out.println(pageSize);
		System.out.println(mainBoardNo);
		
		List<BoardVO> boardList = boardDao.getBoardPageList(page, pageSize, mainBoardNo);
		String pageNav = makePageNav(page, boardDao.getBoardCount(mainBoardNo));
		
		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}
	
	/**
	 * Method : makePageNav
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param page
	 * @param boardCount
	 * @return
	 * Method 설명 :
	 */
	private String makePageNav(int page, int boardCount) {
		//boardCount = 1
		//pageSize = 10
		//totalPage = ?
		
		int pageCount = (int)(Math.ceil( (double)boardCount / 10 ) );
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class='pagination'>");
		pageNav.append("		<li>");
		pageNav.append(" 			<a href='Login?page=1&pageSize=10' aria-label='Previous'>");
		pageNav.append("				<span aria-hidden='true'>&laquo;</span>");
		pageNav.append("			</a>");
		pageNav.append(" 			<a href='Login?page="+ (page != 1 ? (page -1) : 1) +"&pageSize=10' aria-label='Previous'>");
		pageNav.append("				<span aria-hidden='true'>&lt;</span>");
		pageNav.append("			</a>");
		pageNav.append("		</li>");
		
		for(int i = 1; i <= pageCount; i++){
			if(i == page){
				pageNav.append("			<li class='active'><a href='Login?page="+i+"&pageSize=10'>"+ i +"</a></li>");
			}else{
				pageNav.append("			<li><a href='Login?page="+i+"&pageSize=10'>"+ i +"</a></li>");
			}
		}
		
		pageNav.append("		<li>");
		pageNav.append("			<a href='Login?page="+ (page+1) +"&pageSize=10' aria-label='Next'>");
		pageNav.append("				<span aria-hidden='true'>&gt;</span>");
		pageNav.append("			</a>");
		pageNav.append("			<a href='Login?page="+ pageCount +"&pageSize=10' aria-label='Next'>");
		pageNav.append("				<span aria-hidden='true'>&raquo;</span>");
		pageNav.append("			</a>");
		pageNav.append("		</li>");
		pageNav.append("	</ul>");
		pageNav.append("</nav>");
		
		return pageNav.toString();
	}

	@Override
	public int boardInsert(BoardVO boardVo) {
		boardDao = new BoardDao();
		return boardDao.boardInsert(boardVo);
	}

	@Override
	public int boardUpdate(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getBoardOneData(int board_seq_no) {
		boardDao = new BoardDao();
		return boardDao.getBoardOneData(board_seq_no);
	}


}
