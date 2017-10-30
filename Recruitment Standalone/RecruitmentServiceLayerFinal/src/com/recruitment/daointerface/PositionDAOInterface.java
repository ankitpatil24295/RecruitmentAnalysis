package com.recruitment.daointerface;

import java.util.List;

import com.recruitment.model.Position;

public interface PositionDAOInterface {
	public Position addPosition(Position position);

	public Position getPosition(int positionId);

	public List<Position> getPositions();

	public boolean updatePosition(Position position);

	public Position deletePosition(int positionId);
}
