package com.todolist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todolist.model.Task;
import com.todolist.service.TaskService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	TaskService service;
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTasks(ModelMap model) throws IOException {
		List<Task> tasks = service.findAllTasks();
		model.addAttribute("listTasks", tasks);
		return "home";
	}

	@RequestMapping(value = "/editTask", method = RequestMethod.GET)
	public String editTask(HttpServletRequest request, ModelMap model) {
		int taskIndex = Integer.parseInt(request.getParameter("id"));
		Task task = service.findTask(taskIndex);
		model.addAttribute("task", task);
		return "TaskForm";
	}

	@RequestMapping(value = {"/deleteTask"}, method = RequestMethod.GET)
	public String deleteTask(HttpServletRequest request) {
		int taskIndex = Integer.parseInt(request.getParameter("id"));
		service.deleteTask(taskIndex);
		return "redirect:/list";
	}

	@RequestMapping(value = {"/newTask"}, method = RequestMethod.GET)
	public String newTask(ModelMap model) {
		model.addAttribute("task", new Task());
		return "TaskForm";
	}

	@RequestMapping(value = {"/saveTask"}, method = RequestMethod.POST)
	public String saveTask(@ModelAttribute Task task) {
		service.saveOrUpdateTask(task);
		return "redirect:/list";
	}
}
