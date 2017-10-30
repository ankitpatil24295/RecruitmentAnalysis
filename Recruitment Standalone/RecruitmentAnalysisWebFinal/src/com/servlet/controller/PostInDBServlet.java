package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitment.model.Hr;
import com.recruitment.model.Position;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.PositionServiceImplementation;

/**
 * Servlet implementation class PostInDBServlet
 * Newly added position by hr is inserted into database by this servlet.
 */
@WebServlet("/PostInDBServlet")
public class PostInDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostInDBServlet() {
		super();
	}//PostInDBServlet() 

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

        String positonIdReceived = request.getParameter("pid");//fetch position Id 
		int positionId = Integer.parseInt(positonIdReceived);

		String hrIdReceived = request.getParameter("hrid");//fetch hr id
		int hrID = Integer.parseInt(hrIdReceived);
		
		Hr hrObject = new Hr();
		hrObject.setHrId(hrID);//set hrid 

		String positionNameReceived = request.getParameter("pname");//fetch position name
		
		String numberOfPositionReceived = request.getParameter("noofpos");//fetch number of openings
		int noOfPosition = Integer.parseInt(numberOfPositionReceived);

		String experinceReceived = request.getParameter("expreq");//fetch required experience
		double positionExperience = Float.parseFloat(experinceReceived);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String format = dateFormat.format(date);
		Date finalDate = null;//util date
		java.sql.Date positionDate = null;//sql date
		try {
			finalDate = dateFormat.parse(format);
			//Converts util date to sql date
			positionDate = new java.sql.Date(finalDate.getTime());//current system date
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String positionStatusRecieved = request.getParameter("statuspost");
		
		boolean positionStatus = false;
		//Checking status of opening position
		if (positionStatusRecieved.equalsIgnoreCase("open")) {
			positionStatus = true;
			
			Position position = new Position(positionId, hrObject, positionNameReceived, noOfPosition, positionExperience, positionDate,
					positionStatus);
			PositionService positionService = new PositionServiceImplementation();

			//posted positions are added into the database @table position
			positionService.addPosition(position);
			
			//Get back to hr dashboard
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Hrdashboard.jsp");
			requestDispatcher.include(request, response);
			out.print("Successfully added position");
			
		}//if 		
		else{
			//Hr should post open position only, otherwise throws exception
			try {
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddPositionForm.jsp");
				requestDispatcher.include(request, response);
				throw new Exception("Unsupported Exception: Enter POSITION STATUS as OPEN only");
			
			} catch (Exception e) {
				out.print(e);
			}//catch
		}//else


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}//doPost

}
