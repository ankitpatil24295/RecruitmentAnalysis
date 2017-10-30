
package com.recruitment.service;

import java.util.List;

import com.recruitment.model.Position;
/**
 *Position service consist of various methods that calls methods in PositionDAO.
 */
public interface PositionService {
	/**
	 * This method add Position data to post table.
	 * @param position
	 * @return
	 */
	public Position addPosition(Position position);

	/**
	 * This method get single Position data from post table.
	 * @param positionId
	 * @return
	 */
	public Position getPosition(int positionId);

	/**
	 *  This method get all Position data from post table.
	 * @return
	 */
	public List<Position> getPositions();

	/**
	 * This method update post table by passing Position Object as a parameter.
	 * @param position
	 * @return
	 */
	public boolean updatePosition(Position position);

	/**
	 * This method delete the record on the basis of parameters passed.
	 * @param positionId
	 * @return
	 */
	public Position deletePosition(int positionId);
	
	/**
	 * This method changes position status in post table as "Closed"
	 * when joining status of applicant is true. 
	 */
	public void changePositionStatusFromJoiningStatus();
}
