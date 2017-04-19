package com.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.NewLoginBO;
import com.lms.model.RegisterBO;
import com.lms.util.Email;

/**
 * Servlet implementation class Approve
 */
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Dao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approve() {
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
		try{
			String readerid = request.getParameter("id");
			String pass = request.getParameter(readerid+"p");
			String fname = request.getParameter(readerid+"f");
			String lname = request.getParameter(readerid+"l");
			String email = request.getParameter(readerid+"e");
			NewLoginBO bo = new NewLoginBO();
			bo.setFname(fname);
			bo.setLname(lname);
			bo.setPassword(pass);
			bo.setReaderid(readerid);
			bo.setUsertype("reader");
			bo.setStatus(true);
			bo.setEmail(email);
			boolean flag = dao.approveuser(bo);
			if(flag){
				request.setAttribute("msg", "Reader Approved and CardID have been mailed to the user.");
			}
			List<RegisterBO> registeredusers = dao.getRegisteredUsers();
			if(registeredusers.size() > 0){
				request.setAttribute("users", registeredusers);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
	}

}
