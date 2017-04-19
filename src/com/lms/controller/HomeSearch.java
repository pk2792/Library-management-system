package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.BorrowMstBO;
import com.lms.model.SearchBO;

/**
 * Servlet implementation class HomeSearch
 */
public class HomeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSearch() {
        super();
        dao = new DaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
//			int branch_id = Integer.parseInt(request.getParameter("brid"));
			String reader_id = "";
			if(null != session.getAttribute("id")){
				reader_id = (String) session.getAttribute("id");
			}
			String book_id = "";
			if(null != request.getParameter("bid") && "" != request.getParameter("bid")){
				book_id = request.getParameter("bid");
			}
			String author_name = "";
			if(null != request.getParameter("aid") && "" != request.getParameter("aid")){
				author_name = request.getParameter("aid");
			}
			String publisher_name = "";
			if(null != request.getParameter("pid") && "" != request.getParameter("pid")){
				publisher_name = request.getParameter("pid");
			}
			List<SearchBO> searchResult = dao.searchBooks(null,book_id,author_name,publisher_name);
			PrintWriter writer = response.getWriter();
			if(searchResult.size() > 0){
				writer.print("<table align='center' width='100%' class='display' id='searchtable'>");
				writer.print("<thead><tr>");
				writer.print("<th>Book Id</th><th>Book Title</th><th>ISBN CODE</th><th>Author Name</th><th>Publisher Name</th><th>Branch Name</th><th>Available Copies</th>");
				writer.print("</tr></thead><tbody>");
				for(SearchBO s : searchResult){
					writer.print("<tr align='center'>");
					writer.print("<td>"+s.getBook_id()+"</td>");
					writer.print("<td>"+s.getBook_title()+"</td>");
					writer.print("<td>"+s.getIsbn()+"</td>");
					writer.print("<td>"+s.getAuthorfname()+" "+s.getAuthorlbname()+"</td>");
					writer.print("<td>"+s.getPublishername()+"</td>");
					writer.print("<td>"+s.getBranch_name()+"<br>("+s.getBranch_location()+")</td>");
					writer.print("<td>"+s.getAvailable_copies()+"</td>");
					writer.print("</tr>");
				}
				writer.print("</tbody></table>");
			}else{
				writer.print("<div align='center' style='font-size:21px;color:red;'>Oopss !!! No Such Data Found According to your search Criteria.</div>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
