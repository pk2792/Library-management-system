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
import com.lms.model.RegisterBO;
import com.lms.model.publisherBO;

/**
 * Servlet implementation class AddBook
 */
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        dao1=new DaoImpl();
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
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String Author_id = request.getParameter("Author");
		String publisher = request.getParameter("publisher");
//		String publisheradd = request.getParameter("publisheradd");		
		String pubdate = request.getParameter("pubdate");
				
		try {
			BookMstBO ab=new BookMstBO();
			ab.setIsbn(isbn); 
			ab.setBook_title(title);
			ab.setAuthour_id(Author_id);
			ab.setPublisher_id(publisher);
//			ab.setPublisher_add(publisheradd);
			ab.setPublication_date(pubdate);
						
			boolean flag = dao1.addbook(ab);
			if(flag){
				request.setAttribute("msg", " Added Successfuly !!!");
			}else{
				request.setAttribute("msg", "Book By Same Name, Author and Publisher might already exist !!!");
			}
			List<AuthorBO> list = dao1.getAuthorList();
			List<publisherBO> list1=dao1.getPublisherList();
			if(list.size() > 0){
				request.setAttribute("list", list);
			}
			if(list1.size()>0){
				request.setAttribute("list1", list1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/addbook.jsp").forward(request, response);
	}
		
	}


