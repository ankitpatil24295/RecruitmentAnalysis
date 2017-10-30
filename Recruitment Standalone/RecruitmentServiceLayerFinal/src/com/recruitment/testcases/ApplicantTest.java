package com.recruitment.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.recruitment.model.Applicant;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.implementation.ApplicantServiceImplementation;

/*
 * 
 * This Test class of applicant, tests add applicant, get applicant and get list of applicants methods only.
 * There is no testing update and delete functionality of Applicant services.
 */
public class ApplicantTest {

	ApplicantService applicantServiceImplementation = new ApplicantServiceImplementation();
	Applicant applicantNew = new Applicant();

	/*
	 * Test case for getApplicant() method of ApplicantServiceImplementation
	 * class: This test case, checks whether getApplicant() method returns
	 * single Applicant object according to ApplicantId=1 , and it should not be
	 * null.
	 */
	@Test
	public void testGetApplicant() {

		applicantNew = applicantServiceImplementation.getApplicant(1);
		assertNotNull(applicantNew);

	}// testGetApplicant()

	/*
	 * Test case for getApplicants() method of ApplyServiceImplementation class:
	 * This test case, checks whether getApplicants() method returns list of
	 * applicant method , and it should not be null.
	 */
	@Test
	public void testGetApplicants() {

		List<Applicant> applicants = applicantServiceImplementation
				.getApplicants();
		assertNotNull(applicants);

	}// testGetApplicants()

	/*
	 * Test case for addApplicant() method of ApplicantServiceImplementation
	 * class. This test case, checks whether addapplicant() method returns true
	 * or not after adding new applicant entry in applicant table.
	 */
	@Test
	public void testAddApplicant() {

		Applicant applicant = new Applicant();
		applicant.setApplicantName("Arihant");
		applicant.setApplicantSkillSet("Java");
		applicant.setApplicantExperience(4.5);
		assertNotNull(applicantServiceImplementation.addApplicant(applicant));

	}// testAddApplicant()

	/*
	 * Test case for updateApplicant() method of ApplicantServiceImplementation
	 * class. This test case, checks whether updateApplicant() method returns
	 * true or not after updating entry of applicantId = 4.
	 */
	@Test
	public void testUpdateApplicant() {
		Boolean expected = true;
		applicantNew.setApplicantId(4);
		applicantNew.setApplicantExperience(2.5);
		Boolean actual = applicantServiceImplementation
				.updateApplicant(applicantNew);
		assertEquals(expected, actual);
	}// testUpdateHr()

	/*
	 * Test case for deleteApplicant() method of ApplicantServiceImplementation
	 * class. This test case, checks whether applicantHr() method returns null
	 * or not after deleting entry of applicantId = 35.
	 */
	@Test
	public void testDeleteApplicant() {
		assertNotNull(applicantServiceImplementation.deleteApplicant(16));
	}// testDeleteHr()

}
