package com.recruitment.daoimplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daointerface.ApplyDAOInterface;
import com.recruitment.dbconnection.DBConnection;
import com.recruitment.model.Applicant;
import com.recruitment.model.Apply;
import com.recruitment.model.Position;

/**
 * ApplyDAO class interacts with apply table in database.{@link Apply}
 * 
 */
public class ApplyDAOImplementation implements ApplyDAOInterface {
	Logger logger = Logger.getLogger(HrDAOImplementation.class);//Logger Object
	private static Connection connection = DBConnection.getConnection(); // connection
	// object

	// add applied data in apply table
	private static String addQuery = "INSERT INTO " + Apply.TABLE_APPLY + "("
			+ Apply.COL_APPLICANT_ID + "," + "" + Apply.COL_POSITION_ID + ","
			+ Apply.COL_DATE_OF_APPLY + ") VALUES(?,?,?)";

	// List all data of apply table
	private static String searchQuery = "SELECT * FROM " + Apply.TABLE_APPLY;

	// List data on the basis of applicant id and position id
	private static String searchQueryOne = "SELECT * FROM " + Apply.TABLE_APPLY
			+ " WHERE " + Apply.COL_APPLICANT_ID + " =? AND "
			+ Apply.COL_POSITION_ID + " =?";

	// delete data from table on the basis of applicant id and position id
	private static String deleteQuery = "delete from " + Apply.TABLE_APPLY
			+ " where" + " " + Apply.COL_APPLICANT_ID + " =? AND "
			+ Apply.COL_POSITION_ID + " =?";

	/**
	 * {@code addApply()} add the Apply object in applicantapply table in
	 * database
	 * 
	 * @param apply
	 * @return
	 */
	@Override
	public Apply addApply(Apply apply) {
		logger.debug("START");
		try {
			PreparedStatement pstat = connection.prepareStatement(addQuery);
			pstat.setInt(1, apply.getApplicant().getApplicantId());
			pstat.setInt(2, apply.getPosition().getPositionId());
			pstat.setDate(3, apply.getDateOfApply());

			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.debug("END");
		return apply;
	}

	/**
	 * {@code getHr()} retrieves a single Apply object from applicantapply table
	 * on the basis of applyId and positionId
	 * 
	 * @param applyId
	 * @param positionId
	 * @return
	 */
	@Override
	public Apply getApply(int applyId, int positionId) {
		logger.debug("START");
		try {
			PreparedStatement pstat = connection
					.prepareStatement(searchQueryOne);
			pstat.setInt(1, applyId);
			pstat.setInt(2, positionId);
			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {
				int applicantid = resultSet.getInt(1);
				int postId = resultSet.getInt(2);
				Date applyDate = resultSet.getDate(3);

				Applicant applicant = new Applicant();
				applicant.setApplicantId(applicantid);

				Position position = new Position();
				position.setPositionId(postId);
				Apply apply = new Apply(applicant, position, applyDate);
				logger.debug("END");
				return apply;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.debug("Return NULL");
		return null;
	}

	/**
	 * {@code getApplies()} retrieves all applies from applicantapply table
	 * 
	 * @return
	 */
	@Override
	public List<Apply> getApplies() {
		logger.debug("START");
		List<Apply> applyList = new ArrayList<Apply>();
		try {
			PreparedStatement pstat = connection.prepareStatement(searchQuery);

			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {
				int applicantid = resultSet.getInt(1);
				int postId = resultSet.getInt(2);
				Date applyDate = resultSet.getDate(3);

				Applicant applicant = new Applicant();
				applicant.setApplicantId(applicantid);

				Position position = new Position();
				position.setPositionId(postId);
				Apply apply = new Apply(applicant, position, applyDate);

				applyList.add(apply);
			}
			logger.debug("END");
			return applyList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * {@code deleteApply()}delete each apply from applicant apply table
	 * 
	 * @param applyId
	 * @param positionId
	 * @return
	 */
	@Override
	public Apply deleteApply(int applyId, int positionId) {
		logger.debug("START");
		try {
			Apply applyFromDb = getApply(applyId, positionId);
			PreparedStatement pstat = connection.prepareStatement(deleteQuery);
			pstat.setInt(1, applyId);
			pstat.setInt(2, positionId);
			logger.debug(pstat.toString());
			int rowUpdated = pstat.executeUpdate();
			
			if (rowUpdated == 1) {
				return applyFromDb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("END");
		return null;
	}
}
