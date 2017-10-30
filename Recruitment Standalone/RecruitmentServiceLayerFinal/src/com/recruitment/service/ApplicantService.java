package com.recruitment.service;

import java.util.List;

import com.recruitment.model.Applicant;
/**
 * Applicant service consist of various methods that calls methods in ApplicantDAO.
 */
public interface ApplicantService {
	/**
	 * This method add Applicant data to applicant table.
	 * @param applicant
	 * @return
	 */
	public Applicant addApplicant(Applicant applicant);
	/**
	 * This method get applicant details as per applicantId from applicant table.
	 * @param applicnat Id
	 * @return applicant
	 */
	public Applicant getApplicant(int appId);
	/**
	 * This method get all Applicant data from applicant table.
	 * @return
	 */
	public List<Applicant> getApplicants();
	/**
	 * This method update applicant table by passing applicant Object as
	 * parameter.
	 * 
	 * @param applicant
	 * @return 
	 */
	public boolean updateApplicant(Applicant applicant);
	/**
	 * This method delete the record on the basis of parameters passed (Applicant Id).
	 * @param applicantId
	 * @return
	 */
	public Applicant deleteApplicant(int appId);

}
