package com.recruitment.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daoimplementation.PositionDAOImplementation;
import com.recruitment.daointerface.PositionDAOInterface;
import com.recruitment.model.Interview;
import com.recruitment.model.Position;
import com.recruitment.service.InterviewService;
import com.recruitment.service.PositionService;

/**
 * This class is a service layer implementation of Position.
 */
public class PositionServiceImplementation implements PositionService {
	Logger logger = Logger.getLogger(PositionServiceImplementation.class);//Logger Object
	PositionDAOInterface positionDaoInterface = new PositionDAOImplementation();

	InterviewService interviewService = new InterviewServiceImplementation();

	@Override
	public Position addPosition(Position position) {
		Position positionobj = null;
		positionobj = positionDaoInterface.addPosition(position);
		return positionobj;
	}

	@Override
	public Position getPosition(int positionId) {
		Position positionobj = null;
		positionobj = positionDaoInterface.getPosition(positionId);
		return positionobj;
	}

	@Override
	public List<Position> getPositions() {
		List<Position> listposition = null;
		listposition = positionDaoInterface.getPositions();
		return listposition;
	}

	@Override
	public boolean updatePosition(Position position) {
		return positionDaoInterface.updatePosition(position);
	}

	@Override
	public Position deletePosition(int positionId) {
		Position positionobj = null;
		positionobj = positionDaoInterface.deletePosition(positionId);
		return positionobj;
	}

	@Override
	public void changePositionStatusFromJoiningStatus() {
		logger.debug("START");
		List<Position> positions = positionDaoInterface.getPositions();
		List<Interview> getshortlistedApplicantByJoiningStatus = interviewService
				.getshortlistedApplicantByJoiningStatus();
		logger.info(getshortlistedApplicantByJoiningStatus);
		for (Position position : positions) {
			int positionId = position.getPositionId();
			int count = 0;
			for (Interview interview : getshortlistedApplicantByJoiningStatus) {
				if (interview.getPosition().getPositionId() == positionId) {
					count++;
				}// positionId if
			}// interview for

			if (count == position.getNoOfPosition()) {
				int noOfPosition = position.getNoOfPosition();
				int resultPosition = noOfPosition - count;
				logger.debug(resultPosition);
				position.setNoOfPosition(resultPosition);
				position.setPositionStatus(false);

				positionDaoInterface.updatePosition(position);
			}// noOfPosition if
		}// position for
		logger.debug("End");
	}
}
