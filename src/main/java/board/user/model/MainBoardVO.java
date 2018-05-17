package board.user.model;

import java.io.Serializable;

public class MainBoardVO implements Serializable{
	
	private static final long serialVersionUID = -9029357651187599277L;
	
	private String main_board_no;
	private String main_board_name;
	private String main_board_del;
	private String main_board_mem_id;
	
	public MainBoardVO(){
		
	}
	
	public MainBoardVO(String mainBoardName, String mainBoardReg, String mainBoardCreator) {
		this.main_board_name = mainBoardName;
		this.main_board_del = mainBoardReg;
		this.main_board_mem_id = mainBoardCreator;
	}
	
	public String getMain_board_no() {
		return main_board_no;
	}
	public void setMain_board_no(String main_board_no) {
		this.main_board_no = main_board_no;
	}
	public String getMain_board_name() {
		return main_board_name;
	}
	public void setMain_board_name(String main_board_name) {
		this.main_board_name = main_board_name;
	}
	public String getMain_board_del() {
		return main_board_del;
	}
	public void setMain_board_del(String main_board_del) {
		this.main_board_del = main_board_del;
	}
	public String getMain_board_mem_id() {
		return main_board_mem_id;
	}
	public void setMain_board_mem_id(String main_board_mem_id) {
		this.main_board_mem_id = main_board_mem_id;
	}
	
	
}
