package board.user.service.mainBoard;

import java.util.List;

import board.user.dao.mainBoard.MainBoardDao;
import board.user.dao.mainBoard.MainBoardDaoInf;
import board.user.model.MainBoardVO;

/**
 * MainBoardService.java
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
public class MainBoardService implements MainBoardServiceInf{
	private MainBoardDaoInf mbDao = new MainBoardDao();
	
	/**
	 * Method : getMainBoardList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 List 출력
	 */
	@Override
	public List<MainBoardVO> getMainBoardList() {
		return mbDao.getMainBoardList();
	}

	/**
	 * Method : getMainInfo
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param mainBoardNo
	 * @return
	 * Method 설명 : 게시판 정보 조회
	 */
	@Override
	public MainBoardVO getMainInfo(int mainBoardNo) {
		return mbDao.getMainInfo(mainBoardNo);
	}

	/**
	 * Method : mainBoardInsert
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param mbVo
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	@Override
	public int mainBoardInsert(MainBoardVO mbVo) {
		return mbDao.mainBoardInsert(mbVo);
	}

	/**
	 * Method : mainBoardDelete
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param main_board_no
	 * @return
	 * Method 설명 : 게시판 활성화/비활성화
	 */
	@Override
	public int mainBoardActive(int main_board_no) {
		return mbDao.mainBoardActive(main_board_no);
	}

}
