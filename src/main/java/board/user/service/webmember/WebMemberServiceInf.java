package board.user.service.webmember;

import board.user.model.WebMemberVO;

public interface WebMemberServiceInf {

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
