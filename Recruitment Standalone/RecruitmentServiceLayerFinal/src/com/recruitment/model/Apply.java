package com.recruitment.model;

import java.sql.Date;

/**
 * This class represents relation between applicant and position.
 * Means, a applicant applied for a particular position at a particular date.
 * One applicant can apply for more than one position.
 */
public class Apply {
	public static final String TABLE_APPLY = "applicantapply";
	public static final String COL_APPLICANT_ID = "applicant_id";
	public static final String COL_POSITION_ID = "position_id";
	public static final String COL_DATE_OF_APPLY = "date_of_apply";

	private Applicant applicant;// has-a relation with Applicant
	private Position position; // has-a relation with Position
	private Date dateOfApply; // Applied date for a particular position

	public Apply() {
		super();
	}

	public Apply(Applicant applicant, Position position, Date dateOfApply) {
		super();
		this.applicant = applicant;
		this.position = position;
		this.dateOfApply = dateOfApply;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getDateOfApply() {
		return dateOfApply;
	}

	public void setDateOfApply(Date dateOfApply) {
		this.dateOfApply = dateOfApply;
	}

	@Override
	public String toString() {
		return "Apply [applicant=" + applicant + ", position=" + position
				+ ", dateOfApply=" + dateOfApply + "]";
	}
	
}
