package service;

import domain.User;

public interface UserService {
	void save(User user);
	
	public void printAll();
}
