package com.recruitment.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daoimplementation.InterviewDAOImplementation;
import com.recruitment.daointerface.InterviewDAOInterface;
import com.recruitment.model.Interview;
import com.recruitment.service.InterviewService;

/**
 * This class is a service layer implementation of Interview.
 */
public class InterviewServiceImplementation implements InterviewService {

	Logger logger =Logger.getLogger(InterviewServiceImplementation.class);	//Logger Object
	InterviewDAOInterface interviewdaointerface = new InterviewDAOImplementation();

	@Override
	public Interview addInterview(Interview interview) {
		Interview interviewobj = null;
		interviewobj = interviewdaointerface.addInterview(interview);
		return interviewobj;
	}

	@Override
	public List<Interview> getInterviews() {
		List<Interview> interviewlist = null;
		interviewlist = interviewdaointerface.getInterviews();
		return interviewlist;
	}

	@Override
	public boolean updateInterview(Interview interview) {
		return interviewdaointerface.updateInterview(interview);
	}

	@Override
	public Interview getInterview(int applicantId, int positionId) {
		Interview interviewobj = null;
		interviewobj = interviewdaointerface.getInterview(applicantId,
				positionId);
		return interviewobj;

	}

	@Override
	public Interview deleteInterview(int applicantId, int positionId) {
		Interview interviewobj = null;
		interviewobj = interviewdaointerface.deleteInterview(applicantId,
		positionId);
		return interviewobj;
	}

	@Override
	public List<Interview> getshortlistedApplicant() {
		logger.debug("Start");

		List<Interview> interviews = interviewdaointerface.getInterviews();
		List<Interview> shortlistApplicant = new ArrayList<Interview>();
		for (Interview interview : interviews) {
			if (interview.isCandidateResult() == true) {
				shortlistApplicant.add(interview);
			}
		}
		logger.debug("End");
		return shortlistApplicant;
	}
	@Override
	public List<Interview> getshortlistedApplicantByJoiningStatus() {
		logger.debug("Start");

		List<Interview> getshortlistedApplicant = getshortlistedApplicant();
		List<Interview> shortlistApplicantByJoiningStatus = new ArrayList<Interview>();
		for (Interview interview : getshortlistedApplicant) {
			if (interview.isJoiningStatus() == true) {
				shortlistApplicantByJoiningStatus.add(interview);
			}
		}

		logger.debug("End");
		return shortlistApplicantByJoiningStatus;
	}

}
