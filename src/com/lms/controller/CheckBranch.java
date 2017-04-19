package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;

/**
 * Servlet implementation class CheckBranch
 */
public class CheckBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBranch() {
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
			String name = request.getParameter("bname");
			System.out.println("Name =>>" + name);
			boolean flag = dao.checkBranchName(name);
			PrintWriter writer = response.getWriter();
			writer.print(flag);
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
