package com.lms.model;

import java.io.Serializable;

public class BranchBookMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int map_id, numberofbooks;
	private String branch_id, book_id;

	public int getMap_id() {
		return map_id;
	}

	public void setMap_id(int map_id) {
		this.map_id = map_id;
	}

	public int getNumberofbooks() {
		return numberofbooks;
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

	public void setNumberofbooks(int numberofbooks) {
		this.numberofbooks = numberofbooks;
	}
	
	
}
