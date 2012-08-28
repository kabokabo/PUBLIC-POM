package com.hp.batis.dao;

import java.util.List;

import com.hp.batis.vo.User;

/**
 * 
 * @author heji
 *
 */
public interface UserDao {
	public void addUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public void deleteUser(User user);
	
	public void deleteUserById(int id);

	public List<User> getUsers();
	
	public List<?> getPartionUsers();
}
