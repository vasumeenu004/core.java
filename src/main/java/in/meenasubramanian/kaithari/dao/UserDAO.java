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
	
	public List<User> findAll() throws RuntimeException {
//		return UserList.ListOfUsers;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<User> userList = new ArrayList<User>();
		try {
			String query = "SELECT * FROM users Where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				User newUser = new User();
				newUser.setId(rs.getInt("id"));
				newUser.setFirstname(rs.getString("first_name"));
				newUser.setLastname(rs.getString("last_name"));
				newUser.setEmail(rs.getString("email"));
				newUser.setActive(rs.getBoolean("is_active"));
				userList.add(newUser);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return userList;
		

	}

	@Override
	public void create(User newUser) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO users(first_name, last_name, email, password ) VALUES (? ,?, ?, ?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			newUser.toString();
			
			ps.setString(1, newUser.getFirstname());
			ps.setString(2, newUser.getLastname());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());
			
			ps.executeUpdate();
			
			System.out.println("User has been created sucessfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
			
		}finally {
			ConnectionUtil.close(con, ps);
		}


	}

	public User findById(int userId) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			String query = "SELECT * FROM users WHERE is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);// don't start with zero, 1 represent the 1st question mark
			rs = ps.executeQuery();	
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return user;
		
	}
	@Override
	public void update(int id, User t) {
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInterface findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

// 	public User findByEmail(String userEmail) {
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
//
//	@Override
//	public void delete(int newId) {
//		List<User> userList2 = UserList.ListOfUsers;
//		for (User newUser : userList2) {
//			User user1 = newUser;
//
//			if (user1 == null) {
//				continue;
//			}
//			if (user1.getId() == newId) {
//				user1.setActive(false);
//
//			}
//
//		}
//
//	}
//
//	@Override
//	public int count() {
//		List<User> userList3 = UserList.ListOfUsers;
//		int count = 0;
//		for (User newUser : userList3) {
//			User user1 = newUser;
//			count++;
//		}
//		return count;
//	}
//
//	@Override
//	public void update(int id, User newUser) {
//		List<User> userList = UserList.ListOfUsers;
//
//		Iterator<User> iterator = userList.iterator();
//		while (iterator.hasNext()) {
//			User existingUser = iterator.next();
//			if (existingUser.getId() == id) {
//				iterator.remove();
//				userList.add(newUser);
//				break;
//			}
//		}
//	}

	

}






