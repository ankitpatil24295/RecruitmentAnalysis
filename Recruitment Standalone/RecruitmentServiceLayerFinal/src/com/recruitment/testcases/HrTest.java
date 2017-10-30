package com.recruitment.testcases;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.recruitment.model.Hr;
import com.recruitment.service.HrService;
import com.recruitment.service.implementation.HrServiceImplementation;

/*
 * This Test class of Hr, tests add Hr, get Hr and get list of Hrs methods only.
 */
public class HrTest {

	HrService hrService = new HrServiceImplementation();
	Hr hr = new Hr();
	int hrId;
	

	/*
	 * Test case for addHr() method of HrServiceImplementation class.
	 * This test case, checks whether addHr() method returns null or not after adding new hr entry in Hr table.
	 */
	@Test
	public void testAddHr() {
		this.hrId = hrId + 1;
		hr.setHrId(hrId);
		hr.setHrName("Newly joined Hr");
		hr.setHrPassword("password");
		hr.setHrDepartment("Operations");
		hr.setHrContact("57439");
		Hr hrNew = hrService.addHr(hr);
		//assertNotNull(hrNew);
		assertEquals(hr,hrNew);
	
	}
	
	
	/*
	 * Test case for getHr() method of HrServiceImplementation class:
	 * This test case, checks whether getHr() method returns single Hr object according to HrId, and it should not be null.
	 */
	@Test
	public void testGetHr()
	{
		assertNotNull(hrService.getHr(204));
		
	}
	
	/*
	 * Test case for getHrs() method of HrServiceImplementation class.
	 * This test case, checks whether getHrs() method returns list, and it should not be null.
	 */
	@Test
	public void testGetAllHrs()
	{
		List<Hr> listofHrs = hrService.getHrs();
		assertNotNull(listofHrs);
	}
	
	/*
	 * Test case for updateHr() method of HrServiceImplementation class.
	 * This test case, checks whether deleteHr() method returns true or not after updating entry of HrId = 203.
	 */
	@Test
	public void testUpdateHr()
	{
		Boolean expected = true;
		hr.setHrId(203);
		hr.setHrName("Maheshree");
		Boolean actual = hrService.updateHr(hr);
		assertEquals(expected,actual);
	}
	
	/*
	 * Test case for deleteHr() method of HrServiceImplementation class.
	 * This test case, checks whether deleteHr() method returns null or not after deleting entry of HrId = 209.
	 */
	@Test
	public void testDeleteHr()
	{
		assertNotNull(hrService.deleteHr(209));
	}

}
