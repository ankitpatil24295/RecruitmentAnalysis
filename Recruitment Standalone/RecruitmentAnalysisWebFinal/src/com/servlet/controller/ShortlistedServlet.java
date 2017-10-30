package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Applicant;
import com.recruitment.model.Interview;
import com.recruitment.model.Position;
import com.recruitment.service.InterviewService;
import com.recruitment.service.implementation.InterviewServiceImplementation;

/**
 * Servlet implementation class ShortlistedServlet
 * Add interview process details along with results, in interview table.
 */
@WebServlet("/ShortlistedServlet")
public class ShortlistedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShortlistedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int appId = Integer.parseInt(request.getParameter("appID"));//fetch appliacant Id

		int postionId = Integer.parseInt(request.getParameter("positionID"));//fetch position Id

		String dateOfJoiningRecieved = request.getParameter("dateofjoin");//fetch date of joining

		Date dateOfJoining = Date.valueOf(dateOfJoiningRecieved);

		String dateRecieved = request.getParameter("date");//fetch interview date

		Date dateOfInterview = Date.valueOf(dateRecieved);

		String result = request.getParameter("candidateresult");//fetch interview result(selected/not selected)

		String joiningStatusReceived = request.getParameter("joinstatus");//fetch joining status
		
		boolean candidateResult = false;
		boolean joiningStatus = false;
		
		if (result.equalsIgnoreCase("Selected")) {
			
			candidateResult = true;
			if (joiningStatusReceived.equalsIgnoreCase("Joined")) {
				joiningStatus = true;
				
			}//inner if
			else {

				joiningStatus = false;
			}//inner else
		}//if
		else {
			candidateResult = false;
			joiningStatus = false;
			dateOfJoining=null;
		}//else
		
		Position position = new Position();
		position.setPositionId(postionId);
		Applicant applicant = new Applicant();
		applicant.setApplicantId(appId);

		Interview interview = new Interview(position, applicant, dateOfInterview, candidateResult, dateOfJoining,
				joiningStatus);
		InterviewService interviewService = new InterviewServiceImplementation();
		interviewService.addInterview(interview);//add new Interview details into interview table
     
		 out.print("Applicant ID "+appId+" Interview Result Successfully Stored");
		 
		RequestDispatcher requestDispatcher =request.getRequestDispatcher("updateInterview.jsp");
		requestDispatcher.include(request, response);

	}

}
