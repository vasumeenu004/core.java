package in.meenasubramanian.kaithari.serviece;

import in.meenasubramanian.kaithari.dao.UserDAO;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.validation.UserValidator;

public class UserServiece {
	public User[] getAll() {
		UserDAO userDao = new UserDAO();
		User[] UserList = userDao.findAll();
		for (int i = 0; i < UserList.length; i++) {
			System.out.println(UserList[i]);
		}

		return UserList;
	}

	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}

//	public void update(int id, User updatedUser) {
//		UserDAO userDao = new UserDAO();
//		userDao.update(id, updatedUser);
//	}

}
