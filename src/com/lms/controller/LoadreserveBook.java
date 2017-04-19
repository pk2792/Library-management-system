package com.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.BorrowMstBO;
import com.lms.model.ReserveMstBO;

/**
 * Servlet implementation class reserveBook
 */
public class LoadreserveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadreserveBook() {
        super();
        dao=new DaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			HttpSession session = request.getSession();
			String userid = null;
			if(null != session.getAttribute("id")){
				userid = (String) session.getAttribute("id");
			}
			List<ReserveMstBO> reservelist = dao.getuserReservedBooks(userid);
			request.setAttribute("count", reservelist.size());
			request.getRequestDispatcher("/reader/reserveBook.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
