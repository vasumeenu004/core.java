package in.meenasubramanian.kaithari.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.meenasubramanian.kaithari.Interface.UserInterface;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.util.ConnectionUtil;


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
			
//			newUser.toString();
			
			ps.setString(1, newUser.getFirstname());
			ps.setString(2, newUser.getLastname());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());
			
			ps.executeUpdate();
			
			System.out.println("User has been created sucessfully");
			
		}catch(SQLException e) {
//			e.printStackTrace();
			if(e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("Duplicate constraint");
			} else {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
		}finally {
			ConnectionUtil.close(con, ps);
		}
	}
	
	
	@Override
	public void update(int id, User updatedUser) throws RuntimeException {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE users SET first_name =?, last_name =? WHERE id =?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, updatedUser.getFirstname());
			ps.setString(2, updatedUser.getLastname());
			ps.setInt(3, id);
			
			int rowUpdated = ps.executeUpdate();
			
			if (rowUpdated > 0) {
	            System.out.println("User with ID " + id + " updated successfully.");
	        } else {
	            System.out.println("No user found with ID " + id + ". Nothing updated.");
	        }
			
			
		} catch (SQLException e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		     throw new RuntimeException("Error updating user: " + e.getMessage());
		}finally {
			ConnectionUtil.close(con, ps);
		}
		
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
	}
	
	
	@Override
	public void delete(int newId) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE users SET is_active =0 WHERE id =?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1, newId);
			ps.executeUpdate();
			
			int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("User with ID " + newId + " has been deactivated.");
	        } else {
	            System.out.println("No user found with ID " + newId + ". Nothing changed.");
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error while deactivating user: " + e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
		
		
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

	public User findByEmail(String userEmail) throws RuntimeException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			String query = "SELECT * FROM users WHERE is_active = 1 AND email = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, userEmail);// don't start with zero, 1 represent the 1st question mark
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



	

}




