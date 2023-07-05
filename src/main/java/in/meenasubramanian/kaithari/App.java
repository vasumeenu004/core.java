package in.meenasubramanian.kaithari;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.model.User;
import in.meenasubramanian.kaithari.serviece.TaskServiece;
import in.meenasubramanian.kaithari.serviece.UserServiece;

public class App {

	public static void main(String[] args) {
		try {
			UserServiece userServiece = new UserServiece();

			User newUser = new User();
			newUser.setId(186540);
			newUser.setEmail("meenu2004@gmail.com");
			newUser.setFirstName("Meena");
			newUser.setLastName("Subramanian");
			newUser.setActive(true);
			newUser.setPassword("Meenu@2343");

			userServiece.create(newUser);
			userServiece.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TaskServiece taskService = new TaskServiece();
	 		Task newTask = new Task();
	 		newTask.setId(1879);
	 		String date = "09-07-2023";
			LocalDate convert = taskService.convertToDate(date);
	 		newTask.setDueDate(convert);
	 		newTask.setName("New");
	 		newTask.setActive(true);

			taskService.create(newTask);
			taskService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TaskServiece taskservice = new TaskServiece();
		try {
			Task newTask = new Task();
			newTask.setId(12345);
			newTask.setName("Write");
			String date = "09-07-2023";
			LocalDate convert = taskservice.convertToDate(date);
			newTask.setDueDate(convert);
			newTask.setActive(true);
			
			taskservice.create(newTask);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
