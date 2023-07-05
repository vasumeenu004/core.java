package in.meenasubramanian.kaithari.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.util.StringUtil;

public class TaskValidator {
	  
    public static void Validate(Task task) throws Exception {
        if (task == null) {
            throw new ValidationException("Invalid Task Input");
        }
        
        StringUtil.rejectIfInvalidString(task.getName(), "name");
        StringUtil.rejectIfInvalidDate(task.getDueDate(), "due date");
    }
}
