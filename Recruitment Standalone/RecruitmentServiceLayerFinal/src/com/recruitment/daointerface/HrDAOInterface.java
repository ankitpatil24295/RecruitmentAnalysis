package com.recruitment.daointerface;

import java.util.List;

import com.recruitment.model.Hr;

public interface HrDAOInterface {
	public Hr addHr(Hr hr);

	public Hr getHr(int hrId);

	public List<Hr> getHrs();

	public boolean updateHr(Hr hr);

	public Hr deleteHr(int hrId);
}
