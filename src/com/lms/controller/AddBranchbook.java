package com.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;
import com.lms.model.BookMstBO;
import com.lms.model.BranchBO;
import com.lms.model.BranchbookBO;

/**
 * Servlet implementation class AddBranchbook
 */
public class AddBranchbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBranchbook() {
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
		String branch_id = request.getParameter("branch");
		String book_id=request.getParameter("books");
		int no_copies= Integer.parseInt(request.getParameter("copies"));
		
		try{
			BranchbookBO bb=new BranchbookBO();
			bb.setBook_id(book_id);
			bb.setBranch_id(branch_id);
			bb.setNo_copies(no_copies);
			
			boolean flag = dao.addbbook(bb);
			if(flag){
				request.setAttribute("msg", " Added Successfuly !!!");
			}
			
			List<BranchBO> list = dao.getBranchList();
			List<BookMstBO> list1 = dao.getBookList();
			if(list.size() > 0){
				request.setAttribute("list", list);
			}
			if(list1.size()>0){
				request.setAttribute("list1", list1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/book_branchMap.jsp").forward(request, response);
	}
		}
	


