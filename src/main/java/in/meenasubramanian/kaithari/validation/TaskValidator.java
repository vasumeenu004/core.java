package in.meenasubramanian.kaithari.validation;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.util.StringUtil;

public class TaskValidator {
public static void validate(Task newTask) throws ValidationException {

		if(newTask == null) {
			throw new ValidationException("Invalid Task Input");
		}

		StringUtil.rejectIfInvalidString(newTask.getTaskName(), "Taskname");
		StringUtil.rejectIfInvalidDate(newTask.getDueDate(), "Duedate ");




	}

}