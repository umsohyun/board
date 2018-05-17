package board.user.util;

/**
 * FileUtil.java
 *
 * @author "U.S.H"
 * @since 2018. 5. 10.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 10. "U.S.H" 최초 생성
 *
 * </pre>
 */
public class FileUtil {

	/**
	 * Method : getFileName
	 * 최초작성일 : 2018. 5. 9.
	 * 작성자 : "U.S.H"
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 : Content-disposition 헤더에서 파일명을 추출
	 */
	public static String getFileName(String contentDisposition) {
		//form-data
		// name="profile"
		// filename="Desert.jpg"
		String[] headers = contentDisposition.split(";");
		
		String fileName = null;
		for(String header : headers){
			if(header.startsWith(" filename=")){
				fileName = header.substring(" filename=".length() + 1, header.length() - 1);
				break;
			}
		}
		return fileName;
	}
	
}
