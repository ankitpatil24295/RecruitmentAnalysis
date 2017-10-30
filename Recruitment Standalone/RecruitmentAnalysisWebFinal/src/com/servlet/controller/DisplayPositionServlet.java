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
 * Servlet implementation class DisplayPositionServlet
 * HR can see the opened position 
 */
@WebServlet("/DisplayPositionServlet")
public class DisplayPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPositionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().getAttribute("name");//Fetch hr name to set session
		 
		PositionService ps= new PositionServiceImplementation();
		List<Position> listPositions = ps.getPositions(); //get all the positions
		
		//set list of positions to the session
		request.getSession().setAttribute("positionList",listPositions);
		
		//After redirecting, Displays list of open positions
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayPosition.jsp"); 
		requestDispatcher.forward(request, response);
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
