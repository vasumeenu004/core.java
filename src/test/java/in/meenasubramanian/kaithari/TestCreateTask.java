package in.meenasubramanian.kaithari;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.serviece.TaskServiece;

public class TestCreateTask {


	

	@Test
	public void testCreateTaskWithValidData() {
		TaskServiece taskService = new TaskServiece();

		Task newTask = new Task();

		newTask.setTaskID(12345);
		String userInput = "23/07/2023";

		newTask.setTaskName("Open the Door");
		LocalDate convertedDate = TaskServiece.convertToDate(userInput);
		newTask.setDueDate(convertedDate);
		newTask.setActive(true);

		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});

	}

	@Test
	public void testCreateTaskWithInvalidData() {
		TaskServiece taskService = new TaskServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String expectedMessage = "Invalid Task Input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithTaskNameNull() {
		TaskServiece taskService = new TaskServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {

			Task newTask = new Task();

			newTask.setTaskID(12345);
			String userInput = "23/07/2023";

			newTask.setTaskName(null);
			LocalDate convertedDate = TaskServiece.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);

			taskService.create(newTask);
		});
		String expectedMessage = "Taskname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithTaskNameEmpty() {
		TaskServiece taskService = new TaskServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {

			Task newTask = new Task();

			newTask.setTaskID(12345);
			String userInput = "23/07/2023";
			newTask.setTaskName("");
			LocalDate convertedDate = TaskServiece.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);

			taskService.create(newTask);
		});
		String expectedMessage = "Taskname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithInvalidDate() {
		TaskServiece taskService = new TaskServiece();
		Exception exception = assertThrows(ValidationException.class, () -> {

			Task newTask = new Task();

			newTask.setTaskID(99999);
			String userInput = "23/07/2022";

			newTask.setTaskName("Close The Door");
			LocalDate convertedDate = TaskServiece.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);

			taskService.create(newTask);
		});
		String expectedMessage = "Due Date can not be in the Past";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}