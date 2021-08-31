package com.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dao.employeeDao;
import com.bean.employee;
import com.bean.user;

@Controller
@EnableWebMvc
public class employeeController {

	@Autowired
	employeeDao employeedao;
	
	@RequestMapping("/addEmployee")
	public String registerEmployee(Model model) {
		model.addAttribute("newEmployee",new employee());
		return "addnewEmployee";
	}
	@RequestMapping("/addnewEmployee")
	public String addEmployee(@Valid @ModelAttribute("newEmployee")employee Employee, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "addnewEmployee";
		}
		String message = employeedao.addEmployee(Employee);
		if (message.equals("sucess")) {
			return "redirect:/registerUser";
		}
		model.addAttribute("employeeMessage", message);
		model.addAttribute("newEmployee",new employee());
		return "addnewEmployee";
	}
	@RequestMapping("/viewEmployees")
	public String viewEmployees(Model model) {
		model.addAttribute("employees",employeedao.getEmployees());
		return "viewEmployees";
	}
}
