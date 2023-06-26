package in.meenasubramanian.kaithari.serviece;

import in.meenasubramanian.kaithari.dao.UserDAO;
import in.meenasubramanian.kaithari.model.User;

public class UserServiece {
	public User[] getAll() {
		UserDAO userDao = new UserDAO();
		User[] UserList = userDao.findAll();
		for (int i = 0; i < UserList.length; i++) {
			System.out.println(UserList[i]);
		}

		return UserList;
	}

	public void create() {
		User newUser = new User();
		newUser.setId(186540);
		newUser.setEmail("meenu2004@gmail.com");
		newUser.setFirstName("Meena");
		newUser.setLastName("Subramanian");
		newUser.setActive(true);
		newUser.setPassword("Meenu@2343");

		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}

	

}
