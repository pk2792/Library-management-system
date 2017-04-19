package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.lms.util.DBUtil;
import com.lms.util.Email;
import com.mysql.fabric.xmlrpc.base.Array;

public class DaoImpl implements Dao {
	
	private Connection conn;

	public DaoImpl() {
		conn = DBUtil.getConnection();
	}
	public RegisterBO checklogin(LoginBO l) throws Exception {
		// TODO Auto-generated method stub
		RegisterBO bo = null;
		try{
			String sql = "select * from login_mst where cardid = ? and password = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,l.getUsername());
			preparedStatement.setString(2,l.getUser_password());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				bo = new RegisterBO();
				bo.setUser_type(resultSet.getString("usertype"));
				bo.setFname(resultSet.getString("fname"));
				bo.setLname(resultSet.getString("lname"));
				bo.setReader_id(resultSet.getString("reader_id"));
				bo.setUsername(resultSet.getString("cardid"));
//				name = resultSet.getString("description");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bo;
	}
	@Override
	public boolean saveBranch(String branchname, String location)
			throws Exception {
		// TODO Auto-generated method stub
		try{
			String sql = "select * from branch_mst where upper(branch_name)= '"+branchname.toUpperCase()+"' and upper(branch_location) = '"+location.toUpperCase()+"'";
			PreparedStatement p  = conn.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			if(!r.next()){
			
			String query = "INSERT INTO branch_mst(branch_name, branch_location) VALUES (?, ?)";
			PreparedStatement stmnt = conn.prepareStatement(query);
				stmnt.setString(1, branchname);
				stmnt.setString(2, location);
				int i = stmnt.executeUpdate();
				if(i > 0){
					return true;
				}
				stmnt.close();
				DBUtil.closeConnection(conn);
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BranchBO> getBranchList() throws Exception {
		// TODO Auto-generated method stub
		List<BranchBO> list = new ArrayList<>();
		try{
			String sql = "select * from branch_mst";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				BranchBO bo = new BranchBO();
				bo.setBranch_id(resultSet.getString("branch_id"));
				bo.setBranch_name(resultSet.getString("branch_name"));
				bo.setBranch_location(resultSet.getString("branch_location"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<BookMstBO> getBookList() throws Exception {
		// TODO Auto-generated method stub
		List<BookMstBO> list = new ArrayList<>();
		try{
			String sql = "select b.book_title, b.book_id, p.publisher_name from book_mst b, publisher_mst p where b.publisher_id = p.publisher_id";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				BookMstBO bo = new BookMstBO();
//				bo.setIsbn(resultSet.getString("isbn"));
				bo.setBook_title(resultSet.getString("book_title"));
//				bo.setPublication_date(resultSet.getString("publication_date"));
				bo.setPublication_date(resultSet.getString("publisher_name"));
				bo.setBook_id(resultSet.getString("book_id"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean reg(RegisterBO r) throws Exception {
		// TODO Auto-generated method stub
		
		try{
			
	String query = "INSERT INTO public.user_registration_mst(fname, lname, add, contact, email, pass,status) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, r.getFname());
			preparedStatement.setString(2, r.getLname());
			preparedStatement.setString(3, r.getAdd());
			preparedStatement.setString(4, r.getContact());
			preparedStatement.setString(5, r.getEmail());			
			preparedStatement.setString(6,r.getPass());
			preparedStatement.setBoolean(7, r.isStatus());
			int i = preparedStatement.executeUpdate();
			
			if(i > 0){
				return true;
			}
			preparedStatement.close();
			DBUtil.closeConnection(conn);
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean auth(String authorfname, String authorlname) throws Exception{
		// TODO Auto-generated method stub
		try{
			String sql = "select * from author_mst where upper(uthorfname) = '"+authorfname.toUpperCase()+"' and upper(authorlname) = '"+authorlname.toUpperCase()+"'";
			PreparedStatement p  = conn.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			if(!r.next()){
			String query = "INSERT INTO public.author_mst(authorfname, authorlname) VALUES (?, ?)";
			PreparedStatement stmnt = conn.prepareStatement(query);
				stmnt.setString(1, authorfname);
				stmnt.setString(2, authorlname);
				int i = stmnt.executeUpdate();
				if(i > 0){
					return true;
				}
				stmnt.close();
				DBUtil.closeConnection(conn);
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean pub(String pname, String ploc)throws Exception {
		// TODO Auto-generated method stub
		try{
			String sql = "select * from publisher_mst where upper(publisher_name) = '"+pname.toUpperCase()+"' and upper(publisher_location) = '"+ploc.toUpperCase()+"'";
			PreparedStatement p  = conn.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			if(!r.next()){
			String query = "INSERT INTO public.publisher_mst(publisher_name, publisher_location) VALUES (?, ?)";
			PreparedStatement stmnt = conn.prepareStatement(query);
				stmnt.setString(1, pname);
				stmnt.setString(2, ploc);
				int i = stmnt.executeUpdate();
				if(i > 0){
					return true;
				}
				stmnt.close();
				DBUtil.closeConnection(conn);
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<AuthorBO> getAuthorList() throws Exception {
		// TODO Auto-generated method stub
		List<AuthorBO> list = new ArrayList<>();
		try{
			String sql = "select * from public.author_mst";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AuthorBO bo = new AuthorBO();
				bo.setAuthor_id(resultSet.getString("author_id"));
				bo.setAuthorfname(resultSet.getString("authorfname"));
				bo.setAuthorlname(resultSet.getString("authorlname"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<publisherBO> getPublisherList() throws Exception {
		// TODO Auto-generated method stub
		List<publisherBO> list = new ArrayList<>();
		try{
			String sql = "select * from public.publisher_mst";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				publisherBO bo=new publisherBO();
				bo.setPublisher_id(resultSet.getString("publisher_id"));
				bo.setPublisher_name(resultSet.getString("publisher_name"));
				bo.setPublisher_location(resultSet.getString("publisher_location"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean addbook(BookMstBO ab) {
		// TODO Auto-generated method stub
		try{
			String sql = "select * from book_mst where upper(book_title) = '"+ab.getBook_title().toUpperCase()+"' and author_id = '"+ab.getAuthour_id()+"' and publisher_id = '"+ab.getPublisher_id()+"'";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			if(!r.next()){
			String query = "INSERT INTO book_mst(book_title, isbn, author_id, publisher_id, publication_date) VALUES (?, ?, ?, ?,?)";

					PreparedStatement preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, ab.getBook_title());
					preparedStatement.setString(2, ab.getIsbn());
					preparedStatement.setString(3, ab.getAuthour_id());
					preparedStatement.setString(4, ab.getPublisher_id());
					preparedStatement.setString(5, ab.getPublication_date());			
					int i = preparedStatement.executeUpdate();
					
					if(i > 0){
						return true;
					}
					preparedStatement.close();
				}else{
					return false;
				}
		}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;
			}
	@Override
	public boolean addbbook(BranchbookBO bb) {
		// TODO Auto-generated method stub
		try{
			String sql="select * from public.branch_bookmap WHERE branch_id=? and book_id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bb.getBranch_id());
			preparedStatement.setString(2, bb.getBook_id());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				System.out.println("Inside update");
				int noofcop = resultSet.getInt("no_copies");
				int avail = resultSet.getInt("available_copies");
				String sql1="UPDATE public.branch_bookmap SET no_copies=?, available_copies=? WHERE branch_id=? and book_id=?";
				PreparedStatement ps=conn.prepareStatement(sql1);
				ps.setInt(1, noofcop + bb.getNo_copies());
				ps.setInt(2,  avail + bb.getNo_copies());
				ps.setString(3, bb.getBranch_id());
				ps.setString(4, bb.getBook_id());
				int resultSet1=ps.executeUpdate();
				if(resultSet1 > 0){
					return true;
				}
			}else{
			
			String query = "INSERT INTO public.branch_bookmap(branch_id, book_id, no_copies,available_copies)VALUES (?, ?, ?, ?)";
					PreparedStatement preparedStatement1 = conn.prepareStatement(query);
					preparedStatement1.setString(1, bb.getBranch_id());
					preparedStatement1.setString(2, bb.getBook_id());
					preparedStatement1.setInt(3, bb.getNo_copies());
					preparedStatement1.setInt(4, bb.getNo_copies());
					int i = preparedStatement1.executeUpdate();
					if(i > 0){
						return true;
					}
					preparedStatement.close();
					DBUtil.closeConnection(conn);
					}
			}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;
			}
	@Override
	public List<SearchBO> searchBooks(String branch_id, String book_id,
			String author_name, String publisher_name) throws Exception {
		// TODO Auto-generated method stub
		List<SearchBO> list = new ArrayList<>();
		try{
			String sql = "select b.*,a.authorfname,a.authorlname,p.publisher_id,p.publisher_name,br.branch_name,brm.available_copies,brm.branch_id,br.branch_location,brm.no_copies,brm.borrowcount,brm.reservecount from branch_bookmap brm " +
					"LEFT JOIN book_mst b ON brm.book_id = b.book_id " +
					"LEFT JOIN author_mst a ON b.author_id = a.author_id " +
					"LEFT JOIN publisher_mst p ON b.publisher_id = p.publisher_id " +
					"LEFT JOIN branch_mst br ON br.branch_id = brm.branch_id where b.book_id is not null ";
			if(book_id != ""){
				sql = sql + "and brm.book_id = '"+book_id+"' ";
			}
			if(author_name != ""){
				sql = sql + " and (upper(a.authorfname) like '%"+author_name.toUpperCase()+"%' or upper(a.authorlname) like '%"+author_name.toUpperCase()+"%') ";
			}
			if(publisher_name != ""){
				sql = sql + " and upper(p.publisher_name) like '%"+publisher_name.toUpperCase()+"%' ";
			}
			
			System.out.println("Final query ==>>" + sql);
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				SearchBO bo = new SearchBO();
				bo.setAuthorfname(resultSet.getString("authorfname"));
				bo.setAuthorlbname(resultSet.getString("authorlname"));
				bo.setPublishername(resultSet.getString("publisher_name"));
				bo.setBook_id(resultSet.getString("book_id"));
				bo.setBook_title(resultSet.getString("book_title"));
				bo.setBranch_name(resultSet.getString("branch_name"));
				bo.setIsbn(resultSet.getString("isbn"));
				bo.setAvailable_copies(resultSet.getInt("available_copies"));
				bo.setBranch_id(resultSet.getString("branch_id"));
				bo.setBranch_location(resultSet.getString("branch_location"));
				bo.setPublisher_id(resultSet.getString("publisher_id"));
				bo.setNo_copies(resultSet.getInt("no_copies"));
				bo.setBorrowcount(resultSet.getInt("borrowcount"));
				bo.setReservecount(resultSet.getInt("reservecount"));
				list.add(bo);
			}
			}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<BranchBookView> getBooksByBranchId(int branch_id)
			throws Exception {
		// TODO Auto-generated method stub
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean checkBranchName(String name) throws Exception {
		// TODO Auto-generated method stub
		try{
			String sql = "select * from public.branch_mst where branch_name = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<BorrowMstBO> getUserBorrowedBooks(String userid) throws Exception {
		// TODO Auto-generated method stub
		List<BorrowMstBO> list = new ArrayList<>();
		try{
			String sql = "select * from borrow_reserve_mst where reader_id = ? and (status = 'borrow' or status = 'reserve')";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				BorrowMstBO bo = new BorrowMstBO();
				bo.setBook_id(resultSet.getString("book_id"));
				bo.setBranch_id(resultSet.getString("branch_id"));
				bo.setStatus(resultSet.getString("status"));
				list.add(bo);
			}
			preparedStatement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean saveReaderBorrowedBooks(String[] id, String userid, String status)
			throws Exception {
		// TODO Auto-generated method stub
		try{
			String query = "INSERT INTO borrow_reserve_mst(borrow_date, return_date, status, reader_id, book_id, branch_id) VALUES (?, ?, ?, ?, ?, ?)";
			Calendar cal = Calendar.getInstance();
			Timestamp t = new Timestamp(cal.getTimeInMillis());
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setTimestamp(1, t);
			preparedStatement.setDate(2,null);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, userid);
			int j=0;
			for(int i=0; i<id.length;i++){
				preparedStatement.setString(5, id[i].split("/")[0]);
				preparedStatement.setString(6, id[i].split("/")[1]);
				j = preparedStatement.executeUpdate();
			}
			preparedStatement.close();
			if(j > 0){
				String query1 = "UPDATE branch_bookmap SET available_copies=?, borrowcount=? WHERE branch_id=? and book_id=?";
				for(int k=0;k<id.length;k++){
					String brid = id[k].split("/")[1];
					String bookid = id[k].split("/")[0];
					String q = "SELECT available_copies,borrowcount FROM branch_bookmap where branch_id = ? and book_id = ?";
					PreparedStatement p = conn.prepareStatement(q);
					p.setString(1, brid);
					p.setString(2, bookid);
					ResultSet r = p.executeQuery();
					while(r.next()){
						int avail = r.getInt("available_copies");
						int borcount = r.getInt("borrowcount");
						PreparedStatement up = conn.prepareStatement(query1);
						up.setInt(1, avail-1);
						up.setInt(2, borcount+1);
						up.setString(3, brid);
						up.setString(4, bookid);
						int rs = up.executeUpdate();
						if(rs > 0){
							System.out.println("True");
						}
					}
				}
			}else{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
		
	}
	@Override
	public List<ReserveMstBO> getuserReservedBooks(String userid) throws Exception {
		// TODO Auto-generated method stub
		List<ReserveMstBO> list = new ArrayList<>();
		try{
			String sql = "select * from borrow_reserve_mst where reader_id = ? and (status = 'borrow' or status = 'reserve')";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ReserveMstBO bo = new ReserveMstBO();
				bo.setBook_id(resultSet.getString("book_id"));
				bo.setBranch_id(resultSet.getString("branch_id"));
				bo.setStatus(resultSet.getString("status"));
				list.add(bo);
			}
			preparedStatement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean saveReaderReservedBooks(String[] id, String userid, String status) throws Exception {
		// TODO Auto-generated method stub
		try{
			String query = "INSERT INTO borrow_reserve_mst(borrow_date, return_date, status, reader_id, book_id, branch_id) VALUES (?, ?, ?, ?, ?, ?)";
			Calendar cal = Calendar.getInstance();
			Timestamp t = new Timestamp(cal.getTimeInMillis());
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setTimestamp(1, t);
			preparedStatement.setDate(2,null);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, userid);
			int j=0;
			for(int i=0; i<id.length;i++){
				preparedStatement.setString(5, id[i].split("/")[0]);
				preparedStatement.setString(6, id[i].split("/")[1]);
				j = preparedStatement.executeUpdate();
			}
			preparedStatement.close();
			if(j > 0){
				String query1 = "UPDATE branch_bookmap SET available_copies=?, reservecount=? WHERE branch_id=? and book_id=?";
				for(int k=0;k<id.length;k++){
					String brid = id[k].split("/")[1];
					String bookid = id[k].split("/")[0];
					String q = "SELECT available_copies,reservecount FROM branch_bookmap where branch_id = ? and book_id = ?";
					PreparedStatement p = conn.prepareStatement(q);
					p.setString(1, brid);
					p.setString(2, bookid);
					ResultSet r = p.executeQuery();
					while(r.next()){
						int avail = r.getInt("available_copies");
						int rescount = r.getInt("reservecount");
						PreparedStatement up = conn.prepareStatement(query1);
						up.setInt(1, avail-1);
						up.setInt(2, rescount+1);
						up.setString(3, brid);
						up.setString(4, bookid);
						int rs = up.executeUpdate();
						if(rs > 0){
							System.out.println("True");
						}
					}
				}
			}else{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
		
	}
	@Override
	public List<FineBO> getListWithFine(String readerid) throws Exception {
		// TODO Auto-generated method stub
		List<FineBO> list = new ArrayList<>();
		try{
			String sql = "select br.borrow_date,b.book_title,bm.branch_name,p.publisher_name,a.authorfname,a.authorlname,case when DATE_PART('day', now() - borrow_date) > 20 then ((DATE_PART('day', now() - borrow_date)-20)*0.20) else 0 end as fine " +
					"from borrow_reserve_mst br LEFT JOIN book_mst b ON b.book_id = br.book_id " +
					"LEFT JOIN branch_mst bm ON bm.branch_id = br.branch_id " +
					"LEFT JOIN author_mst a ON b.author_id = a.author_id " +
					"LEFT JOIN publisher_mst p ON b.publisher_id = p.publisher_id " +
					"where reader_id = ? and status = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, readerid);
			p.setString(2, "borrow");
			ResultSet r = p.executeQuery();
			while(r.next()){
				FineBO bo = new FineBO();
				bo.setBook_title(r.getString("book_title"));
				bo.setAuthorfname(r.getString("authorfname"));
				bo.setAuthorlname(r.getString("authorlname"));
				bo.setBranch_name(r.getString("branch_name"));
				bo.setBorrowdate(r.getTimestamp("borrow_date"));
				bo.setFine(r.getDouble("fine"));
				bo.setPubname(r.getString("publisher_name"));
				list.add(bo);
			}
			p.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<RegisterBO> getRegisteredUsers() throws Exception {
		// TODO Auto-generated method stub
		List<RegisterBO> list = new ArrayList<>();
		try{
			String sql = "select * from user_registration_mst where status = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setBoolean(1, false);
			ResultSet r = preparedStatement.executeQuery();
			while(r.next()){
				RegisterBO bo = new RegisterBO();
				bo.setContact(r.getString("contact"));
				bo.setEmail(r.getString("email"));
				bo.setFname(r.getString("fname"));
				bo.setLname(r.getString("lname"));
				bo.setReader_id(r.getString("reader_id"));
				bo.setPass(r.getString("pass"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean approveuser(NewLoginBO bo) throws Exception {
		// TODO Auto-generated method stub
 		try{
			String sql = "INSERT INTO login_mst(reader_id, fname, lname, password, status, usertype) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, bo.getReaderid());
			p.setString(2, bo.getFname());
			p.setString(3, bo.getLname());
			p.setString(4, bo.getPassword());
			p.setBoolean(5, bo.isStatus());
			p.setString(6, bo.getUsertype());
			int i = p.executeUpdate();
			if(i > 0){
				String update = "update user_registration_mst set status = ? where reader_id = ?";
				PreparedStatement upd = conn.prepareStatement(update);
				upd.setBoolean(1, true);
				upd.setString(2, bo.getReaderid());
				int j = upd.executeUpdate();
				if(j > 0){
					String cardid="",password="";
					String query = "select cardid, password from login_mst where reader_id = ?";
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, bo.getReaderid());
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						cardid = rs.getString("cardid");
						password = rs.getString("password");
					}
					Email.sendMail(bo.getEmail(), "Your Library cardid is : " + cardid + ". Your password is : " + password);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public List<SearchBO> getuserBooksByStatus(String userid)
			throws Exception {
		// TODO Auto-generated method stub
		List<SearchBO> list = new ArrayList<>();
		try{
			String sql = "select * from borrow_reserve_mst br " +
					"LEFT JOIN book_mst b on br.book_id = b.book_id " +
					"LEFT JOIN branch_mst brnch on br.branch_id = brnch.branch_id"+
					" where br.reader_id = ? and (br.status = 'reserve' or br.status='Cancelled')";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, userid);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				SearchBO bo = new SearchBO();
				bo.setBook_id(rs.getString("book_id"));
				bo.setBook_title(rs.getString("book_title"));
				bo.setBranch_id(rs.getString("branch_id"));
				bo.setBranch_name(rs.getString("branch_name"));
				bo.setBranch_location(rs.getString("branch_location"));
				bo.setAuthorfname(rs.getString("status"));
				bo.setBorrow_id(rs.getInt("borrow_id"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean changeReserveStatusToCheckout(String[] id, String userid,
			String status) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "UPDATE borrow_reserve_mst SET borrow_date=?, status=? WHERE borrow_id = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			Calendar cal = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			ps.setTimestamp(1, timestamp);
			ps.setString(2, status);
//			ps.setString(3, userid);
			int j=0;
			for(int i=0;i<id.length;i++){
				ps.setInt(3, Integer.parseInt(id[i].split("/")[2]));
//				ps.setString(5, id[i].split("/")[1]);
				j = j+ps.executeUpdate();
			}
			if(j > 0){
				String query1 = "UPDATE branch_bookmap SET reservecount=?, borrowcount=? WHERE branch_id=? and book_id=?";
				for(int k=0;k<id.length;k++){
					String brid = id[k].split("/")[1];
					String bookid = id[k].split("/")[0];
					String q = "SELECT reservecount,borrowcount FROM branch_bookmap where branch_id = ? and book_id = ?";
					PreparedStatement p = conn.prepareStatement(q);
					p.setString(1, brid);
					p.setString(2, bookid);
					ResultSet r = p.executeQuery();
					while(r.next()){
						int avail = r.getInt("reservecount");
						int borcount = r.getInt("borrowcount");
						PreparedStatement up = conn.prepareStatement(query1);
						up.setInt(1, avail-1);
						up.setInt(2, borcount+1);
						up.setString(3, brid);
						up.setString(4, bookid);
						int rs = up.executeUpdate();
						if(rs > 0){
							flag = true;
						}
					}
				}
				flag = true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<SearchBO> getuserBorrowedBooksByStatus(String userid)
			throws Exception {
		// TODO Auto-generated method stub
		List<SearchBO> list = new ArrayList<>();
		try{
			String sql = "select *, DATE_PART('day', now() - br.borrow_date) as days from borrow_reserve_mst br " +
					"LEFT JOIN book_mst b on br.book_id = b.book_id " +
					"LEFT JOIN branch_mst brnch on br.branch_id = brnch.branch_id"+
					" where br.reader_id = ? and (br.status = 'borrow' or br.status='return')";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, userid);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				SearchBO bo = new SearchBO();
				bo.setBook_id(rs.getString("book_id"));
				bo.setBook_title(rs.getString("book_title"));
				bo.setBranch_id(rs.getString("branch_id"));
				bo.setBranch_name(rs.getString("branch_name"));
				bo.setBranch_location(rs.getString("branch_location"));
				bo.setAuthorfname(rs.getString("status"));
				bo.setBorrow_date(rs.getTimestamp("borrow_date"));
				bo.setReturn_date(rs.getTimestamp("return_date"));
				bo.setDays(rs.getDouble("days"));
				bo.setBorrow_id(rs.getInt("borrow_id"));
				list.add(bo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean returnBook(String[] id, String userid, String status)
			throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "UPDATE borrow_reserve_mst SET return_date=?, status=? WHERE borrow_id = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			Calendar cal = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			ps.setTimestamp(1, timestamp);
			ps.setString(2, status);
//			ps.setString(3, userid);
			int j = 0;
			for(int i=0;i<id.length;i++){
				ps.setInt(3, Integer.parseInt(id[i].split("/")[2]));
				j = j+ps.executeUpdate();
			}
			
			if(j > 0){
				String query1 = "UPDATE branch_bookmap SET available_copies=?, borrowcount=? WHERE branch_id=? and book_id=?";
				for(int k=0;k<id.length;k++){
					String brid = id[k].split("/")[1];
					String bookid = id[k].split("/")[0];
					String q = "SELECT available_copies,borrowcount FROM branch_bookmap where branch_id = ? and book_id = ?";
					PreparedStatement p = conn.prepareStatement(q);
					p.setString(1, brid);
					p.setString(2, bookid);
					ResultSet r = p.executeQuery();
					while(r.next()){
						int avail = r.getInt("available_copies");
						int borcount = r.getInt("borrowcount");
						PreparedStatement up = conn.prepareStatement(query1);
						up.setInt(1, avail+1);
						up.setInt(2, borcount-1);
						up.setString(3, brid);
						up.setString(4, bookid);
						int rs = up.executeUpdate();
						if(rs > 0){
							flag = true;
						}
					}
				}
				flag = true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<TopTenBorrowersBO> getTopTenBorrower(String brid)
			throws Exception {
		// TODO Auto-generated method stub
		List<TopTenBorrowersBO> list = new ArrayList<>();
		try{
			String sql = "select count(*) as mycount,u.fname, u.lname from borrow_reserve_mst brm " +
					"LEFT JOIN user_registration_mst u ON brm.reader_id = u.reader_id " +
					"where brm.branch_id = '"+brid+"' and (brm.status='borrow' or brm.status='return') " +
					"group by brm.reader_id, u.fname, u.lname order by mycount desc limit 10";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet resultSet = p.executeQuery();
			while(resultSet.next()){
				TopTenBorrowersBO bo = new TopTenBorrowersBO();
				bo.setFname(resultSet.getString("fname"));
				bo.setLname(resultSet.getString("lname"));
				bo.setMycount(resultSet.getDouble("mycount"));
				list.add(bo);
			}
			resultSet.close();
			p.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<TopTenBook> getTopTenBooks(String brid) throws Exception {
		// TODO Auto-generated method stub
		List<TopTenBook> list = new ArrayList<>();
		try{
			String sql = "select count(brm.book_id) as count, b.book_title, a.authorfname, a.authorlname, p.publisher_name " +
					"from borrow_reserve_mst brm, book_mst b, author_mst a, publisher_mst p " +
					"where brm.book_id = b.book_id and a.author_id=b.author_id and p.publisher_id=b.publisher_id and " +
					"branch_id = '"+brid+"' and (status = 'borrow' or status = 'return') " +
					"group by brm.book_id, b.book_title,a.authorfname, a.authorlname,p.publisher_name order by count(brm.book_id) desc limit 10";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet resultSet = p.executeQuery();
			while(resultSet.next()){
				TopTenBook bo = new TopTenBook();
				bo.setAuthorfname(resultSet.getString("authorfname"));
				bo.setAuthorlname(resultSet.getString("authorlname"));
				bo.setBook_name(resultSet.getString("book_title"));
				bo.setPublisher_name(resultSet.getString("publisher_name"));
				bo.setCount(resultSet.getInt("count"));
				list.add(bo);
			}
			resultSet.close();
			p.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<AverageFineBO> getAverageFine() throws Exception {
		// TODO Auto-generated method stub
		List<AverageFineBO> list = new ArrayList<>();
		try{
			String sql = "SELECT reader_id, fname, lname, SUM (temp)/COUNT(book_id) as afine " +
					"From (SELECT brm.book_id, brm.reader_id, u.fname, u.lname, " +
					"DATE_PART('day', now() - brm.borrow_date) as TotalDayes ," +
					"((DATE_PART('day', now() - brm.borrow_date)-20)*0.20) as temp " +
					"From borrow_reserve_mst brm,user_registration_mst u where brm.reader_id=u.reader_id " +
					"Group by brm.book_id,brm.reader_id,u.fname, u.lname,brm.borrow_date " +
					"having DATE_PART('day', now() - brm.borrow_date) >20) as fines group by reader_id,fname, lname";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet resultSet = p.executeQuery();
			while(resultSet.next()){
				AverageFineBO bo = new AverageFineBO();
				bo.setFname(resultSet.getString("fname"));
				bo.setLname(resultSet.getString("lname"));
				bo.setAfine(resultSet.getFloat("afine"));
				list.add(bo);
			}
			resultSet.close();
			p.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
