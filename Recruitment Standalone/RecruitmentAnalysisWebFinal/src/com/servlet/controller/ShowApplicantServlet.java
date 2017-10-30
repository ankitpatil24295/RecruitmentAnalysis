package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Applicant;
import com.recruitment.model.Apply;
import com.recruitment.model.Position;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.ApplyService;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.ApplicantServiceImplementation;
import com.recruitment.service.implementation.ApplyServiceImplementation;
import com.recruitment.service.implementation.PositionServiceImplementation;

/**
 * Servlet implementation class ShowApplicantServlet
 * This servlet is used to display all applied applicants for particular position.
 */
@WebServlet("/ShowApplicantServlet")
public class ShowApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowApplicantServlet() {
        super();
    }//ShowApplicantServlet()

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		ApplyService applyService=new ApplyServiceImplementation();
		//get details of all applied appliacants
		List<Apply> displayAppliedApplicants = applyService.displayAppliedApplicants();
	   
		request.setAttribute("displayAppliedApplicants",displayAppliedApplicants);
		
		//After redirecting, displays all applicant details
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("AppliedApplicantShow.jsp");
		requestDispatcher.forward(request, response);
	}//doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
