package com.recruitment.testcases;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.recruitment.service.ApplyService;
import com.recruitment.service.implementation.ApplyServiceImplementation;

/**
 * This Test class of apply, tests add apply, get apply and get list of
 * applicants methods only. There is no testing update and delete functionality
 * of Applicant services.
 */
public class ApplyTest {

	ApplyService applyService = new ApplyServiceImplementation();

	/*
	 * Test case for getApply() method of ApplyServiceImplementation class: This
	 * test case, checks whether getApply() method returns single Apply object
	 * according to ApplicntId=1 and PositionId = 501, and it should not be
	 * null.
	 */
	@Test
	public void testGetApply() {
		assertNotNull(applyService.getApply(1, 501));
	}

	/*
	 * Test case for getApplys() method of ApplyServiceImplementation class:
	 * This test case, checks whether getApplys() method returns list of all
	 * entries in ApplicantApply table, and it should not be null.
	 */
	@Test
	public void testGetApplys() {
		assertNotNull(applyService.getApplies());
	}

}
