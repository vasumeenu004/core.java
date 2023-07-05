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
	public void testCreateTaskWithValidInput() {
		TaskServiece taskservice = new TaskServiece();

		Task newTask = new Task();

		newTask.setId(12345);
		newTask.setName("Write");
		String date = "06-07-2023";
		LocalDate convert = TaskServiece.convertToDate(date);
		newTask.setDueDate(convert);
		newTask.setActive(true);

		assertDoesNotThrow(() -> {
			taskservice.create(newTask);
		});
	}

	@Test
	public void testCreateTaskWithInValidInput() {
		TaskServiece taskservice = new TaskServiece();

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskservice.create(null);
		});

		String expectedMessage = "Invalid Task Input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));	
		}

	// dueDate test case
	@Test
	public void testCreateUserWithNameNull() {
		TaskServiece taskservice = new TaskServiece();

		Task newTask = new Task();

		newTask.setId(12345);
		newTask.setName(null);
		String date = "06-07-2023";
		LocalDate convert = TaskServiece.convertToDate(date);
		newTask.setDueDate(convert);
		newTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskservice.create(newTask);
		});
		String expectedMessage = "name cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));

	}
	
	
	@Test
	public void testCreateUserWithNameEmpty() {
		TaskServiece taskservice = new TaskServiece();

		Task newTask = new Task();

		newTask.setId(12345);
		newTask.setName("");
		String date = "06-07-2023";
		LocalDate convert = TaskServiece.convertToDate(date);
		newTask.setDueDate(convert);
		newTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskservice.create(newTask);
		});
		String expectedMessage = "name cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));

	}
	
	@Test
	public void testCreateUserWithInvalidDueDate() {
		TaskServiece taskservice = new TaskServiece();

		Task newTask = new Task();

		newTask.setId(12345);
		newTask.setName("Write");
		String date = "06-08-2022";
		LocalDate convert = TaskServiece.convertToDate(date);
		newTask.setDueDate(convert);
		newTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskservice.create(newTask);
		});
		String expectedMessage = "due date Invalid";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));

	}
}
