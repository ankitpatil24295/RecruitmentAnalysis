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
import com.recruitment.model.Interview;
import com.recruitment.service.InterviewService;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.InterviewServiceImplementation;
import com.recruitment.service.implementation.PositionServiceImplementation;

/**
 * Servlet implementation class JoinedEmplyoeeServlet
 * This servlet fetches list of selected applicants, who have joined and 
 * it also updates number of openings for particular position 
 * and  the closes that position after fullfill requirment
 */
@WebServlet("/JoinedEmplyoeeServlet")
public class JoinedEmplyoeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinedEmplyoeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get all applicant those who are joined 
		InterviewService interviewService = new InterviewServiceImplementation();
		List<Interview> getshortlistedApplicantByJoiningStatus = interviewService
				.getshortlistedApplicantByJoiningStatus();
		
		// Change The position status opened or closed using this method
		PositionService positionService=new PositionServiceImplementation();
		positionService.changePositionStatusFromJoiningStatus();
		
		// After redirecting, display all joined applicant
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("JoinedEmplyoee.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
