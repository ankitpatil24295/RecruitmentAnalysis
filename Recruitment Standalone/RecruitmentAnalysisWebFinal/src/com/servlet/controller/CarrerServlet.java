package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Position;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.PositionServiceImplementation;

/**
 * Servlet implementation class CarrerServlet
 * Opeinings posted by hr are displayed and applicant can able to apply for the same.
 */
@WebServlet("/CarrerServlet")
public class CarrerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarrerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}//CarrerServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PositionService positionService = new PositionServiceImplementation();
		List<Position> listPosition = positionService.getPositions(); //get list of open positions, posted by Hr.
		request.setAttribute("positionList", listPosition);
	
		//Redirects to career page, showing opening details where new applicant can apply for open position.
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CarrerPositionOpening.jsp");
		requestDispatcher.forward(request, response);

	}//doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}//doPost()

}
