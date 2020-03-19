package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import domain.User;

public class UserArrayListDao implements UserDao {
	private List<User> users;

	public UserArrayListDao() {
		users = new ArrayList<User>();
	}

	public void save(User user) {
		users.add(user);
	}
	
	public void printAll() {
		if(users.isEmpty())
			System.out.println("Lista je prazna");
		else {
			for (User user : users) {
				System.out.println(user);
			}
		}
	}

}
