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
import com.lms.model.TopTenBook;
import com.lms.model.TopTenBorrowersBO;

/**
 * Servlet implementation class GetTopTenBook
 */
public class GetTopTenBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopTenBook() {
        super();dao = new DaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String brid = request.getParameter("bid");
			List<TopTenBook> list = dao.getTopTenBooks(brid);
			PrintWriter p = response.getWriter();
			if(list.size() > 0){
				p.print("<table width='100%' classs='display' id='searchtable'>");
				p.print("<thead><tr align='center'><th>Sr No.</th><th>Book Title</th><th>Author Name</th><th>Pulisher Name</th><th>No of times Book Borrowed</th></tr></thead>");
				p.print("<tbody>");
				int i=1;
				for(TopTenBook t : list){
					p.print("<tr align='center'>");
					p.print("<td>"+ i++ +"</td>");
					p.print("<td>"+ t.getBook_name() +"</td>");
					p.print("<td>"+ t.getAuthorfname() + " "+ t.getAuthorlname() +"</td>");
					p.print("<td>"+ t.getPublisher_name() +"</td>");
					p.print("<td>"+ t.getCount() +"</td>");
					p.print("</tr>");
				}
				p.print("</tbody>");
				p.print("</table>");
			}else{
				p.print("<div align='center' style='color:red;'> No Data Found.</div>");
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
