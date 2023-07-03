package in.meenasubramanian.kaithari;

import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.serviece.UserServiece;

public class App {

	public static void main(String[] args) {
		try {
			UserServiece userServiece = new UserServiece();

			User newUser = new User();
			newUser.setId(186540);
			newUser.setEmail("meenu2004@gmail.com");
			newUser.setFirstName("Meena");
			newUser.setLastName("Subramanian");
			newUser.setActive(true);
			newUser.setPassword("Meenu@2343");

			userServiece.create(newUser);
			userServiece.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
