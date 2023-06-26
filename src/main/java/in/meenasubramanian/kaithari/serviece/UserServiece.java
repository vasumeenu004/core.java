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

}
