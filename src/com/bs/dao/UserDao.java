package com.bs.dao;

import java.util.List;




import com.bs.entity.Search;
import com.bs.entity.User;



public interface UserDao {
	public void save(User user) ;
	
	public void update(User user);
	
	public void delete(User user);
	
	public User getById(int id);
	
	public List<User> query(String str);
	
	public List<User> query(Search search);
	
	public User login(String username, String password);
	
	public User getByUsername(String username);
}
