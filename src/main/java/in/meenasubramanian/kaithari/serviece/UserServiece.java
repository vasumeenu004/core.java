package in.meenasubramanian.kaithari.serviece;

import java.util.List;

import in.meenasubramanian.kaithari.dao.UserDAO;
import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.validation.UserValidator;


public class UserServiece {
	UserDAO userdao = new UserDAO();

	public void create(User user) throws ValidationException, RuntimeException {
		UserValidator.validate(user);
		userdao.create(user);
	}

	public int count() {
		
		return userdao.count();

	}

	public void update(int newId, User newUser) throws ValidationException {

		UserValidator.validate(newUser);

		userdao.update(newId, newUser);

	}

	public void delete(int Id) {

		userdao.delete(Id);

	}

	public User findById(int newId) {

		return userdao.findById(newId);
		

	}

	public User findByEmail(String Email) {

		return userdao.findByEmail(Email);

	}

	public List<User> getAll() {

		return userdao.findAll();

	}

}