package com.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.Dao;
import com.lms.dao.DaoImpl;

/**
 * Servlet implementation class MakkuController
 */
public class MakkuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakkuController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new DaoImpl();
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
	}

}
