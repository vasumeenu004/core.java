package in.meenasubramanian.kaithari;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.serviece.UserServiece;


public class TestCreateUser {

	@Test
	public void testCreateUserWithValidDataInput() {
		UserServiece userService = new UserServiece();

		User newUser = new User();
		newUser.setId(56789);
		newUser.setFirstname("Meenu");
		newUser.setLastname("Subu");
		newUser.setEmail("Meenu@gmail.com");
		newUser.setPassword("Azxcv@123");
		newUser.setActive(true);

		assertDoesNotThrow(() -> {
			userService.create(newUser);

		});

	}

	@Test

	public void testCreateUserWithInvalidData() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "invalid user input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailNull() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();
			newUser.setId(56789);
			newUser.setFirstname("Meenu");
			newUser.setLastname("Subu");
			newUser.setEmail("Meenu@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailEmpty() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();
			newUser.setId(56789);
			newUser.setFirstname("Meenu");
			newUser.setLastname("Subu");
			newUser.setEmail("Meenu@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test

	public void testCreateUserWithPasswordEmpty() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			
			newUser.setId(56789);
			newUser.setFirstname("Meenu");
			newUser.setLastname("Subu");
			newUser.setEmail("Meenu@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
@Test

	public void testCreateUserWithPasswordNull() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(56789);
			newUser.setFirstname("Meenu");
			newUser.setLastname("Subu");
			newUser.setEmail("Meenu@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
@Test

	public void testCreateUserWithFirstnameEmpty() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(56789);
			newUser.setFirstname("Meenu");
			newUser.setLastname("Subu");
			newUser.setEmail("Meenu@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	
	
	
@Test

	public void testCreateUserWithFirstnameNull() {
		UserServiece userService = new UserServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(56789);
			newUser.setFirstname("Meenu");
			newUser.setLastname("Subu");
			newUser.setEmail("Meenu@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}