package com.recruitment.model;

import java.sql.Date;

/**
 * This class represents interview result and joining status. On joining, the
 * status in Position class is reflected back.
 */
public class Interview {
	public static final String TABLE_INTERVIEW = "interview";
	public static final String COL_POSITION_ID = "position_id";
	public static final String COL_APPLICANT_ID = "applicant_id";
	public static final String COL_DATE_OF_INTERVIEW = "date_of_interview";
	public static final String COL_CANDIDATE_RESULT = "candidate_result";
	public static final String COL_DATE_OF_JOINING = "date_of_joining";
	public static final String COL_JOINING_STATUS = "joining_status";

	private Position position; // has-a relation with position
	private Applicant applicant; // has-a relation with applicant
	private Date dateOfInterview; // Date of interview
	private boolean candidateResult;// Result of candidate....i.e-->short
									// listed(true) or not(false)
	private Date dateOfJoining; // Joining date of applicant
	private boolean joiningStatus; // Applicant status of joining....i.e true or
									// false

	public Interview() {
		super();
	}

	public Interview(Position position, Applicant applicant,
			Date dateOfInterview, boolean candidateResult, Date dateOfJoining,
			boolean joiningStatus) {
		super();
		this.position = position;
		this.applicant = applicant;
		this.dateOfInterview = dateOfInterview;
		this.candidateResult = candidateResult;
		this.dateOfJoining = dateOfJoining;
		this.joiningStatus = joiningStatus;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Date getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	public boolean isCandidateResult() {
		return candidateResult;
	}

	public void setCandidateResult(boolean candidateResult) {
		this.candidateResult = candidateResult;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isJoiningStatus() {
		return joiningStatus;
	}

	public void setJoiningStatus(boolean joiningStatus) {
		this.joiningStatus = joiningStatus;
	}

	@Override
	public String toString() {
		return "Interview [position=" + position + ", applicant=" + applicant
				+ ", dateOfInterview=" + dateOfInterview + ", candidateResult="
				+ candidateResult + ", dateOfJoining=" + dateOfJoining
				+ ", joiningStatus=" + joiningStatus + "]";
	}

}