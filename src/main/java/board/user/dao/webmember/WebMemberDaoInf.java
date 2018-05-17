package board.user.dao.webmember;

import board.user.model.WebMemberVO;
/**
 * WebMemberInf.java
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
public interface WebMemberDaoInf {
	
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
	public WebMemberVO userCheck(String userId, String password);
}
