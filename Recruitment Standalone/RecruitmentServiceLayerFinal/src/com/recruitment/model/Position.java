package com.recruitment.model;

import java.sql.Date;

/**
 * This class represents Position posted by human resource.
 * 
 */
public class Position {
	public static final String TABLE_POSITION = "post";
	public static final String COL_POSITION_ID = "position_id";
	public static final String COL_HR_ID = "hr_id";
	public static final String COL_POSITION_NAME = "position_name";
	public static final String COL_NO_OF_POSITION = "no_of_position";
	public static final String COL_POSITION_EXPERIENCE = "experience_required";
	public static final String COL_POSITION_DATE = "position_post_date";
	public static final String COL_POSITION_STATUS = "position_status";

	private int positionId; // Unique Id assigned to each position
	private Hr hr; // has-a relation with human resource
	private String positionName; // Name of position posted
	private int noOfPosition; // Number of position required
	private double positionExperience; // Experience required for particular
										// position
	private Date positionPostDate; // Position posted Date
	private boolean positionStatus; // Position Status ....i.e-->OPEN (OR)
									// CLOSED

	public Position() {
		super();
	}

	public Position(int positionId, Hr hr, String positionName,
			int noOfPosition, double positionExperience, Date positionPostDate,
			boolean positionStatus) {
		super();
		this.positionId = positionId;
		this.hr = hr;
		this.positionName = positionName;
		this.noOfPosition = noOfPosition;
		this.positionExperience = positionExperience;
		this.positionPostDate = positionPostDate;
		this.positionStatus = positionStatus;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public Hr getHr() {
		return hr;
	}

	public void setHr(Hr hr) {
		this.hr = hr;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getNoOfPosition() {
		return noOfPosition;
	}

	public void setNoOfPosition(int noOfPosition) {
		this.noOfPosition = noOfPosition;
	}

	public double getPositionExperience() {
		return positionExperience;
	}

	public void setPositionExperience(double positionExperience) {
		this.positionExperience = positionExperience;
	}

	public Date getPositionPostDate() {
		return positionPostDate;
	}

	public void setPositionPostDate(Date positionPostDate) {
		this.positionPostDate = positionPostDate;
	}

	public boolean isPositionStatus() {
		return positionStatus;
	}

	public void setPositionStatus(boolean positionStatus) {
		this.positionStatus = positionStatus;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", hr=" + hr
				+ ", positionName=" + positionName + ", noOfPosition="
				+ noOfPosition + ", positionExperience=" + positionExperience
				+ ", positionPostDate=" + positionPostDate
				+ ", positionStatus=" + positionStatus + "]";
	}

}