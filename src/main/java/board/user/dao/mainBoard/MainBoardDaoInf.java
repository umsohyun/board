package board.user.dao.mainBoard;

import java.util.List;

import board.user.model.MainBoardVO;

/**
 * MainBoardDaoInf.java
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
public interface MainBoardDaoInf {
	
	/**
	 * Method : getMainBoardList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 List 출력
	 */
	public List<MainBoardVO> getMainBoardList();
	
	/**
	 * Method : mbVo
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 정보 조회
	 */
	public MainBoardVO getMainInfo(int mainBoardNo);
	
	/**
	 * Method : mainBoardInsert
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param mbVo
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	public int mainBoardInsert(MainBoardVO mbVo);
	
	/**
	 * Method : mainBoardDelete
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param main_board_no
	 * @return
	 * Method 설명 : 게시판 활성화/비활성화
	 */
	public int mainBoardActive(int main_board_no);
}
