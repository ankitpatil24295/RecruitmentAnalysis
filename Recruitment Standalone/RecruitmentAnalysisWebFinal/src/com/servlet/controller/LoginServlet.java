package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recruitment.model.Hr;
import com.recruitment.service.implementation.HrServiceImplementation;

/**
 * Servlet implementation class LoginServlet
 * perform authentication for Hr. 
 * 
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}//LoginServelt()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//setContentType() tells the client, what content type it is and what to do with it.
		response.setContentType("text/html"); 
		
		//printWriter is use to write the content on web pages.
		PrintWriter out = response.getWriter();
		
		String hrID = request.getParameter("hrID"); //fetched parameter "hrId" from Login page.
		String password = request.getParameter("hrpass");//password fetched from Login page.

		int hrid = Integer.parseInt(hrID);
        
		HrServiceImplementation hrsi = new HrServiceImplementation();
		Hr hr = hrsi.getHr(hrid); //Fetching Hr details from database using hrId
		
		String tempPassword = hr.getHrPassword();
		String tempname = hr.getHrName();

		/*Checking HrId and Password
		 */
		if (password.equals(tempPassword)) {

			HttpSession session = request.getSession();
			session.setAttribute("name", tempname);//set session as a name of Hr
			
			request.setAttribute("hrid",hrID);//send HrId to position form
			
			//After checking authentication, hr is redirected to Hr dashboard. 
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Hrdashboard.jsp");
			requestDispatcher.forward(request, response);

		}//if end
		else {
			//if authentication fails following msg is displayed on same page
			out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}//else end

		out.close();
	}

}
