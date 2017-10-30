package com.recruitment.testcases;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;

import com.recruitment.model.Interview;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.InterviewService;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.ApplicantServiceImplementation;
import com.recruitment.service.implementation.InterviewServiceImplementation;
import com.recruitment.service.implementation.PositionServiceImplementation;

/*
 * This Test class of Hr, tests add Hr, get Hr and get list of Hrs methods only.
 * This is not for testing update and delete functionality of Applicant services.
 */
public class InterviewTest {

	InterviewService interviewService = new InterviewServiceImplementation();
	Interview interview = new Interview();
	ApplicantService applicantService = new ApplicantServiceImplementation();
	PositionService positionService = new PositionServiceImplementation();

	@Test
	public void testAddInterview() {
		Interview interview = new Interview();
		interview.setApplicant(applicantService.getApplicant(34));
		interview.setPosition(positionService.getPosition(501));
		Date date = new Date(2017 - 12 - 4);
		System.out.println(date);
		interview.setDateOfInterview(date);
		interview.setCandidateResult(true);
		Date newDate = new Date(2016 - 4 - 3);
		interview.setDateOfJoining(newDate);
		interview.setJoiningStatus(false);
		assertNotNull(interviewService.addInterview(interview));

	}

	@Test
	public void testGetInterview() {

		assertNotNull(interviewService.getInterview(1, 501));
	}

	@Test
	public void testGetAllHrs() {

		assertNotNull(interviewService.getInterviews());
	}

}
