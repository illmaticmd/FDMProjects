package com.fdmgroup;

import java.util.List;

public interface UserDAO {
	void addUser(User user);

	User getUser(String username);

	void removeUser(String username);

	void updateUser(User user);

	List<User> listUsers();
}
