package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.BranchBookView;
import com.lms.model.SearchBO;

/**
 * Servlet implementation class GetBooksByBranch
 */
public class GetBooksByBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBooksByBranch() {
        super();
        dao = new DaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String branch_id = request.getParameter("brid");
			List<SearchBO> list = dao.searchBooks(branch_id, "", "", "");
			PrintWriter writer = response.getWriter();
			if(list.size() > 0){
				writer.print("<table id='booktable' class='display' width='100%'>");
				writer.print("<thead><tr>");
				writer.print("<th>Book Id</th><th>Book Title</th><th>ISBN CODE</th><th>Author Name</th><th>Publisher Name</th><th>Available Copies</th><th>Checkout</th>");
				writer.print("</tr></thead><tbody>");
				for(SearchBO s : list){
					writer.print("<tr align='center'>");
					writer.print("<td>"+s.getBook_id()+"</td>");
					writer.print("<td>"+s.getBook_title()+"</td>");
					writer.print("<td>"+s.getIsbn()+"</td>");
					writer.print("<td>"+s.getAuthorfname()+" "+s.getAuthorlbname()+"</td>");
					writer.print("<td>"+s.getPublishername()+"</td>");
					writer.print("<td>"+s.getAvailable_copies()+"</td>");
					writer.print("<td><input type='button' value='Checkout' id='"+s.getBook_id()+"/"+s.getBranch_id()+"' onclick='checkout(this.id);'/></td>");
					writer.print("</tr>");
				}
				writer.print("</tbody></table>");
			}else{
				writer.print("<div align='center' style='font-size:21px;color:red;'>Oopss !!! No Books Available in this Branch.</div>");
			}
			
		}catch(Exception e){
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
