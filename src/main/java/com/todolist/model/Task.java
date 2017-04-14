package com.todolist.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = -7858133705308993477L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_index", nullable = false)
	private int taskIndex;

	@Size(min = 3, max = 70)
	@Column(name = "task_description", nullable = false)
	private String taskDescription;

	@Size(min = 3, max = 15)
	@Column(name = "task_status", nullable = false)
	private String taskStatus;

	public Task() {
		// required for adding new record on the TaskForm page
	}

	public Task(String taskDescription, String taskStatus) {
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
	}

	public int getTaskIndex() {
		return taskIndex;
	}

	public void setTaskIndex(int index) {
		this.taskIndex = index;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "Task [index=" + taskIndex + ", task_description=" + taskDescription + ", task_status=" + taskStatus
				+ "]";
	}

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		Task other = (Task) otherObject;
		return Objects.equals(taskDescription, other.taskDescription) && Objects.equals(taskStatus, other.taskStatus)
				&& taskIndex == other.taskIndex;
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskIndex, taskDescription, taskStatus);
	}
}