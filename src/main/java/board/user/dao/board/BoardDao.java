package board.user.dao.board;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.user.model.BoardVO;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDao(){
		String resource = "db/mybatis/mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @return
	 * Method 설명 : 게시물 리스트 조회
	 */
	@Override
	public List<BoardVO> getBoardPageList(int page, int pageSize, int mainBoardNo) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("mainBoardNo", mainBoardNo);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardPageList", paramMap);
		sqlSession.close();
		
		return boardList;
	}

	/**
	 * Method : getBoardCount
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시물 건수 조회
	 */
	public int getBoardCount(int mainBoardNo) {
		return sqlSessionFactory.openSession().selectOne("board.getBoardCount", mainBoardNo);
	}
	
	@Override
	public int boardInsert(BoardVO boardVo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardInsertCnt = sqlSession.insert("board.boardInsert", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return boardInsertCnt;
	}

	@Override
	public int boardUpdate(BoardVO boardVo) {
		return 0;
	}

	@Override
	public int boardDelete(BoardVO boardVo) {
		return 0;
	}

	@Override
	public BoardVO getBoardOneData(int board_seq_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO vo = sqlSession.selectOne("board.getBoardOneDate", board_seq_no);
		sqlSession.close();
		return vo;
	}

}
