package com.recruitment.daointerface;

import java.util.List;

import com.recruitment.model.Applicant;

public interface ApplicantDAOInterface {
	public Applicant addApplicant(Applicant applicant);

	public Applicant getApplicant(int applicantId);

	public List<Applicant> getApplicants();

	public boolean updateApplicant(Applicant applicant);

	public Applicant deleteApplicant(int applicantId);
}
