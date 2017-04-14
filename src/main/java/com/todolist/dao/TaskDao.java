package com.todolist.dao;

import java.util.List;

import com.todolist.model.Task;

public interface TaskDao {
	
	public List<Task> findAllTasks();

	public Task findTaskByIndex(int index);

	public void deleteTaskByIndex(int index);
	
	public void saveTask(final Task task);
}
