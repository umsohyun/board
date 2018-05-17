package board.user.service.fileInsert;

import board.user.dao.fileInsert.FileInsertDao;
import board.user.dao.fileInsert.FileInsertDaoInf;
import board.user.model.FileInsertVO;

/**
 * FileInsertService.java
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
public class FileInsertService implements FileInsertServiceInf{
	private FileInsertDaoInf fsDao = new  FileInsertDao();
	
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
		return fsDao.insertFile(fileVo);
	}

}







