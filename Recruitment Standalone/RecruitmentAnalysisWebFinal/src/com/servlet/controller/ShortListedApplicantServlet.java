package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Interview;
import com.recruitment.service.InterviewService;
import com.recruitment.service.implementation.InterviewServiceImplementation;

/**
 * Servlet implementation class ShortListedApplicantServlet
 * This servlet is used to give all shortlisted applicants.
 */
@WebServlet("/ShortListedApplicantServlet")
public class ShortListedApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShortListedApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }//ShortListedApplicantServlet()

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InterviewService interviewService=new InterviewServiceImplementation();
		//fetch all shortlisted applicants
		List<Interview> getshortlistedApplicant = interviewService.getshortlistedApplicant();
		
		request.setAttribute("getshortlistedApplicant",getshortlistedApplicant);
		
		//After redirecting, displays list of all shortlisted applicants
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("ShortListedApplicant.jsp");
		requestDispatcher.forward(request, response);
	}//doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost()

}
