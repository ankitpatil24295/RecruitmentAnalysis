package com.recruitment.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daointerface.PositionDAOInterface;
import com.recruitment.dbconnection.DBConnection;
import com.recruitment.model.Hr;
import com.recruitment.model.Position;

/**
 * PositonDAO class interacts with post table in database. {@link Position}
 * 
 */

public class PositionDAOImplementation implements PositionDAOInterface {

	Logger logger = Logger.getLogger(HrDAOImplementation.class);// Logger Object
	private static Connection connection = DBConnection.getConnection(); // connection
																			// object

	private static final String TBL_NAME = "post";
	private static final String COL_POSITION_ID = "position_id";
	private static final String COL_HR_ID = "hr_id";
	private static final String COL_POSITION_NAME = "position_name";
	private static final String COL_NO_OF_POSITION = "no_of_position";
	private static final String COL_EXPERIENCE_REQUIRED = "experience_required";
	private static final String COL_POSITION_POST_DATE = "position_post_date";
	private static final String COL_POSITION_STATUS = "position_status";

	// add position data in position table
	private String insertQuery = "INSERT INTO " + TBL_NAME
			+ " values(?,?,?,?,?,?,?)";

	// delete data from table on the basis of position id
	private String deleteQuery = "DELETE FROM " + TBL_NAME + " WHERE "
			+ COL_POSITION_ID + "=?";

	// update data in table on the basis of position id
	private String updateQuery = "UPDATE " + TBL_NAME + " SET " + COL_HR_ID
			+ "=?," + COL_POSITION_NAME + "=?,"

			+ COL_NO_OF_POSITION + "=?," + COL_EXPERIENCE_REQUIRED + "=?,"
			+ COL_POSITION_POST_DATE + "=?,"

			+ COL_POSITION_STATUS + "=? " + " WHERE " + COL_POSITION_ID + "=?";

	// List data on the basis of position id
	private String searchpost = "SELECT * FROM " + TBL_NAME + " WHERE "
			+ COL_POSITION_ID + "=?";

	// List all data of position table
	private String searchAllpost = "SELECT * FROM " + TBL_NAME;
	private PreparedStatement pstat;
	private ResultSet resultSet;

	/**
	 * {@code addPosition()} add the position object in position table in
	 * database
	 * 
	 * @param position
	 * @return
	 */

	@Override
	public Position addPosition(Position position) {

		logger.debug("START");
		try {

			pstat = connection.prepareStatement(insertQuery);
			pstat.setInt(1, position.getPositionId());
			pstat.setInt(2, position.getHr().getHrId());
			pstat.setString(3, position.getPositionName());
			pstat.setInt(4, position.getNoOfPosition());
			pstat.setDouble(5, position.getPositionExperience());
			pstat.setDate(6, position.getPositionPostDate());
			pstat.setBoolean(7, position.isPositionStatus());

			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 0) {
				return null;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		logger.debug("END");
		return position;

	}

	/**
	 * {@code getPosition()} retrieves a single position from position table on
	 * the basis of positionId
	 * 
	 * @param positionId
	 * @return
	 */

	@Override
	public Position getPosition(int positionId) {

		logger.debug("START");
		try {
			PreparedStatement statement = connection
					.prepareStatement(searchpost);
			statement.setInt(1, positionId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Position position = new Position();
				Hr hr = new Hr();
				position.setPositionId(resultSet.getInt(1));
				hr.setHrId(resultSet.getInt(2));
				position.setHr(hr);
				position.setPositionName(resultSet.getString(3));
				position.setNoOfPosition(resultSet.getInt(4));
				position.setPositionExperience(resultSet.getDouble(5));
				position.setPositionPostDate(resultSet.getDate(6));
				position.setPositionStatus(resultSet.getBoolean(7));
				return position;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * {@code getPosition()} retrieves all position lists from position table
	 * 
	 * @return
	 */
	@Override
	public List<Position> getPositions() {

		logger.debug("START");
		List<Position> positionlists = new ArrayList<Position>();

		try {
			PreparedStatement pstat = connection
					.prepareStatement(searchAllpost);

			ResultSet resultSet = pstat.executeQuery();

			while (resultSet.next()) {
				Position position = new Position();
				Hr hr = new Hr();

				position.setPositionId(resultSet.getInt(1));
				hr.setHrId(resultSet.getInt(2));
				position.setHr(hr);
				position.setPositionName(resultSet.getString(3));
				position.setNoOfPosition(resultSet.getInt(4));
				position.setPositionExperience(resultSet.getDouble(5));
				position.setPositionPostDate(resultSet.getDate(6));
				position.setPositionStatus(resultSet.getBoolean(7));

				positionlists.add(position);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		logger.debug("END");
		return positionlists;
	}

	/**
	 * {@code updatePosition()} Updates each attribute in the Position table
	 * 
	 * @param position
	 * @return
	 */
	@Override
	public boolean updatePosition(Position position) {
		logger.debug(position);
		logger.debug(position.getNoOfPosition());
		try {
			PreparedStatement pstat = connection.prepareStatement(updateQuery);

			Position positionInDB = new PositionDAOImplementation()
					.getPosition(position.getPositionId());
			logger.debug(positionInDB);
			if (position.getHr().getHrId() == 0) {
				Hr hr = new Hr();
				hr.setHrId(positionInDB.getHr().getHrId());
				position.setHr(hr);
			}
			if (position.getPositionName() == null)
				position.setPositionName(positionInDB.getPositionName());

			if (position.getPositionExperience() == 0)
				position.setPositionExperience(positionInDB
						.getPositionExperience());

			if (position.getPositionPostDate() == null)
				position.setPositionPostDate(positionInDB.getPositionPostDate());

			logger.debug(position.isPositionStatus());
			logger.debug(position.getNoOfPosition());
			logger.debug("************************************");
			pstat.setInt(7, position.getPositionId());
			pstat.setInt(1, position.getHr().getHrId());
			pstat.setString(2, position.getPositionName());
			pstat.setInt(3, position.getNoOfPosition());
			pstat.setDouble(4, position.getPositionExperience());
			pstat.setDate(5, position.getPositionPostDate());
			pstat.setBoolean(6, position.isPositionStatus());
			logger.debug(pstat);
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
	 * {@code deletePosition()}delete each Position from position table
	 * 
	 * @param positionId
	 * @return
	 */
	@Override
	public Position deletePosition(int positionId) {

		logger.debug("START");
		try {
			Position positionFromDb = getPosition(positionId);
			PreparedStatement pstat = connection.prepareStatement(deleteQuery);
			pstat.setInt(1, positionId);
			int rowUpdated = pstat.executeUpdate();

			if (rowUpdated == 1) {

				return positionFromDb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("END");
		return null;
	}
}
