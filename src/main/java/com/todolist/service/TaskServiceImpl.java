package com.todolist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.TaskDao;
import com.todolist.model.Task;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao dao;
	
	@Override
	public List<Task> findAllTasks() {
		return dao.findAllTasks();
	}

	@Override
	public Task findTask(int index) {
		return dao.findTaskByIndex(index);
	}

	@Override
	public void deleteTask(int index) {
		dao.deleteTaskByIndex(index);
	}
	 
	@Override
	public void saveOrUpdateTask(final Task task) {
		if (task.getTaskIndex() != 0) {
			Task entity = dao.findTaskByIndex(task.getTaskIndex());
			entity.setTaskDescription(task.getTaskDescription());
			entity.setTaskStatus(task.getTaskStatus());
		} else {
			dao.saveTask(task);
		}
	}
}
