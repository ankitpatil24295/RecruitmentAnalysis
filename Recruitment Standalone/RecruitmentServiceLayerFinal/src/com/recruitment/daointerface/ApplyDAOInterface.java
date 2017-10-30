package com.recruitment.daointerface;

import java.util.List;

import com.recruitment.model.Apply;

public interface ApplyDAOInterface {
	public Apply addApply(Apply apply);

	public Apply getApply(int applyId,int positionId);

	public List<Apply> getApplies();

	public Apply deleteApply(int applyId,int positionId);
}
