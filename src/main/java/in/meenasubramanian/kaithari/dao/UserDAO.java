package in.meenasubramanian.kaithari.dao;

import in.meenasubramanian.kaithari.model.User;

public class UserDAO {
	public User[] findAll() {
		User[] userlist = UserList.listOfUser;
		return userlist;
	}

	public void create() {
		User newUser = new User();
		newUser.setId(186540);
		newUser.setEmail("meenu2004@gmail.com");
		newUser.setFirstName("Meena");
		newUser.setLastName("Subramanian");
		newUser.setActive(true);
		newUser.setPassword("Meenu@2343");

		UserList.listOfUser[0] = newUser;
	}
}
