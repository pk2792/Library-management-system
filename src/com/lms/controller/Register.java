package com.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.RegisterBO;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao daoo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        daoo=new DaoImpl();
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String add = request.getParameter("add");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");		
		String pass = request.getParameter("pass");
		
		
		try {
			RegisterBO ro=new RegisterBO();
			ro.setFname(fname);
			ro.setLname(lname);
			ro.setAdd(add);
			ro.setContact(contact);
			ro.setEmail(email);
			ro.setPass(pass);
			ro.setStatus(false);
						
			boolean flag = daoo.reg(ro);
			if(flag){
				request.setAttribute("msg", "Registered Successfuly. You must visit to any library branch and Contact admin to get your Library Card ID.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Registration.jsp").forward(request, response);
		
		
		
	}

}
