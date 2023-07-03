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

//	public void create1(User newUser1) {
//			UserList.listOfUser[0] = newUser;
//		User[] arr = UserList.listOfUser;
//		for (int i = 0; i < arr.length; i++) {
//			User user = arr[i];
//			if (user == null) {
//				arr[i] = newUser1;
//				break;
//			}
//		}
//
//	}

//
//
//	public void update(int id, User updateUser) {
//		User[] arr = UserList.listOfUser;
//		for (int i = 0; i < arr.length; i++) {
//			User user = arr[i];
//			System.out.println(arr[i]);
//			System.out.println(user);
//			if (user == null) {
//				continue;
//			}
//			if (user.getId() == id) {
//				updateUser.setFirstName("varthini");
//				user.setFirstName(updateUser.getFirstName());
//				user.setLastName(updateUser.getLastName());
//				user.setPassword(updateUser.getPassword());
//			}
//		}
//	}

//	public void delete(int userId) {
//		User[] arr = UserList.listOfUser;
//		for (int i = 0; i < arr.length; i++) {
//			User user = arr[i];
//			if (user == null) {
//				continue;
//			}
//			if (user.getId() == userId) {
//				user.setActive(false);
//
//			}
//		}
//	}
	

//	public User findById(int id, userId) {
//				User[] arr = UserList.listOfUser;
//			 User userMatch = null;
//			 for(int i=0;i<arr.length;i++) {
//					User user = arr[i];
//			 if(user == null) {
//					continue;
//				}
//			 if(user.getId() == userId) {
//				 userMatch = user;
//				 break;
//			 }
//			}
//	}
}
