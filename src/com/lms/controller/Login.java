package com.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.LoginBO;
import com.lms.model.RegisterBO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Dao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		try {

			LoginBO lb=new LoginBO();
			lb.setUsername(username);
			lb.setUser_password(pass);
			
			RegisterBO loginBO = dao.checklogin(lb);
			
			if(null != loginBO){
				String name = loginBO.getFname()+ " " + loginBO.getLname();
				String id = loginBO.getReader_id();
				HttpSession session = request.getSession();
				session.setAttribute("name",name);
				session.setAttribute("id", id);
				session.setAttribute("cardid", loginBO.getUsername());
				if(loginBO.getUser_type().equalsIgnoreCase("admin")){
					response.sendRedirect("admin/adminhomepage.jsp");
				}else if(loginBO.getUser_type().equalsIgnoreCase("reader")){
					response.sendRedirect("reader/readerhomepage.jsp");
				}
			}else{
				request.setAttribute("msg", "Invalid Card Id or Password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
