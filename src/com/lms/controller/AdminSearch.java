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
 * Servlet implementation class AdminSearch
 */
public class AdminSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearch() {
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
				writer.print("<table width='100%' class='display' id='searchtable'>");
				writer.print("<thead><tr>");
				writer.print("<th width='10%'>Book Title</th><th width='10%'>ISBN CODE</th><th width='10%'>Author Name</th><th width='10%'>Publisher Name</th><th width='10%'>Branch Name</th><th width='10%'>Total</th><th width='10%'>Available</th><th width='10%'>Borrowed</th><th width='10%'>Reserved</th>");
				writer.print("</tr></thead><tbody>");
				for(SearchBO s : searchResult){
					writer.print("<tr>");
					writer.print("<td width='10%'>"+s.getBook_title()+ " <b>("+s.getBook_id()+")</b>"+"</td>");
					writer.print("<td width='10%'>"+s.getIsbn()+"</td>");
					writer.print("<td width='10%'>"+s.getAuthorfname()+" "+s.getAuthorlbname()+"</td>");
					writer.print("<td width='10%'>"+s.getPublishername()+"</td>");
					writer.print("<td width='10%'>"+s.getBranch_name()+"<br>("+s.getBranch_location()+")</td>");
					writer.print("<td width='10%'>"+s.getNo_copies()+"</td>");
					writer.print("<td width='10%'>"+s.getAvailable_copies()+"</td>");
					writer.print("<td width='10%'>"+s.getBorrowcount()+"</td>");
					writer.print("<td width='10%'>"+s.getReservecount()+"</td>");
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
