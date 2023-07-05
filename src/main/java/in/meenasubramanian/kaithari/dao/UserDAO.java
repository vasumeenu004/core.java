package in.meenasubramanian.kaithari.dao;

import in.meenasubramanian.kaithari.model.User;

public class UserDAO {
	public User[] findAll() {
		User[] userlist = UserList.listOfUser;
		return userlist;
	}

/**
 * 
 * @param newUser
 */
	public void create(User newUser) {
//		UserList.listOfUser[0] = newUser;
		User[] arr = UserList.listOfUser;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				arr[i] = newUser;
				break;
			}
		}
	}
	


	public void update(User updateUser) {
		User[] arr = UserList.listOfUser;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == updateUser.getId()) {
				updateUser.setFirstName("varthini");
				user.setFirstName(updateUser.getFirstName());
				user.setLastName(updateUser.getLastName());
				break;
			}
		}
	}

	public void delete(User deleteUser) {
		User[] arr = UserList.listOfUser;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == deleteUser.getId()) {
				user.setActive(false);
				break;

			}
		}
	}
	

	public User findById(User findByUser) {
				User[] arr = UserList.listOfUser;
			 User userMatch = null;
			 for(int i=0;i<arr.length;i++) {
					User user = arr[i];
			 if(user == null) {
					continue;
				}
			 if(user.getId() == findByUser.getId()) {
				 userMatch = user;
				 break;
			 }
			}
	return userMatch;
	}
}
