package in.meenasubramanian.kaithari.model;

import java.time.LocalDate;

public class Task extends TaskEntity {

	public Task(int taskID, String taskName, LocalDate dueDate, boolean isActive) {
		super();
		this.taskID = taskID;
		this.taskName = taskName;
		this.dueDate = dueDate;
		this.isActive = isActive;
	}

	public Task() {

	}
}