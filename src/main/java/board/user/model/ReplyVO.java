package board.user.model;

import java.io.Serializable;
import java.util.Date;

public class ReplyVO implements Serializable{
	
	private static final long serialVersionUID = 6713299028744201059L;
	
	private String reply_no;
	private String reply_content;
	private Date reply_dt;
	private String reply_dek;
	private String reply_mem_id;
	private int reply_board_seq;
	
	public String getReply_no() {
		return reply_no;
	}
	public void setReply_no(String reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_dt() {
		return reply_dt;
	}
	public void setReply_dt(Date reply_dt) {
		this.reply_dt = reply_dt;
	}
	public String getReply_dek() {
		return reply_dek;
	}
	public void setReply_dek(String reply_dek) {
		this.reply_dek = reply_dek;
	}
	public String getReply_mem_id() {
		return reply_mem_id;
	}
	public void setReply_mem_id(String reply_mem_id) {
		this.reply_mem_id = reply_mem_id;
	}
	public int getReply_board_seq() {
		return reply_board_seq;
	}
	public void setReply_board_seq(int reply_board_seq) {
		this.reply_board_seq = reply_board_seq;
	}
	
	
}
