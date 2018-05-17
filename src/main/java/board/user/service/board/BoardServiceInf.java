package board.user.service.board;

import java.util.List;
import java.util.Map;

import board.user.model.BoardVO;
/**
 * BoardServiceInf.java
 *
 * @author "U.S.H"
 * @since 2018. 5. 15.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 15. "U.S.H" 최초 생성
 *
 * </pre>
 */
public interface BoardServiceInf {
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @return
	 * Method 설명 : 게시판 페이지 리스트 조회
	 */
	public Map<String, Object> getBoardPageList(int page, int pageSize, int mainBoardNo);
	
	/**
	 * Method : boardInsert
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 등록
	 */
	public int boardInsert(BoardVO boardVo);
	
	/**
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 수정
	 */
	public int boardUpdate(BoardVO boardVo);
	
	/**
	 * Method : boardDelete
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 삭제
	 */
	public int boardDelete(BoardVO boardVo);
	
	/**
	 * Method : getBoardOneData
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param board_seq_no
	 * @return
	 * Method 설명 : 하나의 게시물 정보를 가져오는 메서드
	 */
	public BoardVO getBoardOneData(int board_seq_no);
	
}
