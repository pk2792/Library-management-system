package com.lms.model;

import java.sql.Timestamp;

public class SearchBO {

	private int available_copies,no_copies,borrowcount,reservecount,borrow_id;
	public int getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}

	public int getNo_copies() {
		return no_copies;
	}

	public void setNo_copies(int no_copies) {
		this.no_copies = no_copies;
	}

	public int getBorrowcount() {
		return borrowcount;
	}

	public void setBorrowcount(int borrowcount) {
		this.borrowcount = borrowcount;
	}

	public int getReservecount() {
		return reservecount;
	}

	public void setReservecount(int reservecount) {
		this.reservecount = reservecount;
	}

	public int getAvailable_copies() {
		return available_copies;
	}

	public void setAvailable_copies(int available_copies) {
		this.available_copies = available_copies;
	}
	private String book_id,branch_id,book_title,isbn, authorfname, authorlbname, publishername,branch_name,branch_location,publisher_id;
	public String getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(String publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_location() {
		return branch_location;
	}

	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}

	
	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthorfname() {
		return authorfname;
	}
	public void setAuthorfname(String authorfname) {
		this.authorfname = authorfname;
	}
	public String getAuthorlbname() {
		return authorlbname;
	}
	public void setAuthorlbname(String authorlbname) {
		this.authorlbname = authorlbname;
	}
	public String getPublishername() {
		return publishername;
	}
	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}
	Timestamp borrow_date, return_date;
	public Timestamp getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Timestamp return_date) {
		this.return_date = return_date;
	}

	public Timestamp getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(Timestamp borrow_date) {
		this.borrow_date = borrow_date;
	}
	
	double days;
	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}
	
	
	
}
