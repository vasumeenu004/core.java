package in.meenasubramanian.kaithari.model;

import java.time.LocalDate;

public class Task {

		@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", isActive=" + isActive + ", dueDate=" + dueDate + "]";
	}



		public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public LocalDate getDueDate() {
		return dueDate;
	}



	public void setDueDate(LocalDate convert) {
		this.dueDate = convert;
	}



		int id;
		String name;
		boolean isActive = true;
		LocalDate dueDate;
	
	

	

}
