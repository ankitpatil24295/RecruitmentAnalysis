package com.recruitment.service;

import java.util.List;

import com.recruitment.model.Applicant;
import com.recruitment.model.Apply;

/**
 * Apply service consist of various methods that calls methods in ApplyDAO.
 */
public interface ApplyService {
	/**
	 * This method add Apply data to apply table.
	 * 
	 * @param apply
	 * @return
	 */
	public Apply addApply(Apply apply);

	/**
	 * This method get single Apply data from apply table.
	 * 
	 * @param applyId
	 * @param positionId
	 * @return
	 */
	public Apply getApply(int applyId, int positionId);

	/**
	 * This method get all Apply data from apply table.
	 * 
	 * @return
	 */
	public List<Apply> getApplies();

	/**
	 * This method add Applicant id and position id into apply table.
	 * 
	 * @param applicant
	 * @param positionId
	 */
	public void applyApplicant(Applicant applicant, int positionId);

	/**
	 * This method check Applicant criteria and calls checkExperience() (instance
	 * method of implementation class) to verify that applicant experience should
	 * be greater or equal to applied position experience.
	 * 
	 * @param applicant
	 * @param positionId
	 */
	void checkApplicantCriteriaAndAddApplicant(Applicant applicant,
			int positionId);

	/**
	 * This method displays all applied applicant with applicant names and
	 * position name.
	 * 
	 * @return
	 */
	public List<Apply> displayAppliedApplicants();

}
