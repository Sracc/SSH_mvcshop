package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource
;

import org.springframework.stereotype.Service;

import com.bs.dao.StateDao;
import com.bs.entity.Search;
import com.bs.entity.State;
import com.bs.service.StateService;

@Service("stateService")
public class StateServiceImpl extends BaseServiceImpl implements StateService {
	@Resource
	StateDao stateDao ;
	public void add(State state) {
		stateDao.save(state);
	}

	public void delete(State state) {
		stateDao.delete(state);
	}

	public void update(State state) {
		stateDao.update(state);
	}

	public State findById(int id) {
		return stateDao.getById(id);
	}

	public State findByUserId(int id) {
		return stateDao.getByUserId(id);
	}

	public List<State> search(Search search) {
		return stateDao.query(search);
	}

}
