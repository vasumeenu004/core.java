package in.meenasubramanian.kaithari.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import in.meenasubramanian.kaithari.Interface.TaskInterface;
import in.meenasubramanian.kaithari.model.Task;
import in.meenasubramanian.kaithari.util.ConnectionUtil;

public class TaskDAO implements TaskInterface {

	@Override
	public List<Task> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Task> taskList = new ArrayList<Task>();

		try {
			String query = "SELECT * FROM tasks Where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Task newTask = new Task();

				java.sql.Date sqlDate = rs.getDate("duedate");
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

				newTask.setDueDate(utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				newTask.setTaskID(rs.getInt("id"));
				newTask.setActive(rs.getBoolean("is_active"));
				newTask.setTaskName(rs.getString("task_name"));

				taskList.add(newTask);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return taskList;

		// return TaskList.taskList;
	}

	@Override
	public void create(Task newTask) throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO tasks(task_name, duedate) VALUES (? ,?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			Date sqlDate = Date.valueOf(newTask.getDueDate());
			ps.setString(1, newTask.getTaskName());
			ps.setDate(2, sqlDate);

			ps.executeUpdate();

			System.out.println("Task has been created sucessfully");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}

//		List<Task> taskList1 = TaskList.taskList;
//
//		boolean taskExists = false;
//
//		Iterator<Task> iterator = taskList1.iterator();
//		while (iterator.hasNext()) {
//			Task existingTask = iterator.next();
//			if (existingTask == null) {
//				iterator.remove();
//				taskList1.add(newTask);
//				taskExists = true;
//				break;
//			}
//		}
//
//		if (!taskExists) {
//			taskList1.add(newTask);
//		}

	}

	@Override
	public void update(int id, Task newTask) throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET task_name =?,duedate=? WHERE id =?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			Date sqlDate = Date.valueOf(newTask.getDueDate());

			ps.setString(1, newTask.getTaskName());
			ps.setDate(2, sqlDate);
			ps.setInt(3, id);

			int rowUpdated = ps.executeUpdate();

			if (rowUpdated > 0) {
				System.out.println("Task with ID " + id + " updated successfully.");
			} else {
				System.out.println("No task found with ID " + id + ". Nothing updated.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps);
		}

//		List<Task> taskList2 = TaskList.taskList;
//		Iterator<Task> iterator = taskList2.iterator();
//		while (iterator.hasNext()) {
//			Task existingTask = iterator.next();
//			if (existingTask.getTaskID() == id) {
//				iterator.remove();
//				taskList2.add(t);
//				break;
//			}
//		}

	}

	@Override
	public void delete(int id) throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET is_active =0 WHERE id =?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.executeUpdate();

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Task with ID " + id + " has been deactivated.");
			} else {
				System.out.println("No task found with ID " + id + ". Nothing changed.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error while deactivating task: " + e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}

//		List<Task> taskList2 = TaskList.taskList;
//
//		for (Task existingTask : taskList2) {
//			if (existingTask.getTaskID() == id) {
//				existingTask.setActive(false);
//				break;
//			}
//		}

	}

	@Override
	public Task findById(int taskId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Task task = null;

		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, taskId);// don't start with zero, 1 represent the 1st question mark
			rs = ps.executeQuery();

			if (rs.next()) {
				task = new Task();
				java.sql.Date sqlDate = rs.getDate("duedate");
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

				task.setTaskName(rs.getString("task_name"));
				task.setDueDate(utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				task.setTaskID(rs.getInt("id"));
				task.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return task;
	}


	@Override
	public List<Task> findByDuedate(LocalDate date) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Task> taskList = new ArrayList<Task>();

		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1 AND duedate = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			// convert LocalDate to java.sql.Date
			Date sqlDate = Date.valueOf(date);
			
			ps.setDate(1, sqlDate);// don't start with zero, 1 represent the 1st question mark
			rs = ps.executeQuery();

			while (rs.next()) {
				Task task = new Task();

				task.setTaskName(rs.getString("task_name"));
				Date sqlDate1 = rs.getDate("duedate");
				LocalDate dueDate = sqlDate1.toLocalDate();
				
				task.setDueDate(dueDate);
				task.setTaskID(rs.getInt("id"));
				task.setActive(rs.getBoolean("is_active"));
				taskList.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return taskList;

	}

	@Override
	public int count() {

		int count = 0;
		List<Task> taskList2 = TaskList.taskList;
		for (Task existingTask : taskList2) {
			if (existingTask != null) {

				count++;
			}
		}
		return count;
	}

}