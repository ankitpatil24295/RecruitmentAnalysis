package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Apply;
import com.recruitment.service.ApplyService;
import com.recruitment.service.implementation.ApplyServiceImplementation;

/**
 * Servlet implementation class InterviewResultServlet
 * This servlet is used to set interview process details.
 */
@WebServlet("/InterviewResultServlet")
public class InterviewResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InterviewResultServlet() {
		super();
	}//InterviewResultServlet()

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplyService applyService = new ApplyServiceImplementation();
		//fetch the details of all Applied Applicant 
		List<Apply> displayAppliedApplicants = applyService.displayAppliedApplicants();
        
		//set the details of all Applied Applicant
		request.setAttribute("displayAppliedApplicants", displayAppliedApplicants);
		
		//after redirecting into interviewresult hr has to filled the details of interview of Applicant
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("InterviewResults.jsp");
		requestDispatcher.forward(request, response);
			
		
	}//doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}//doPost()

}
