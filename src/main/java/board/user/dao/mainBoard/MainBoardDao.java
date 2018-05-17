package board.user.dao.mainBoard;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.user.model.MainBoardVO;

/**
 * MainBoardDao.java
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
public class MainBoardDao implements MainBoardDaoInf{
	private SqlSessionFactory sqlSessionFactory;
	
	public MainBoardDao(){
		String resource = "db/mybatis/mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<MainBoardVO> getMainBoardList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MainBoardVO> list = sqlSession.selectList("mainBoard.getMainBoardList");
		sqlSession.close();
		return list;
	}


	@Override
	public MainBoardVO getMainInfo(int mainBoardNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MainBoardVO vo = sqlSession.selectOne("mainBoard.getMainInfo", mainBoardNo);
		sqlSession.close();
		return vo;
	}


	@Override
	public int mainBoardInsert(MainBoardVO mbVo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = sqlSession.insert("mainBoard.mainBoardInsert", mbVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}


	@Override
	public int mainBoardActive(int main_board_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int activetCnt = sqlSession.update("mainBoard.mainBoardActive", main_board_no);
		sqlSession.commit();
		sqlSession.close();
		return activetCnt;
	}

}
