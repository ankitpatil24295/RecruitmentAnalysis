package com.recruitment.model;

/**
 * This class contains information related to applicant.
 */
public class Applicant {
	public static final String TABLE_APPLICANT = "applicant";
	public static final String COL_APPLICANT_ID = "applicant_id";
	public static final String COL_APPLICANT_NAME = "applicant_name";
	public static final String COL_APPLICANT_SKILL_SET = "applicant_skill_set";
	public static final String COL_APPLICANT_EXPERIENCE = "applicant_experience";

	private int applicantId; // Unique Id generated for each Applicant
	private String applicantName; // Name of Applicant
	private String applicantSkillSet; // Applicant Specialization
	private double applicantExperience; // Experience of Applicant

	public Applicant() {
		super();
	}

	public Applicant(int applicantId, String applicantName,
			String applicantSkillSet, double applicantExperience) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		this.applicantSkillSet = applicantSkillSet;
		this.applicantExperience = applicantExperience;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantSkillSet() {
		return applicantSkillSet;
	}

	public void setApplicantSkillSet(String applicantSkillSet) {
		this.applicantSkillSet = applicantSkillSet;
	}

	public double getApplicantExperience() {
		return applicantExperience;
	}

	public void setApplicantExperience(double applicantExperience) {
		this.applicantExperience = applicantExperience;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", applicantName="
				+ applicantName + ", applicantSkillSet=" + applicantSkillSet
				+ ", applicantExperience=" + applicantExperience + "]";
	}

}
