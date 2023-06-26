package in.meenasubramanian.kaithari;

import in.meenasubramanian.kaithari.serviece.UserServiece;

public class App {

	public static void main(String[] args) {
		UserServiece userServiece = new UserServiece();
		userServiece.create();
		userServiece.getAll();
		

	}

}
