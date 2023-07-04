package in.meenasubramanian.kaithari.dao;

import in.meenasubramanian.kaithari.model.Task;
public class TaskDAO {
    public Task[] findAll() {
  	  Task[] newTask = TaskList.listOfTask;
  	  return newTask;
    }
    
    public void create(Task newTask) {
  	  Task[] arr = TaskList.listOfTask;
  	  for(int i=0; i<arr.length; i++) {
  		  Task task = arr[i];
  		  if(task == null) {
  			  arr[i] = newTask;
  			  break;
  		  }
  	  }
    }
    
    public void update(int id, Task updateTask) {
  	  Task[] arr = TaskList.listOfTask;
  	  for(int i=0; i<arr.length; i++) {
  		  Task task = arr[i];
  		  if(task == null) {
  			  continue;
  		  }
  		  if(task.getId() == id) {
  			  arr[i].setName(updateTask.getName());
  			  arr[i].setDueDate(updateTask.getDueDate());
  			  break;
  		  }
  	  }
    }
    
    public void delete(int id) {
  	  Task[] arr = TaskList.listOfTask;
  	  for(int i=0; i<arr.length; i++) {
  		  Task task = arr[i];
  		  if(task == null) {
  			  continue;
  		  }
  		  if(task.getId() == id) {
  			arr[i].setActive(false);
  			  break;
  		  }
  	  }
    }
    
    public Task findById(int id) {
  	  Task[] arr = TaskList.listOfTask;
  	  Task taskMatch = null;
  	  for(int i=0; i<arr.length; i++) {
  		  Task task = arr[i];
  		  if(task == null) {
  			  continue;
  		  }
  		  if(task.getId() == id) {
  			 taskMatch = task;
  			  break;
  		  }
  	  }
  	  return taskMatch;
    }
}
