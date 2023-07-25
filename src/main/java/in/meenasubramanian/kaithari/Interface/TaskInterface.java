package in.meenasubramanian.kaithari.Interface;

import java.time.LocalDate;
import java.util.List;

import in.meenasubramanian.kaithari.model.Task;


public interface TaskInterface extends Base<Task> {

	public abstract int count();
	public abstract List<Task> findByDuedate(LocalDate date);

}