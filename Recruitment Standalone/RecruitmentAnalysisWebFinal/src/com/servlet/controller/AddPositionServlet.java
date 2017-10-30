package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPositionServlet
 * This servlet adds all open positions in organization and displays on career page . 
 */
@WebServlet("/AddPositionServlet")
public class AddPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPositionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().getAttribute("name");//hr name
		
		String id=request.getParameter("id"); //fetch HR_ID 
		request.setAttribute("id",id);// set HR_ID
		
		//redirect to add position form, which will fill by HR 
		RequestDispatcher rd = request.getRequestDispatcher("AddPositionForm.jsp");
		rd.forward(request, response);
	}

}
