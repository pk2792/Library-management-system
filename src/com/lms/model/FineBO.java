package com.lms.model;

import java.sql.Timestamp;

public class FineBO {
	private String book_title, authorfname, authorlname, pubname,branch_name;
	double fine;
	Timestamp borrowdate;
	
	
	public Timestamp getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Timestamp borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getAuthorfname() {
		return authorfname;
	}
	public void setAuthorfname(String authorfname) {
		this.authorfname = authorfname;
	}
	public String getAuthorlname() {
		return authorlname;
	}
	public void setAuthorlname(String authorlname) {
		this.authorlname = authorlname;
	}
	public String getPubname() {
		return pubname;
	}
	public void setPubname(String pubname) {
		this.pubname = pubname;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	
}
