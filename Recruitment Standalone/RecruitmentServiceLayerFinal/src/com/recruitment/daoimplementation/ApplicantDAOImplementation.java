package com.recruitment.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daointerface.ApplicantDAOInterface;
import com.recruitment.dbconnection.DBConnection;
import com.recruitment.model.Applicant;

/**
 * ApplicantImplementation class interacts with Applicant table in database.
 * {@link Applicant}
 * 
 */
public class ApplicantDAOImplementation implements ApplicantDAOInterface {

	public Logger logger = Logger
			.getLogger(ApplicantDAOImplementation.class);//Logger Object

	private Connection connection = DBConnection.getConnection(); // get
																	// connection
																	// to JDBC
																	// (My SQL)
	public static String addQuery = "Insert into " + Applicant.TABLE_APPLICANT + " ("
			+ Applicant.COL_APPLICANT_NAME + "," + Applicant.COL_APPLICANT_SKILL_SET + ","
			+ Applicant.COL_APPLICANT_EXPERIENCE + ") " + " values (?,?,?)";
	public static String searchQuery = "select * from " + Applicant.TABLE_APPLICANT;
	public static String searchQueryOne = "select * from " + Applicant.TABLE_APPLICANT
			+ " where " + Applicant.COL_APPLICANT_ID + " = ?";
	private static String updateQuery = "UPDATE " + Applicant.TABLE_APPLICANT + " SET  "
			+ Applicant.COL_APPLICANT_NAME + " = ?, " + Applicant.COL_APPLICANT_SKILL_SET + " =?, "
			+ Applicant.COL_APPLICANT_EXPERIENCE + " =? " + " where " + Applicant.COL_APPLICANT_ID
			+ " =?";
	private static String deleteQuery = "Delete from  " + Applicant.TABLE_APPLICANT
			+ " where " + Applicant.COL_APPLICANT_ID + " = ?";

	/**
	 * This method adds new applicant in the Applicant table in database.
	 * {@code addApplicant}
	 * 
	 * @param Applicant
	 *            object
	 * @return applicant (newly added applicant)
	 * @exception NullPointerException if connection is not found
	 * @exception SQLException if query fired is wrong
	 */
	@Override
	public Applicant addApplicant(Applicant applicant) {
		logger.debug("START");
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(addQuery);
			statement.setString(1, applicant.getApplicantName());
			statement.setString(2, applicant.getApplicantSkillSet());
			statement.setDouble(3, applicant.getApplicantExperience());
			int upateCount = statement.executeUpdate(); // Execute query
			if (upateCount == 0)
				return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		logger.debug("STOP");
		return applicant;
	}// addApplicant()

	/**
	 * This method retrieves single applicant from Applicant table
	 * 
	 * @param Applicatant id
	 * @return Applicant object
	 * @exception NullPointerException if applicant Id is wrong (i.e. does not exists in table).
	 */
	@Override
	public Applicant getApplicant(int applicantId) {
		logger.debug("START");
		Applicant newApplicant = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(searchQueryOne);
			statement.setInt(1, applicantId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString(2);
				String skill = resultSet.getString(3);
				double experience = resultSet.getDouble(4);
				Applicant candidate = new Applicant(applicantId, name, skill,
						experience);
				return candidate;

			}// while
		} catch (SQLException e) {
			e.printStackTrace();
		}// catch
		logger.debug("STOP");
		return newApplicant;
	}// getApplicant()

	/**
	 * This method retrieves all applicants from Applicant table
	 * 
	 * @return List<Applicant>
	 * @exception SQLException if query is wrong.
	 */
	@Override
	public List<Applicant> getApplicants() {
		logger.debug("START");
		List<Applicant> applicants = new ArrayList<Applicant>();
		connection = DBConnection.getConnection();
		try {
			PreparedStatement pps = connection.prepareStatement(searchQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String skill = resultSet.getString(3);
				double experience = resultSet.getDouble(4);
				Applicant applicant = new Applicant(id, name, skill, experience);
				applicants.add(applicant);
			}// while
			return applicants;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("STOP");
		return applicants;
	}// getApplicants

	/**
	 * This method updates applicant from Applicant table
	 * 
	 * @param Applicatant object
	 * @return true if row is updated else returns false
	 * @exception NullPointerException if applicant is null.
	 */
	@Override
	public boolean updateApplicant(Applicant applicant) {
		try {
			logger.debug("START");
			PreparedStatement statement = connection
					.prepareStatement(updateQuery);

			Applicant newApplicant = new ApplicantDAOImplementation()
					.getApplicant(applicant.getApplicantId());

			if (applicant.getApplicantName() == null)
				applicant.setApplicantName(newApplicant.getApplicantName());

			if (applicant.getApplicantSkillSet() == null)
				applicant.setApplicantSkillSet(newApplicant
						.getApplicantSkillSet());

			if (applicant.getApplicantExperience() == 0.0)
				applicant.setApplicantExperience(newApplicant
						.getApplicantExperience());

			statement.setString(1, applicant.getApplicantName());
			statement.setString(2, applicant.getApplicantSkillSet());
			statement.setDouble(3, applicant.getApplicantExperience());
			statement.setInt(4, applicant.getApplicantId());
			int roUpdated = statement.executeUpdate();
			if (roUpdated == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}// catch
		logger.debug("STOP");
		return false;
	}// updateApplicant()

	/**
	 * This method delete single applicant from Applicant table
	 * 
	 * @param Applicatant id
	 * @exception NullPointerException if applicantId is not exists or already deleted
	 */
	@Override
	public Applicant deleteApplicant(int applicantId) {
		logger.debug("START");
		try {
			Applicant appFromDb = getApplicant(applicantId);
			PreparedStatement statement = connection.prepareCall(deleteQuery);
			statement.setInt(1, applicantId);
			int rowUpdates = statement.executeUpdate();
			if (rowUpdates == 1) {
				return appFromDb;
			}//if
			return null;
		} catch (SQLException e) {

			e.printStackTrace();
		}//catch
		logger.debug("STOP");
		return null;
	}//deleteApplicant
}//ApplicantDAOImplementation class