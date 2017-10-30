package com.recruitment.service.implementation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daoimplementation.ApplyDAOImplementation;
import com.recruitment.daointerface.ApplyDAOInterface;
import com.recruitment.model.Applicant;
import com.recruitment.model.Apply;
import com.recruitment.model.Position;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.ApplyService;
import com.recruitment.service.PositionService;

/**
 * This class is a service layer implementation of Apply. Does not support
 * update and delete operations.
 */
public class ApplyServiceImplementation implements ApplyService {

	Logger logger= Logger
			.getLogger(PositionServiceImplementation.class);	//Logger Object

	ApplyDAOInterface applyDAOInterface = new ApplyDAOImplementation();
	ApplicantService applicantInterface = new ApplicantServiceImplementation();
	PositionService positionService = new PositionServiceImplementation();

	@Override
	public Apply addApply(Apply apply) {
		return applyDAOInterface.addApply(apply);
	}

	@Override
	public Apply getApply(int applyId, int positionId) {
		return applyDAOInterface.getApply(applyId, positionId);
	}

	@Override
	public List<Apply> getApplies() {
		return applyDAOInterface.getApplies();
	}

	@Override
	public void checkApplicantCriteriaAndAddApplicant(Applicant applicant, int positionId) {
		logger.debug("Start");

		List<Applicant> applicants = applicantInterface.getApplicants();

		if (applicants.isEmpty()) {
			applicantInterface.addApplicant(applicant);
		}

		List<Applicant> applicants2 = applicantInterface.getApplicants();

		boolean status = false;

		for (Applicant applicant2 : applicants2) {
			if (applicant2.getApplicantName().equalsIgnoreCase(
					applicant.getApplicantName())) {
				int applicantId = applicant2.getApplicantId();
				checkExperience(applicantId, positionId);
				status = false;
				break;
			} else {
				status = true;
			}
		}
		if (status) {
			applicantInterface.addApplicant(applicant); // Add Applicant after
														// clicking on submit
														// button

			int applicantId = 0;
			List<Applicant> applicants3 = applicantInterface.getApplicants();
			for (Applicant applicant2 : applicants3) {
				applicantId = applicant2.getApplicantId();
			}
			checkExperience(applicantId, positionId);
		}

		logger.debug("END");
	}

	/**
	 * This method verifies the applicant experience with position experience .
	 * If applicant experience is greater or equals to position experience then
	 * only applicant is applied to a particular position.
	 * 
	 * @param applicantId
	 * @param positionId
	 */
	public void checkExperience(int applicantId, int positionId) {
		logger.debug("Start");

		Applicant applicantFinal = applicantInterface.getApplicant(applicantId);

		double applicantExperience = applicantFinal.getApplicantExperience();

		Position position = positionService.getPosition(positionId);
		double positionExperience = position.getPositionExperience();

		if (applicantExperience >= positionExperience) {
			applyApplicant(applicantFinal, positionId);
		} else {
			try {
				throw new Exception(
						"Your experience didnot not match to required experience\n Can not apply for this position");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.debug("END");

	}

	@Override
	public void applyApplicant(Applicant applicant, int positionId) {
		logger.debug("Start");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String format = dateFormat.format(date);

		Date finalDate = null;
		java.sql.Date sqlFinalDate = null;
		try { // To get Current Date and
			finalDate = dateFormat.parse(format); // store it in database.
			sqlFinalDate = new java.sql.Date(finalDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		PositionService positionInterface = new PositionServiceImplementation();
		Position position = positionInterface.getPosition(positionId);

		Apply apply = new Apply();
		apply.setApplicant(applicant);
		apply.setPosition(position);
		apply.setDateOfApply(sqlFinalDate);

		ApplyService applyService = new ApplyServiceImplementation();
		applyService.addApply(apply);
		logger.debug("END");

	}

	@Override
	public List<Apply> displayAppliedApplicants() {
		logger.debug("Start");

		ApplicantService applicantService = new ApplicantServiceImplementation();

		PositionService positionService = new PositionServiceImplementation();

		ApplyService applyService = new ApplyServiceImplementation();
		List<Apply> listapply = applyService.getApplies();

		List<Apply> displayList = new ArrayList<Apply>();
		for (Apply apply : listapply) {
			int applicantId = apply.getApplicant().getApplicantId();
			int positionId = apply.getPosition().getPositionId();

			Applicant applicant = applicantService.getApplicant(applicantId);
			Position position = positionService.getPosition(positionId);

			apply.setApplicant(applicant);
			apply.setPosition(position);

			displayList.add(apply);

		}
		logger.debug("END");

		return displayList;
	}
}
