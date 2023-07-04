package in.meenasubramanian.kaithari.validation;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.util.StringUtil;

public class UserValidator {
	public static void validate(User user) throws ValidationException {
		if (user == null) {
			throw new ValidationException("Invalid User Input");
		}
//		if (user.getEmail() == null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("Email cannot be null (or) empty");
//		}
		
//		if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
//			throw new ValidationException("Password cannot be null (or) empty");
//		}
		
//		if (user.getFirstName() == null || "".equals(user.getFirstName().trim())) {
//			throw new ValidationException("FirstName cannot be null (or) empty");
//		}
		StringUtil.rejectIfInvalidString(user.getEmail(),"Email");
		StringUtil.rejectIfInvalidString(user.getPassword(),"Password");
		StringUtil.rejectIfInvalidString(user.getFirstName(),"FirstName");
	}
}
