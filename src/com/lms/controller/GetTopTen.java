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
import com.lms.model.TopTenBorrowersBO;

/**
 * Servlet implementation class GetTopTen
 */
public class GetTopTen extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopTen() {
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
			String brid = request.getParameter("bid");
			List<TopTenBorrowersBO> list = dao.getTopTenBorrower(brid);
			PrintWriter p = response.getWriter();
			if(list.size() > 0){
				p.print("<table width='100%' classs='display' id='searchtable'>");
				p.print("<thead><tr align='center'><th>Sr No.</th><th>Name</th><th>Number of Books Borrowed</th></tr></thead>");
				p.print("<tbody>");
				int i=1;
				for(TopTenBorrowersBO t : list){
					int j = (int) t.getMycount();
					p.print("<tr align='center'>");
					p.print("<td>"+ i++ +"</td>");
					p.print("<td>"+ t.getFname() + " "+ t.getLname() +"</td>");
					p.print("<td>"+ j +"</td>");
					p.print("</tr>");
				}
				p.print("</tbody>");
				p.print("</table>");
			}else{
				p.print("<div align='center' style='color:red;font-size:18px;font-weight:bold;'> No Data Found.</div>");
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
