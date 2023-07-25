package in.meenasubramanian.kaithari.Interface;

import in.meenasubramanian.kaithari.model.User;

public interface UserInterface extends Base<User>{

	public abstract User findByEmail(String email);

	public abstract int count();






}
