package com.recruitment.model;

/**
 * This class contains information about human resource.
 */
public class Hr {
	public static final String TABLE_HR = "hr";
	public static final String COL_HR_ID = "hr_id";
	public static final String COL_HR_NAME = "hr_name";
	public static final String COL_HR_DEPARTMENT = "hr_department";
	public static final String COL_HR_CONTACT = "hr_contact";
	public static final String COL_HR_PASSWORD = "hr_password";

	private int hrId; // Unique Id for each human resource
	private String hrName; // Name of human resource
	private String hrPassword;// password of human resource to login into
								// system.
	private String hrDepartment;// Department of human resource
	// ....i.e-->experienced,freshers.

	private String hrContact; // contact number of human resource.

	public Hr() {
		super();
	}

	public Hr(int hrId, String hrName, String hrPassword, String hrDepartment,
			String hrContact) {
		super();
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrPassword = hrPassword;
		this.hrDepartment = hrDepartment;
		this.hrContact = hrContact;
	}

	public int getHrId() {
		return hrId;
	}

	public void setHrId(int hrId) {
		this.hrId = hrId;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrDepartment() {
		return hrDepartment;
	}

	public void setHrDepartment(String hrDepartment) {
		this.hrDepartment = hrDepartment;
	}

	public String getHrContact() {
		return hrContact;
	}

	public void setHrContact(String hrContact) {
		this.hrContact = hrContact;
	}

	public String getHrPassword() {
		return hrPassword;
	}

	public void setHrPassword(String hrPassword) {
		this.hrPassword = hrPassword;
	}

	@Override
	public String toString() {
		return "Hr [hrId=" + hrId + ", hrName=" + hrName + ", hrDepartment="
				+ hrDepartment + ", hrContact=" + hrContact + ", hrPassword="
				+ hrPassword + "]";
	}
}
