package com.todolist.service;

import java.util.List;

import com.todolist.model.Task;

public interface TaskService {
	
	public List<Task> findAllTasks();

	public Task findTask(int index);

	public void deleteTask(int index);
	 
	public void saveOrUpdateTask(final Task task);
}
