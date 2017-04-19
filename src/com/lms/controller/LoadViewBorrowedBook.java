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
import com.lms.model.SearchBO;

/**
 * Servlet implementation class LoadViewBorrowedBook
 */
public class LoadViewBorrowedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadViewBorrowedBook() {
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
			HttpSession session = request.getSession();
			String userid = null;
			if(null != session.getAttribute("id")){
				userid = (String) session.getAttribute("id");
			}
			List<SearchBO> reservelist = dao.getuserBorrowedBooksByStatus(userid);
			if(reservelist.size() > 0){
				request.setAttribute("list", reservelist);
			}
			request.getRequestDispatcher("/reader/viewBorrowedBooks.jsp").forward(request, response);
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
