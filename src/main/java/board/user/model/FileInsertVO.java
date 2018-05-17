package board.user.model;

import java.io.Serializable;
import java.util.Date;

public class FileInsertVO implements Serializable{

	private static final long serialVersionUID = 7925560308166866015L;
	
	private String file_no;
	private String file_root;
	private int file_board_seq;
	
	public FileInsertVO() {
		super();
	}
	
	public FileInsertVO(String file_root, int file_board_seq) {
		super();
		this.file_root = file_root;
		this.file_board_seq = file_board_seq;
	}
	
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getFile_root() {
		return file_root;
	}
	public void setFile_root(String file_root) {
		this.file_root = file_root;
	}
	public int getFile_board_seq() {
		return file_board_seq;
	}
	public void setFile_board_seq(int file_board_seq) {
		this.file_board_seq = file_board_seq;
	}
	
	
}
