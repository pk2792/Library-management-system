package com.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;

/**
 * Servlet implementation class publisher
 */
public class publisher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publisher() {
        super();
        dao=new DaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pname=request.getParameter("pname");
		String ploc=request.getParameter("ploc");
		
		try {			
						
			boolean flag = dao.pub(pname,ploc);
			if(flag){
				request.setAttribute("msg", " Publisher Successfuly added !!!");
			}else{
				request.setAttribute("msg", " Publisher by Same name and location might already exist !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/publisher.jsp").forward(request, response);
		
	}
	}


