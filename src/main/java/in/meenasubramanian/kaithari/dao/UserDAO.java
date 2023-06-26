package in.meenasubramanian.kaithari.dao;

import in.meenasubramanian.kaithari.model.User;

public class UserDAO {
	public User[] findAll() {
		User[] userlist = UserList.listOfUser;
		return userlist;
	}
	public void create(User newUser) {
		UserList.listOfUser[9] = newUser;
	}
}


