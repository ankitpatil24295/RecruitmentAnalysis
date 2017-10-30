package com.recruitment.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.recruitment.daoimplementation.HrDAOImplementation;
import com.recruitment.daointerface.HrDAOInterface;
import com.recruitment.model.Hr;
import com.recruitment.service.HrService;
/**
 *This class is a service layer implementation of Human Resource(Hr).
 */
public class HrServiceImplementation implements HrService {

	Logger logger =Logger.getLogger(HrServiceImplementation.class);	//Logger Object
	HrDAOInterface hrDAOInterface = new HrDAOImplementation();

	@Override
	public Hr addHr(Hr hr) {
		
		return hrDAOInterface.addHr(hr);
	}

	@Override
	public Hr getHr(int hrId) {
		return hrDAOInterface.getHr(hrId);
	}

	@Override
	public List<Hr> getHrs() {
		return hrDAOInterface.getHrs();
	}

	@Override
	public boolean updateHr(Hr hr) {
		return hrDAOInterface.updateHr(hr);
	}

	@Override
	public Hr deleteHr(int hrId) {
		return hrDAOInterface.deleteHr(hrId);
	}
}
