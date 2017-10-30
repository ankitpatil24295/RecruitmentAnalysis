package com.recruitment.daointerface;

import java.util.List;

import com.recruitment.model.Interview;

public interface InterviewDAOInterface {
	public Interview addInterview(Interview interview);

	public Interview getInterview(int applicantId,int positionId);

	public List<Interview> getInterviews();

	public boolean updateInterview(Interview interview);

	public Interview deleteInterview(int applicantId,int positionId);
}
