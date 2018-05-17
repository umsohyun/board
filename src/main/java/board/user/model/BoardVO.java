package board.user.model;

import java.io.Serializable;
import java.util.Date;

public class BoardVO implements Serializable {

	private static final long serialVersionUID = 7478544293297493550L;
	
	private int board_seq;
	private int pboard_seq;
	private String title;
	private String content;
	private String reg_id;
	private Date reg_dt;
	private String del_yn;
	private String main_board_no;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(String title, String content, String reg_id, Date reg_dt, String main_board_no) {
		super();
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_dt = reg_dt;
		this.main_board_no = main_board_no;
	}
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getPboard_seq() {
		return pboard_seq;
	}
	public void setPboard_seq(int pboard_seq) {
		this.pboard_seq = pboard_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getMain_board_no() {
		return main_board_no;
	}
	public void setMain_board_no(String main_board_no) {
		this.main_board_no = main_board_no;
	}
	
	
	
}
