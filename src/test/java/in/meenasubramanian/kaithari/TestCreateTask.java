package in.meenasubramanian.kaithari;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.serviece.TaskServiece;

public class TestCreateTask {
	@Test
    public void testCreateTaskWithValidataInput() {
        TaskServiece taskService = new TaskServiece();
        Task newTask = new Task();
        newTask.setId(1);
        newTask.setDueDate("2023-07-10");
        newTask.setName("Practice");
        newTask.setActive(true);

        assertDoesNotThrow(() -> {
            taskService.create(newTask);
        });
    }
	@Test
	public void testCreateTaskWithInvalidataInput() {
		TaskServiece taskService = new TaskServiece();
		Exception exception = assertThrows(ValidationException.class,()->{
			taskService.create(null);
		});
		String expectedMessage = "Invalid Task Input";
		String actualMessage = exception.getMessage();
		
		assertTrue(expectedMessage.equals(actualMessage));
	}
	 @Test
		public void testCreateTaskWithNameNull() {
		 TaskServiece taskService = new TaskServiece();
		    Task newTask = new Task();
	 		newTask.setId(1);
	 		newTask.setDueDate("2023-07-10");
	 		newTask.setName(null);
	 		newTask.setActive(true);
			
			Exception exception = assertThrows(Exception.class,()->{
				taskService.create(newTask);
			});
			String expectedMessage = "Name cannot be null or empty";
			String actualMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(actualMessage));
		}	
	    @Test
		public void testCreateUserWithFirstNameEmpty() {
	    	TaskServiece taskService = new TaskServiece();
	    	Task newTask = new Task();
	 		newTask.setId(1);
	 		newTask.setDueDate("2023-07-10");
	 		newTask.setName("");
	 		newTask.setActive(true);
			
			Exception exception = assertThrows(Exception.class,()->{
				taskService.create(newTask);
			});
			String expectedMessage = "Name cannot be null or empty";
			String actualMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(actualMessage));
		}
	    @Test
		public void testCreateTaskWithDueDateNull() {
		 TaskServiece taskService = new TaskServiece();
		    Task newTask = new Task();
	 		newTask.setId(1);
	 		newTask.setDueDate(null);
	 		newTask.setName("New");
	 		newTask.setActive(true);
			
			Exception exception = assertThrows(Exception.class,()->{
				taskService.create(newTask);
			});
			String expectedMessage = "DueDate cannot be null or empty";
			String actualMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(actualMessage));
		}	
	    @Test
		public void testCreateUserWithDueDateEmpty() {
	    	TaskServiece taskService = new TaskServiece();
	    	Task newTask = new Task();
	 		newTask.setId(1);
	 		newTask.setDueDate("");
	 		newTask.setName("Practice");
	 		newTask.setActive(true);
			
			Exception exception = assertThrows(Exception.class,()->{
				taskService.create(newTask);
			});
			String expectedMessage = "DueDate cannot be null or empty";
			String actualMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(actualMessage));
		}
}
