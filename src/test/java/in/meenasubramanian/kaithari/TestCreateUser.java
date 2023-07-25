package in.meenasubramanian.kaithari;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.serviece.UserServiece;


public class TestCreateUser {
	


	@Test
	public void testCreateUserWithValidInput(){
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		newUser.setFirstname("Saranya");
		newUser.setLastname("Subramanian");
		newUser.setEmail("saran@fssa.freshworks.com");
		newUser.setPassword("567ghj");
		newUser.toString();
		
		assertDoesNotThrow(() ->{
			userservice.create(newUser);
		});
		
	}
	
	@Test
	public void testCreateUserWithExistingEmail(){
		UserServiece userservice = new UserServiece();
		
		Exception exception = assertThrows(RuntimeException.class, () -> {

			User newUser = new User();

		
			newUser.setFirstname("Meenu");
			newUser.setLastname("Vasu");
			newUser.setEmail("Meenu@fssa.freshworks.com");
			newUser.setPassword("Asdf@123");
		

			userservice.create(newUser);
		});
		String expectedMessage = "Duplicate constraint";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	
	@Test
	public void testCreateUserWithInvalidInput() {
		UserServiece userservice = new UserServiece();
		
		Exception exception = assertThrows(Exception.class, () -> {
			userservice.create(null);
		});
		String expectedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	// email test case
	@Test
	public void testCreateUserWithEmailNull() {
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		
		newUser.setFirstname("Meenu");
		newUser.setLastname("Vasu");
		newUser.setEmail(null);
		newUser.setPassword("123asd");
		newUser.toString();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userservice.create(newUser);
		});
		String expectedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	public void testCreateUserWithEmailEmpty() {
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		
		newUser.setFirstname("Meenu");
		newUser.setLastname("Vasu");
		newUser.setEmail("");
		newUser.setPassword("123asd");
		newUser.toString();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userservice.create(newUser);
		});
		String expectedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	// password test case
	@Test
	public void testCreateUserWithPasswordNull() {
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		newUser.setFirstname("Meenu");
		newUser.setLastname("Vasu");
		newUser.setEmail("Meenu@fssa.freshworks.com");
		newUser.setPassword(null);
		newUser.toString();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userservice.create(newUser);
		});
		String expectedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	public void testCreateUserWithPasswordEmpty() {
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		newUser.setFirstname("Meenu");
		newUser.setLastname("Vasu");
		newUser.setEmail("Meenu@fssa.freshworks.com");
		newUser.setPassword("");
		newUser.toString();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userservice.create(newUser);
		});
		String expectedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	// firstName test case
	@Test
	public void testCreateUserWithFirstNameNull() {
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		newUser.setFirstname(null);
		newUser.setLastname("Vasu");
		newUser.setEmail("Meenu@fssa.freshworks.com");
		newUser.setPassword("123asd");
		newUser.toString();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userservice.create(newUser);
		});
		String expectedMessage = "Firstname cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	public void testCreateUserWithPFirstNameEmpty() {
		UserServiece userservice = new UserServiece();
		
		// user 1
		User newUser = new User();
		
		newUser.setFirstname("");
		newUser.setLastname("Vasu");
		newUser.setEmail("Meenu@fssa.freshworks.com");
		newUser.setPassword("123asd");
		newUser.toString();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userservice.create(newUser);
		});
		String expectedMessage = "Firstname cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}


}