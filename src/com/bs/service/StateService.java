package com.bs.service;

import java.util.List;

import com.bs.entity.Search;
import com.bs.entity.State;


public interface StateService extends BaseService{
	public void add(State state);
	public void delete(State state);
	public void update(State state);
	public State findById(int id);
	public State findByUserId(int id);
	public List<State> search(Search search);
}

