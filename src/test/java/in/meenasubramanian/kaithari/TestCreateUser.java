package in.meenasubramanian.kaithari;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.serviece.UserServiece;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValideInput() {
		UserServiece userServiece = new UserServiece();

		User newUser = new User();
		newUser.setId(186540);
		newUser.setEmail("meenu2004@gmail.com");
		newUser.setFirstName("Meena");
		newUser.setLastName("Subramanian");
		newUser.setActive(true);
		newUser.setPassword("Meenu@2343");
		assertDoesNotThrow(()->{
		userServiece.create(newUser);
		});			
	}
	@Test
	public void testCreateUserWithInvalideUser()  {
		UserServiece userServiece = new UserServiece();
		Exception exception = assertThrows(Exception.class,()->{
		userServiece.create(null);
		});
		String expectedMessage = "Invalid User Input";
		String actulMessage = exception.getMessage();
		
		assertTrue(expectedMessage.equals(actulMessage));
		
	}
	@Test
	public void testCreateUserWithEmailNull()  {
		UserServiece userServiece = new UserServiece();
		User newUser = new User();
		newUser.setId(186540);
		newUser.setEmail(null);
		newUser.setFirstName("Meena");
		newUser.setLastName("Subramanian");
		newUser.setActive(true);
		
		Exception exception = assertThrows(Exception.class,()->{
		userServiece.create(newUser);
		});
		String expectedMessage = "Email cannot be null (or) empty";
		String actulMessage = exception.getMessage();
		
		assertTrue(expectedMessage.equals(actulMessage));
		
	}
	@Test
	public void testCreateUserWithEmailEmpty()  {
		UserServiece userServiece = new UserServiece();
		User newUser = new User();
		newUser.setId(186540);
		newUser.setEmail("");
		newUser.setFirstName("Meena");
		newUser.setLastName("Subramanian");
		newUser.setActive(true);
		
		Exception exception = assertThrows(Exception.class,()->{
		userServiece.create(newUser);
		});
		String expectedMessage = "Email cannot be null (or) empty";
		String actulMessage = exception.getMessage();
		
		assertTrue(expectedMessage.equals(actulMessage));
		
	}
}
