package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Applicant;
import com.recruitment.model.Apply;
import com.recruitment.service.ApplyService;
import com.recruitment.service.implementation.ApplyServiceImplementation;

/**
 * Servlet implementation class AddApplicantServlet
 * Applied applicant are check by criteria and save in database
 */
@WebServlet("/AddApplicantServlet")
public class AddApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddApplicantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//setContentType() tells the client, what content type it is and what to do with it.
		response.setContentType("text/html");
//printWriter is use to write the content on web pages.	
		PrintWriter out = response.getWriter();
		
		
		String applicantName = request.getParameter("aname");//fetched Applicant Name from AppliedForm
		
		String applicantSkillSet = request.getParameter("askillset");//fetched Applicant SkillSet from AppliedForm
		
		String applicantExperience = request.getParameter("aexp");//fetched Applicant Experience from AppliedForm
		double parseApplicantExperience = Double.parseDouble(applicantExperience);//convert string to double

		String positionId = request.getParameter("applyposition");// fetched PositionID which is applied from AppliedForm
        int parsePositionId = Integer.parseInt(positionId);
        
		ApplyService applyService = new ApplyServiceImplementation();
		Applicant applicant = new Applicant();
		
		applicant.setApplicantName(applicantName); // set applicantname  
		applicant.setApplicantSkillSet(applicantSkillSet); //set applicant skillset
		applicant.setApplicantExperience(parseApplicantExperience); // set applicant experience

		// Applicant check According to criteria using this method  also add to database
 		applyService.checkApplicantCriteriaAndAddApplicant(applicant, parsePositionId);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.include(request, response);
		
		out.println("You are successfully Applied");
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
