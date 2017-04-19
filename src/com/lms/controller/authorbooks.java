package com.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.AuthorBO;
import com.lms.model.BookMstBO;
import com.lms.model.BranchBO;
import com.lms.model.publisherBO;

/**
 * Servlet implementation class authorbooks
 */
public class authorbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private Dao dao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorbooks() {
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
			List<AuthorBO> list = dao.getAuthorList();
			List<publisherBO> list1=dao.getPublisherList();
			if(list.size() > 0){
				request.setAttribute("list", list);
			}
			if(list1.size()>0){
				request.setAttribute("list1", list1);
			}
			
			request.getRequestDispatcher("/admin/addbook.jsp").forward(request, response);
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
