package board.user.dao.fileInsert;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.user.model.FileInsertVO;

/**
 * FileInsertDao.java
 *
 * @author "U.S.H"
 * @since 2018. 5. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 16. "U.S.H" 최초 생성
 *
 * </pre>
 */
public class FileInsertDao implements FileInsertDaoInf{
private SqlSessionFactory sqlSessionFactory;
	
	public FileInsertDao(){
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
	 * Method : insertFile
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param file_byte
	 * @return
	 * Method 설명 : 파일을 저장하기 위한 메서드
	 */
	@Override
	public int insertFile(FileInsertVO fileVo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertFileCnt = sqlSession.insert("file.insertFile", fileVo);
		sqlSession.commit();
		sqlSession.close();
		return insertFileCnt;
	}

}
