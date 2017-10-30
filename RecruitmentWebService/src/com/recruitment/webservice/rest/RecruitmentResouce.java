package com.recruitment.webservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.recruitment.model.Applicant;
import com.recruitment.model.Position;
import com.recruitment.service.ApplyService;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.ApplyServiceImplementation;
import com.recruitment.service.implementation.PositionServiceImplementation;

/**
 * This class represents Web Service Layer of our project. If someone else want
 * to access our resources or we want to get some resources then we can achieve
 * this with the help of RecruitmentService class.
 *
 * For example, If we have a requirement of 10 java expert and due to some
 * reason we don't have that much applicant applying through our web site then
 * we provide a functionality to third party(that can be either
 * naukari,indeed,shine,placement agency) that provides us applicants applying
 * for different positions.
 */
@Path("/recruitment")
public class RecruitmentResouce {
	PositionService positionService = new PositionServiceImplementation();

	ApplyService applyService=new ApplyServiceImplementation();
	/**
	 * This method return a list of position. This list will be provided to
	 * third party who is consuming this functionality to know what
	 * different position are required by the provider.
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Position> getPositions() {
		return positionService.getPositions();
	}
	
	/**
	 * This method is used to get applicants along with the position they are applying
	 * and add into our databases.
	 * Here we consumes the applicants and position.
	 * @param applicant
	 * @param positionId
	 */
	@POST
	@Path("/{postid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void checkApplicantCriteriaAndAddApplicant(Applicant applicant,@PathParam("postid") int positionId) {
		applyService.checkApplicantCriteria(applicant, positionId);
	}
	
}
