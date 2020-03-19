package dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import domain.User;

public class UserLinkedListDao implements UserDao {
	private List<User> users;

	@Autowired
	public UserLinkedListDao() {
		users = new LinkedList<User>();
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
