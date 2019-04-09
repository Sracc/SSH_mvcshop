package com.bs.dao;
import java.util.List;

import com.bs.entity.Search;
import com.bs.entity.State;

public interface StateDao {
public void save(State state);
public void delete(State state);
public void update(State state);
public State getById(int id);
public List<State> query(Search search);
public State getByUserId(int id);
}

