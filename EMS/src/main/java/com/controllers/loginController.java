package com.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dao.userDao;
import com.bean.user;
import com.dao.statusreportDao;
import com.bean.statusreport;
import com.dao.complianceDao;
import com.bean.compliance;
import com.bean.regulation;
@Controller
@EnableWebMvc
public class loginController {

	@Autowired
	userDao UserDao;
	@Autowired
	statusreportDao statusreportdao;
	@Autowired
	complianceDao compliancedao;
	
	@RequestMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("user",new user());
		return "login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@Valid @ModelAttribute("user")user user, BindingResult bindingResult, Model model, HttpSession httpSession) {
		if(bindingResult.hasErrors()) {
			return "login";
		}
		int status = UserDao.validateUser(user);
		System.out.println(status);
		if(status==-1) {
			model.addAttribute("message","Wrong credentials entered!");
			return "login";
		}
		else {
			httpSession.setAttribute("userId",status);
			String role=UserDao.getRole(user);
			if (role.equals("employee")){
				List<compliance> notresponded=new ArrayList<compliance>();
				HashMap<Integer,regulation> responded=new HashMap<Integer,regulation>();
				List<statusreport> statusreports = statusreportdao.getStatus(status);
				for(int i=0;i<statusreports.size();i++) {
					if(statusreports.get(i).getComment().equals("*")) {
						notresponded.add(compliancedao.getCompliance(statusreports.get(i).getComplianceId()));
					}
					else {
						if(!responded.containsKey(Integer.valueOf(statusreports.get(i).getComplianceId()))){
						regulation temp=new regulation();
						temp.setRegulationName(compliancedao.getCompliance(statusreports.get(i).getComplianceId()));
						temp.setStatusreports(statusreportdao.getReports(statusreports.get(i).getComplianceId()));
						responded.put(Integer.valueOf(statusreports.get(i).getComplianceId()), temp);
						}
					}
				}
				model.addAttribute("responded",responded);
				model.addAttribute("notresponded",notresponded);
				model.addAttribute("currentuser",status);
				return "employeePage";
			}
			else {
				return "adminPage";
			}
		}
	}

	@RequestMapping("/registerAdmin")
	public String registerAdimn(Model model) {
		model.addAttribute("adminRegister",new user());
		return "registerAdmin";
	}
	@RequestMapping("/registerUser")
	public String registerUser(Model model) {
		model.addAttribute("registerUser",new user());
		return "registerUser";
	}
	@RequestMapping("/registernewAdmin")
	public String addAdmin(@Valid @ModelAttribute("registerAdmin")user adminRegister, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "registerAdmin";
		}
		adminRegister.setRole("admin");
		String message = UserDao.addUser(adminRegister);
		if (message.equals("sucess")) {
			model.addAttribute("user",new user());
			return "login";
		}
		model.addAttribute("registerMessage", message);
		model.addAttribute("adminRegister",new user());
		return "registerAdmin";
	}
	@RequestMapping("/registernewUser")
	public String addUser(@Valid @ModelAttribute("registerUser")user registerUser, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "registerUser";
		}
		registerUser.setRole("employee");
		String message = UserDao.addUser(registerUser);
		if (message.equals("sucess")) {
			model.addAttribute("user",new user());
			return "login";
		}
		model.addAttribute("registerMessage", message);
		model.addAttribute("registerUser",new user());
		return "registerUser";
	}
}
