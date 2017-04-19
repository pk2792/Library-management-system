package com.lms.model;

public class BranchbookBO {
	
	private int map_id,no_copies,available_copies;
	
	private String branch_id,book_id;
	public int getMap_id() {
		return map_id;
	}

	public void setMap_id(int map_id) {
		this.map_id = map_id;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public int getNo_copies() {
		return no_copies;
	}

	public void setNo_copies(int no_copies) {
		this.no_copies = no_copies;
	}

	public int getAvailable_copies() {
		return available_copies;
	}

	public void setAvailable_copies(int available_copies) {
		this.available_copies = available_copies;
	}

}
