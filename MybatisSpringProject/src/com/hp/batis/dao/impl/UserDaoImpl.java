package com.hp.batis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hp.batis.dao.UserDao;
import com.hp.batis.vo.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	//keep application scope
	@Autowired
	@Qualifier("sqlSessionFactory")
	private SqlSessionFactory factory = null;
	
	@Override
	public void addUser(User user) {
		//session.insert("addUser",user);
		//avoid get out of hand,keep Mappers in the Method scope
		SqlSession session = factory.openSession();
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			mapper.addUser(user);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateUser(User user) {
		SqlSession session = factory.openSession();
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			mapper.updateUser(user);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public User getUserById(int id) {
		SqlSession session = factory.openSession();
		User user = null;
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			user = mapper.getUserById(id);
		}finally{
			session.close();
		}
		return user;
	}

	@Override
	public void deleteUser(User user) {
		SqlSession session = factory.openSession();
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			mapper.deleteUser(user);
			session.commit();
		}finally{
			session.close();
		}
	}
	
	@Override
	public void deleteUserById(int id) {
		SqlSession session = factory.openSession();
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			mapper.deleteUserById(id);
			session.commit();
		}finally{
			session.close();
		}
	};
	
	@Override
	public List<User> getUsers() {
		SqlSession session = factory.openSession();
		List<User> users = null;
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			users = mapper.getUsers();
		}finally{
			session.close();
		}
		return users;
	}

	@Override
	public List<?> getPartionUsers() {
		SqlSession session = factory.openSession();
		List<?> users = null;
		try{
			UserDao mapper = session.getMapper(UserDao.class);
			users = mapper.getPartionUsers();
		}finally{
			session.close();
		}
		return users;
	}
}
