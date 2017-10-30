package com.recruitment.testcases;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;

import com.recruitment.model.Position;
import com.recruitment.service.HrService;
import com.recruitment.service.PositionService;
import com.recruitment.service.implementation.HrServiceImplementation;
import com.recruitment.service.implementation.PositionServiceImplementation;

public class PositionTest {

	PositionService positionService = new PositionServiceImplementation();
	Position postion = new Position();
	HrService hrService = new HrServiceImplementation();

	@Test
	public void testAddPosition() {
		postion.setPositionId(503);
		postion.setHr(hrService.getHr(202));
		postion.setPositionName("Seniour JAVA Developer");
		postion.setNoOfPosition(4);
		postion.setPositionExperience(3);
		Date date = new Date(2014 - 02 - 02);
		postion.setPositionPostDate(date);
		postion.setPositionStatus(true);
		assertNotNull(positionService.addPosition(postion));

	}

	@Test
	public void testGetPosition() {
		assertNotNull(positionService.getPosition(501));
	}

	@Test
	public void testGetPositions() {
		assertNotNull(positionService.getPositions());
	}

}
