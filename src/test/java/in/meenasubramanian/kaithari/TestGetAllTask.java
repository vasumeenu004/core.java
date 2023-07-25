package in.meenasubramanian.kaithari;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.meenasubramanian.kaithari.exception.ValidationException;
import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.serviece.TaskServiece;
public class TestGetAllTask {

	@Test
	public void testGetAllTasks() {
		TaskServiece taskservice = new TaskServiece();
		List<Task> taskList = new ArrayList<Task>(taskservice.getAll());
		System.out.println(taskList);
	}

	@Test
	public void testUpdateTask() throws ValidationException {
		TaskServiece taskservice = new TaskServiece();
		Task newTask = new Task();

		newTask.setTaskName("Dance");
		newTask.setDueDate(LocalDate.of(2023, 11, 28));

		taskservice.update(3, newTask);
	}

	@Test
	public void testDeleteTask() {
		TaskServiece taskservice = new TaskServiece();
		taskservice.delete(3);
	}

	@Test
	public void testFindById() {
		TaskServiece taskservice = new TaskServiece();

		Task task = taskservice.findById(2);
		System.out.println(task);
	}

	@Test
	public void testFindByDuedate() {
		TaskServiece taskservice = new TaskServiece();
		List<Task> task = taskservice.findByDuedate(LocalDate.parse("2023-11-06"));
		
		System.out.println(task);

	}
}