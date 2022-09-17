package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.test.model.User;
import com.example.test.service.UserService;

@Controller
public class TestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav = new ModelAndView("index");
		List<User> users = userService.findAll();
		mav.addObject("users", users);
		return mav;
	}

	@GetMapping(value="addEmployeeForm")
	public ModelAndView addUserForm() {
		ModelAndView mav = new ModelAndView("add-user-form");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return "redirect:/";
	}

	@GetMapping(value="showUserForm/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "add-user-form";
	}	

}
