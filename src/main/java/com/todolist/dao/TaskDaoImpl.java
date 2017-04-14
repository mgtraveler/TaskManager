package com.todolist.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.todolist.model.Task;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao{
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks() {
		Criteria criteria = createEntityCriteria();
		return (List<Task>) criteria.list();
	}

	@Override
	public Task findTaskByIndex(int index) {
		return getByKey(index);
	}

	@Override
	public void deleteTaskByIndex(int index) {
		Query query = getSession().createSQLQuery("delete from tasks where task_index = :taskIndex");
		query.setInteger("taskIndex", index);
		query.executeUpdate();
	}
	
	@Override
	public void saveTask(final Task task) {
		persist(task);
	}
}
