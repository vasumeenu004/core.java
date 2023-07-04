package in.meenasubramanian.kaithari.util;

import in.meenasubramanian.kaithari.exception.ValidationException;

public class StringUtil {
	public static void rejectIfInvalidString(String input,String inputName) throws ValidationException {
		if(input == null || "".equals(input)){
			throw new ValidationException(inputName.concat(" cannot be null or empty"));
		}
 	}
  public static boolean isValid(String input) {
	  if(input == null || "".equals(input.trim())) {
		 
       return true;
	  }else{
	   return false;
	  }
  }
  public static boolean isInValid(String input)throws ValidationException {
	  if(input == null || "".equals(input.trim())) {
       return false;
	  }else{
	   return true;
	  }
  }
}
