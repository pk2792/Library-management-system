package com.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;

/**
 * Servlet implementation class AddBranch
 */
public class AddBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBranch() {
        super();
        dao = new DaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchname = request.getParameter("bname");
		String location = request.getParameter("bloc");
		try {
			boolean flag = dao.saveBranch(branchname, location);
			if(flag){
				request.setAttribute("msg", "Branch Successfuly Added !!!");
			}else{
				request.setAttribute("msg", "Branch by same name and loction already exists !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/addbranch.jsp").forward(request, response);
	}

}
