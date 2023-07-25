package in.meenasubramanian.kaithari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import in.meenasubramanian.kaithari.Interface.UserInterface;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.util.ConnectionUtil;

import java.util.ArrayList;

public class UserDAO implements UserInterface {

	@Override
	public void create(User user) {

		List<User> userList = UserList.ListOfUsers;

		boolean userExists = false;

		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User existingUser = iterator.next();
			if (existingUser == null) {
				iterator.remove();
				userList.add(user);
				userExists = true;
				break;
			}
		}

		if (!userExists) {
			userList.add(user);
		}
	}

	public User findById(int userId) {
		List<User> userList = UserList.ListOfUsers;
		User matchedUser = null;

		for (User newUser : userList) {

			User user = newUser;
			if (user.getId() == userId) {
				matchedUser = user;
				break;
			}
		}
		System.out.println(matchedUser);
		return matchedUser;
	}

//	public User findByEmail(String userEmail) {
//		List<User> userList = UserList.ListOfUsers;
//		User userMatch = null;
//
//		for (User newUser : userList) {
//			User user = newUser;
//
//			if (user == null) {
//				System.out.println("User Details is Not There");
//				break;
//			}
//			if (user.getEmail().equals(userEmail)) {
//				userMatch = user;
//				break;
//			}
//		}
//		System.out.println(userMatch);
//		return userMatch;
//	}

	@Override
	public void delete(int newId) {
		List<User> userList2 = UserList.ListOfUsers;
		for (User newUser : userList2) {
			User user1 = newUser;

			if (user1 == null) {
				continue;
			}
			if (user1.getId() == newId) {
				user1.setActive(false);

			}

		}

	}

	@Override
	public int count() {
		List<User> userList3 = UserList.ListOfUsers;
		int count = 0;
		for (User newUser : userList3) {
			User user1 = newUser;
			count++;
		}
		return count;
	}

	@Override
	public void update(int id, User newUser) {
		List<User> userList = UserList.ListOfUsers;

		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User existingUser = iterator.next();
			if (existingUser.getId() == id) {
				iterator.remove();
				userList.add(newUser);
				break;
			}
		}
	}

	public List<User> findAll() throws RuntimeException {
//		return UserList.ListOfUsers;
		Connection con = null;
		PreparedStatement ps = null;
		List<User> userList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM Users WHEARE isActive = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery(query);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstName"));
				user.setLastname(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("isActive"));
				user.setPassword(rs.getString("password"));

				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return userList;
	}
	
	public User findById1(int userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			String query = "SELECT * FROM user WHERE is_active = 1 AND id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname("firstName");
				user.setLastname("lastNmae");
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("isActive"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return user;
	}

	public void create1(User newUser) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        String query = "INSERT INTO user (first_name, last_name, email, password) VALUES (?,?,?,?)";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, newUser.getFirstname());
	        ps.setString(2, newUser.getLastname());
	        ps.setString(3, newUser.getEmail());
	        ps.setString(4, newUser.getPassword());
	        ps.executeUpdate();
	        System.out.println("User has been created successfully");
	      
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e);
	    } finally {
	        ConnectionUtil.close(conn, ps, null);
	    }
	}
	
	
	
}
	


