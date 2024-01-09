package com.taskmanager.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskmanager.entities.Task;
import com.taskmanager.entities.TaskList;
import com.taskmanager.entities.User;
import com.taskmanager.repository.TaskListRepo;
import com.taskmanager.repository.TaskRepo;
import com.taskmanager.repository.UserRepo;

@Controller
@RequestMapping("/user")
public class TaskController{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TaskRepo taskRepo;
	@Autowired
	private TaskListRepo taskListRepo;
	
	@GetMapping("/dash")
	public String dashboard(Model model, Principal p, User user) {
		User username = userRepo.getUserByUsername(p.getName());
		List<TaskList> list = taskListRepo.getTaskListByUser(userRepo.getUserByUsername(p.getName()));

		System.out.println(list);
		model.addAttribute("taskList", list);
		model.addAttribute("user", username);
		return "task/dash";
	}
	
	@GetMapping("/add-task")
	public String addTaskForm(Model model) {
		
		model.addAttribute("task", new Task());
		return "task/addTask";
	}
	@PostMapping("/adding-task/{id}")
	public String addTaskProcess(@PathVariable("id") int id,@ModelAttribute("task") Task task,Principal p) {
		task.setList(taskListRepo.findById(id));
		taskRepo.save(task);
		return "redirect:/user/dash";
	}
	
	@GetMapping("/add-taskList")
	public String addTaskListForm(Model model) {
		model.addAttribute("taskList", new TaskList());
		return "task/addTaskList";
	}
	@PostMapping("/adding-taskList")
	public String addTaskListProcess(@ModelAttribute("task") TaskList taskList, Principal p) {
		taskList.setUser(userRepo.getUserByUsername(p.getName()));
		taskListRepo.save(taskList);
		return "redirect:/user/dash";
	}
	
}
















