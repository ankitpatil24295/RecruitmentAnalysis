/**
 * 
 */
package com.recruitment.service;

import java.util.List;

import com.recruitment.model.Interview;

/**
 * Interview service consist of various methods that calls methods in
 * InterviewDAO.
 */
public interface InterviewService {
	/**
	 * This method add Interview data to interview table.
	 * @param interview
	 * @return
	 */
	public Interview addInterview(Interview interview);

	/**
	 * This method get all Interview data from interview table.
	 * 
	 * @return
	 */
	public List<Interview> getInterviews();

	/**
	 * This method update interview table by passing Interview Object as
	 * parameter.
	 * 
	 * @param interview
	 * @return
	 */
	public boolean updateInterview(Interview interview);

	/**
	 * This method get single interview data from interview table.
	 * 
	 * @param applicantId
	 * @param positionId
	 * @return
	 */
	Interview getInterview(int applicantId, int positionId);

	/**
	 * This method delete the record on the basis of parameters passed.
	 * @param applicantId
	 * @param positionId
	 * @return
	 */
	Interview deleteInterview(int applicantId, int positionId);

	/**
	 * This method returns a List of short listed applicant on the basis of
	 * Applicant result i.e only Selected. Only selected applicants will be
	 * contained in the return list.
	 * @return
	 */
	public List<Interview> getshortlistedApplicant();

	/**
	 * This method returns a List of short listed applicant on the basis of
	 * Applicant result i.e ( only Selected) as well as its joining status i.e(only Joined).
	 * @return
	 */
	public List<Interview> getshortlistedApplicantByJoiningStatus();
}
