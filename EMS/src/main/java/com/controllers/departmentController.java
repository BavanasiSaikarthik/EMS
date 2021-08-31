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

import com.dao.departmentDao;
import com.bean.department;

@Controller
@EnableWebMvc
public class departmentController {
	@Autowired
	departmentDao departmentdao;
	
	@RequestMapping("/addDepartment")
	public String registerDepartment(Model model) {
		model.addAttribute("newDepartment",new department());
		return "addnewDepartment";
	}
	
	@RequestMapping("/addnewDepartment")
	public String addDepartment(@Valid @ModelAttribute("newDepartment")department Department, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "addnewDepartment";
		}
		departmentdao.addDepartment(Department);
		return "adminPage";
		}
	@RequestMapping("/viewDepartments")
	public String viewDepartments(Model model) {
		model.addAttribute("departments",departmentdao.getDepartments());
		return "viewDepartments";
	}
}
