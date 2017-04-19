package com.lms.dao;

import java.util.List;

import com.lms.controller.Register;
import com.lms.model.AuthorBO;
import com.lms.model.AverageFineBO;
import com.lms.model.BookMstBO;
import com.lms.model.BoqDetails;
import com.lms.model.BoqHD;
import com.lms.model.BorrowMstBO;
import com.lms.model.BranchBO;
import com.lms.model.BranchBookView;
import com.lms.model.BranchbookBO;
import com.lms.model.FineBO;
import com.lms.model.LoginBO;
import com.lms.model.NewLoginBO;
import com.lms.model.RegisterBO;
import com.lms.model.ReserveMstBO;
import com.lms.model.SearchBO;
import com.lms.model.TopTenBook;
import com.lms.model.TopTenBorrowersBO;
import com.lms.model.publisherBO;

public interface Dao {
	public RegisterBO checklogin(LoginBO l) throws Exception;
	public boolean saveBranch(String branchname, String location) throws Exception;
	public List<BranchBO> getBranchList() throws Exception;
	public List<BookMstBO> getBookList() throws Exception;
	public boolean reg(RegisterBO r) throws Exception;
	
	public boolean auth(String authorfname,String authorlname) throws Exception;
	public boolean pub(String pname, String ploc) throws Exception;
	public List<AuthorBO> getAuthorList() throws Exception;
	public List<publisherBO> getPublisherList() throws Exception;
	public boolean addbook(BookMstBO ab);
	
	public List<BranchBookView> getBooksByBranchId(int branch_id) throws Exception;
	public boolean checkBranchName(String name) throws Exception;
	public List<BorrowMstBO> getUserBorrowedBooks(String userid) throws Exception;
	boolean addbbook(BranchbookBO bb);
	List<SearchBO> searchBooks(String branch_id, String book_id, String author_name, String publisher_name)
			throws Exception;
	
	public boolean saveReaderBorrowedBooks(String[] id, String userid, String status) throws Exception;
	public List<ReserveMstBO> getuserReservedBooks(String userid)throws Exception;
	public boolean saveReaderReservedBooks(String[] id, String userid, String status) throws Exception;
	public List<FineBO> getListWithFine(String readerid) throws Exception;
	public List<RegisterBO> getRegisteredUsers() throws Exception;
	public boolean approveuser(NewLoginBO bo) throws Exception;
	public List<SearchBO> getuserBooksByStatus(String userid) throws Exception;
	public boolean changeReserveStatusToCheckout(String[] id, String userid,
			String status) throws Exception;
	List<SearchBO> getuserBorrowedBooksByStatus(String userid) throws Exception;
	public boolean returnBook(String[] id, String userid, String string) throws Exception;
	public List<TopTenBorrowersBO> getTopTenBorrower(String brid) throws Exception;
	public List<TopTenBook> getTopTenBooks(String brid) throws Exception;
	public List<AverageFineBO> getAverageFine() throws Exception;
	
	
	
}

