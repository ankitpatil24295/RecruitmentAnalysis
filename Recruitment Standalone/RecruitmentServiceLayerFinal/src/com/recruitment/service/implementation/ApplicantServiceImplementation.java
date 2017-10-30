package com.recruitment.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daoimplementation.ApplicantDAOImplementation;
import com.recruitment.daointerface.ApplicantDAOInterface;
import com.recruitment.model.Applicant;
import com.recruitment.service.ApplicantService;

/**
 * This class is a service layer implementation of Applicant.
 * 
 */
public class ApplicantServiceImplementation implements ApplicantService {

	Logger logger =Logger.getLogger(PositionServiceImplementation.class); //Logger Object
	
	ApplicantDAOInterface applicantDaoInterface = new ApplicantDAOImplementation();

	@Override
	public Applicant addApplicant(Applicant applicant) {
		return applicantDaoInterface.addApplicant(applicant);
	}

	@Override
	public Applicant getApplicant(int appId) {
		return applicantDaoInterface.getApplicant(appId);
	}

	@Override
	public List<Applicant> getApplicants() {
		return applicantDaoInterface.getApplicants();
	}

	@Override
	public boolean updateApplicant(Applicant applicant) {
		return applicantDaoInterface.updateApplicant(applicant);
	}

	@Override
	public Applicant deleteApplicant(int appId) {
		return applicantDaoInterface.deleteApplicant(appId);
	}

}
