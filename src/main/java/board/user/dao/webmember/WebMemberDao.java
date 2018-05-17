package board.user.dao.webmember;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.user.model.WebMemberVO;

public class WebMemberDao implements WebMemberDaoInf{
	private SqlSessionFactory sqlSessionFactory;
	
	public WebMemberDao(){
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
	 * Method : userCheck
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param userId
	 * @param password
	 * @return
	 * Method 설명 : 회원 체크
	 */
	@Override
	public WebMemberVO userCheck(String userId, String password) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("password", password);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WebMemberVO wmvo = sqlSession.selectOne("webmember.userIdCheck", paramMap);
		sqlSession.close();
		
		return wmvo;
	}

}
