package com.recruitment.daoimplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daointerface.InterviewDAOInterface;
import com.recruitment.dbconnection.DBConnection;
import com.recruitment.model.Applicant;
import com.recruitment.model.Interview;
import com.recruitment.model.Position;

/**
 * InterviewDAO class interacts with Interview table in database.
 * {@link Interview}
 * 
 */
public class InterviewDAOImplementation implements InterviewDAOInterface {
 Logger logger = Logger.getLogger(HrDAOImplementation.class);//Logger Object
	private static Connection connection = DBConnection.getConnection(); // connection
																			// object

	// add interview data in interview table
	private static String addQuery = "INSERT INTO " + Interview.TABLE_INTERVIEW
			+ "(" + Interview.COL_APPLICANT_ID + ","
			+ Interview.COL_POSITION_ID + "," + Interview.COL_DATE_OF_INTERVIEW
			+ "," + Interview.COL_CANDIDATE_RESULT + ","
			+ Interview.COL_DATE_OF_JOINING + ","
			+ Interview.COL_JOINING_STATUS + ") VALUES(?,?,?,?,?,?)";

	// List all data of hr table
	private static String searchQuery = "SELECT * FROM "
			+ Interview.TABLE_INTERVIEW;

	// List data on the basis of hr id
	private static String searchQueryOne = "SELECT * FROM "
			+ Interview.TABLE_INTERVIEW + " WHERE "
			+ Interview.COL_APPLICANT_ID + " =? AND "
			+ Interview.COL_POSITION_ID + " =?";

	// update data in table on the basis of hr id
	private static String updateQuery = "UPDATE " + Interview.TABLE_INTERVIEW
			+ " SET " + Interview.COL_DATE_OF_INTERVIEW + " =?" + ","
			+ Interview.COL_CANDIDATE_RESULT + " =?,"
			+ Interview.COL_DATE_OF_JOINING + "=?,"
			+ Interview.COL_JOINING_STATUS + "=?  where "
			+ Interview.COL_APPLICANT_ID + " =? AND "
			+ Interview.COL_POSITION_ID + "=?";

	// delete data from table on the basis of hr id
	private static String deleteQuery = "delete from "
			+ Interview.TABLE_INTERVIEW + " where" + " "
			+ Interview.COL_APPLICANT_ID + " =? AND "
			+ Interview.COL_POSITION_ID + "=?";

	/**
	 * {@code addInterview()} add the Interview object in interview table in
	 * database
	 * 
	 * @param interview
	 * @return
	 */
	@Override
	public Interview addInterview(Interview interview) {
		logger.debug("START");
		try {
			PreparedStatement pstat = connection.prepareStatement(addQuery);
			pstat.setInt(1, interview.getApplicant().getApplicantId());
			pstat.setInt(2, interview.getPosition().getPositionId());
			pstat.setDate(3, interview.getDateOfInterview());
			pstat.setBoolean(4, interview.isCandidateResult());
			pstat.setDate(5, interview.getDateOfJoining());
			pstat.setBoolean(6, interview.isJoiningStatus());

			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.debug("END");
		return interview;
	}

	/**
	 * {@code getInterview()} retrieves a single Interview from interview table
	 * on the basis of interviewId
	 * 
	 * @param applicantId
	 * @param positionId
	 * @return
	 */
	@Override
	public Interview getInterview(int applicantId, int positionId) {
		logger.info(searchQueryOne);
		logger.debug("START");
		try {
			PreparedStatement pstat = connection
					.prepareStatement(searchQueryOne);
			pstat.setInt(1, applicantId);
			pstat.setInt(2, positionId);
			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {
				int applicantid = resultSet.getInt(1);
				int postId = resultSet.getInt(2);
				Date interviewDate = resultSet.getDate(3);
				boolean candidateResult = resultSet.getBoolean(4);
				Date joiningDate = resultSet.getDate(5);
				boolean joiningStatus = resultSet.getBoolean(6);

				Applicant applicant = new Applicant();
				applicant.setApplicantId(applicantid);

				Position position = new Position();
				position.setPositionId(postId);

				Interview interview = new Interview(position, applicant,
						interviewDate, candidateResult, joiningDate,
						joiningStatus);
				logger.debug("END");
				return interview;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.debug("Return NULL");
		return null;
	}

	/**
	 * {@code getInterviews()} retrieves all Interview from interview table
	 * 
	 * @return
	 */
	@Override
	public List<Interview> getInterviews() {
		logger.debug("START");
		List<Interview> interviewList = new ArrayList<Interview>();
		try {
			PreparedStatement pstat = connection.prepareStatement(searchQuery);

			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {
				int applicantid = resultSet.getInt(1);
				int postId = resultSet.getInt(2);
				Date interviewDate = resultSet.getDate(3);
				boolean candidateResult = resultSet.getBoolean(4);
				Date joiningDate = resultSet.getDate(5);
				boolean joiningStatus = resultSet.getBoolean(6);

				Applicant applicant = new Applicant();
				applicant.setApplicantId(applicantid);

				Position position = new Position();
				position.setPositionId(postId);

				Interview interview = new Interview(position, applicant,
						interviewDate, candidateResult, joiningDate,
						joiningStatus);

				interviewList.add(interview);
			}
			logger.debug("END");
			return interviewList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * {@code updateInterview()} Updates each attribute in the interview table
	 * 
	 * @param interview
	 * @return
	 */
	@Override
	public boolean updateInterview(Interview interview) {
		logger.debug(updateQuery);
		logger.debug("START");
		try {
			PreparedStatement pstat = connection.prepareStatement(updateQuery);

			Interview interviewInDB = new InterviewDAOImplementation()
					.getInterview(interview.getApplicant().getApplicantId(),
							interview.getPosition().getPositionId());
			
			if (interview.getDateOfInterview() == null)
				interview.setDateOfInterview(interviewInDB.getDateOfInterview());

			if (interview.getDateOfJoining() == null)
				interview.setDateOfJoining(interviewInDB.getDateOfJoining());
		
			logger.debug(interview.isJoiningStatus());
			
			pstat.setDate(1, interview.getDateOfInterview());
			pstat.setBoolean(2, interview.isCandidateResult());
			pstat.setDate(3, interview.getDateOfJoining());
			pstat.setBoolean(4, interview.isJoiningStatus());
			pstat.setInt(5, interview.getApplicant().getApplicantId());
			pstat.setInt(6, interview.getPosition().getPositionId());
			
			logger.debug(pstat.toString());

			int resultUpdate = pstat.executeUpdate();

			if (resultUpdate == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("END");
		return false;
	}

	/**
	 * {@code deleteInterview()}delete each Interview from interview table
	 * 
	 * @param applicantId
	 * @param positionId
	 * @return
	 */
	@Override
	public Interview deleteInterview(int applicantId, int positionId) {
		logger.debug("START");
		try {
			Interview interviewFromDb = getInterview(applicantId, positionId);
			PreparedStatement pstat = connection.prepareStatement(deleteQuery);
			pstat.setInt(1, applicantId);
			pstat.setInt(2, positionId);
			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 1) {
				return interviewFromDb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("END");
		return null;
	}
	
}
