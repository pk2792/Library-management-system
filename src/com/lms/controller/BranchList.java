package com.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.BranchBO;

/**
 * Servlet implementation class BranchList
 */
public class BranchList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchList() {
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
			List<BranchBO> list = dao.getBranchList();
			if(list.size() > 0){
				request.setAttribute("list", list);
			}
			if(null != request.getParameter("id")){
				request.getRequestDispatcher("/admin/toptenbooks.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/admin/toptenborrower.jsp").forward(request, response);
			}
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
