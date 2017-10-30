package com.recruitment.service;

import java.util.List;

import com.recruitment.model.Hr;

public interface HrService {
	/**
	 * This method add Hr data to Hr table.
	 * @param hr
	 * @return
	 */
	public Hr addHr(Hr hr);
	/**
	 * This method get single Hr data from Hr table.
	 * 
	 * @param hrId
	 */

	public Hr getHr(int hrId);
	/**
	 * This method get all Hrs data from Hr table.
	 * @return
	 */

	public List<Hr> getHrs();
	/**
	 * This method update Hr table by passing hr Object as
	 * parameter.
	 * 
	 * @param hr
	 * @return
	 */

	public boolean updateHr(Hr hr);
	/**
	 * This method delete the record on the basis of parameters passed.
	 * @param hrId
	 * @return
	 */

	public Hr deleteHr(int hrId);
}
