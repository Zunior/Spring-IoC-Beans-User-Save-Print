package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.UserDao;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Autowired
	@Qualifier(value = "arrayListDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(User user) {
		userDao.save(user);
	}

	//print
	public void printAll() {
		userDao.printAll();
	}

}
