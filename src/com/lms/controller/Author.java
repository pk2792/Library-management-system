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
import com.lms.model.RegisterBO;

/**
 * Servlet implementation class Author
 */
public class Author extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Author() {
        super();
        dao1=new DaoImpl();
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
		String authorfname=request.getParameter("authorfname");
		String authorlname=request.getParameter("authorlname");
		
		try {			
						
			boolean flag = dao1.auth(authorfname,authorlname);
			if(flag){
				request.setAttribute("msg", " Author Successfuly added !!!");
			}else{
				request.setAttribute("msg", "Author by same name might already exist.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/Author.jsp").forward(request, response);
		
	}
	}


