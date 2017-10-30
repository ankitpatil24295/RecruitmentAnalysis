package com.recruitment.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daointerface.HrDAOInterface;
import com.recruitment.dbconnection.DBConnection;
import com.recruitment.model.Hr;

/**
 * HrDAO class interacts with Human Resource(hr) table in database.{@link Hr}
 * 
 */
public class HrDAOImplementation implements HrDAOInterface {
	static Logger logger = Logger.getLogger(HrDAOImplementation.class);//Logger Object
	private static Connection connection = DBConnection.getConnection(); // connection
																			// object

	// add human resource data in hr table
	private static String addQuery = "INSERT INTO " + Hr.TABLE_HR + "("
			+ Hr.COL_HR_ID + "," + "" + Hr.COL_HR_NAME + ","
			+ Hr.COL_HR_PASSWORD + "," + Hr.COL_HR_DEPARTMENT + "" + ","
			+ Hr.COL_HR_CONTACT + ") VALUES(?,?,?,?,?)";

	// List all data of hr table
	private static String searchQuery = "SELECT * FROM " + Hr.TABLE_HR;

	// List data on the basis of hr id
	private static String searchQueryOne = "SELECT * FROM " + Hr.TABLE_HR
			+ " WHERE " + "" + Hr.COL_HR_ID + " =?";

	// update data in table on the basis of hr id
	private static String updateQuery = "UPDATE " + Hr.TABLE_HR + " SET "
			+ Hr.COL_HR_NAME + " =?" + "," + Hr.COL_HR_PASSWORD + " =?,"
			+ Hr.COL_HR_DEPARTMENT + "" + "=?," + Hr.COL_HR_CONTACT
			+ "=?  where " + Hr.COL_HR_ID + " =?";

	// delete data from table on the basis of hr id
	private static String deleteQuery = "delete from " + Hr.TABLE_HR + " where"
			+ " " + Hr.COL_HR_ID + " =?";

	/**
	 * {@code addHr()} add the hr object in hr table in database
	 * 
	 * @param hr
	 * @return
	 */
	@Override
	public Hr addHr(Hr hr) {
		logger.debug("START");
		try {
			PreparedStatement pstat = connection.prepareStatement(addQuery);
			pstat.setInt(1, hr.getHrId());
			pstat.setString(2, hr.getHrName());
			pstat.setString(3, hr.getHrPassword());
			pstat.setString(4, hr.getHrDepartment());
			pstat.setString(5, hr.getHrContact());

			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 0) {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("END");
		return hr;

	}

	/**
	 * {@code getHr()} retrieves a single hr from hr table on the basis of hrId
	 * 
	 * @param hrId
	 * @return
	 */
	@Override
	public Hr getHr(int hrId) {
		logger.debug("START");
		try {
			PreparedStatement pstat = connection
					.prepareStatement(searchQueryOne);
			pstat.setInt(1, hrId);
			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				String department = resultSet.getString(4);
				String contact = resultSet.getString(5);

				Hr hr = new Hr(id, name, password, department, contact);
				logger.debug("END");
				return hr;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("Return NULL");
		return null;
	}

	/**
	 * {@code getHrs()} retrieves all hrs from hr table
	 * 
	 * @return
	 */
	@Override
	public List<Hr> getHrs() {

		logger.debug("START");
		List<Hr> hrs = new ArrayList<Hr>();
		try {
			PreparedStatement pstat = connection.prepareStatement(searchQuery);

			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				String department = resultSet.getString(4);
				String contact = resultSet.getString(5);

				Hr hr = new Hr(id, name, password, department, contact);

				hrs.add(hr);
			}
			logger.debug("END");
			return hrs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * {@code updateHr()} Updates each attribute in the hr table
	 * @param hr
	 * @return
	 */
	@Override
	public boolean updateHr(Hr hr) {

		logger.debug("START");
		try {
			PreparedStatement pstat = connection.prepareStatement(updateQuery);

			Hr hrInDB = new HrDAOImplementation().getHr(hr.getHrId());

			if (hr.getHrName() == null)
				hr.setHrName(hrInDB.getHrName());

			if (hr.getHrPassword() == null)
				hr.setHrPassword(hrInDB.getHrPassword());

			if (hr.getHrDepartment() == null)
				hr.setHrDepartment(hrInDB.getHrDepartment());

			if (hr.getHrContact() == null)
				hr.setHrContact(hrInDB.getHrContact());

			pstat.setString(1, hr.getHrName());
			pstat.setString(2, hr.getHrPassword());
			pstat.setString(3, hr.getHrDepartment());
			pstat.setString(4, hr.getHrContact());
			pstat.setInt(5, hr.getHrId());

			int resultUpdate = pstat.executeUpdate();

			if (resultUpdate == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("END");
		return false;
	}

	/**
	 * {@code deleteHr()}delete each hr from hr table
	 * 
	 * @param hrId
	 * @return
	 */
	@Override
	public Hr deleteHr(int hrId) {
		logger.debug("START");
		try {
			Hr hrFromDb = getHr(hrId);
			PreparedStatement pstat = connection.prepareStatement(deleteQuery);
			pstat.setInt(1, hrId);
			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 1) {
				return hrFromDb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("END");
		return null;
	}
}
