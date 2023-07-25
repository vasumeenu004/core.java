package in.meenasubramanian.kaithari;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.serviece.UserServiece;


public class TestGetAllUsers {
	
	
	@Test
	public void testGetAllUsers() {
		UserServiece userservice = new UserServiece();
		List<User> userList = new ArrayList<User>(userservice.getAll());
		System.out.println(userList);
		
	}
	
	
	@Test
	public void testUpdate() throws ValidationException {
		UserServiece userservice = new UserServiece();
		User newUser = new User();
		
		newUser.setFirstname("Varun");
		newUser.setLastname("Ramachandran");
		newUser.setEmail("vignesh@gmail.com");
		newUser.setPassword("asdf123");
		userservice.update(1, newUser);	
	}
	
	@Test
	public void testDeleteUser() {
		UserServiece userservice = new UserServiece();
		
		userservice.delete(3);
	}
	
	@Test
	public void testFindById() {
		UserServiece userservice = new UserServiece();
		
		User user = userservice.findById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindByEmail() {
		UserServiece userservice = new UserServiece();
		
		User user = userservice.findByEmail("vignesh@gmail.com");
		System.out.println(user);
	}
		

}
