package com.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;

import com.dao.statusreportDao;
import com.dao.complianceDao;
import com.bean.statusreport;
import com.bean.compliance;
import com.bean.user;
@Controller
@EnableWebMvc
public class statusreportController {

	@Autowired
	statusreportDao statusreportdao;
	@Autowired
	complianceDao compliancedao;
	
	@RequestMapping("/comment/{complianceId}/{userId}")
	public String addComment(@PathVariable int complianceId,@PathVariable int userId,Model model) {
		model.addAttribute("regulation",compliancedao.getCompliance(complianceId));
		model.addAttribute("userId", userId);
		model.addAttribute("newcomment",new statusreport());
		return "submitcomment";
	}
	@RequestMapping("/comment/{complianceId}/{deptId}/{userId}")
	public String submitComment(@Valid @ModelAttribute("newcomment")statusreport comment, BindingResult bindingResult,@PathVariable int complianceId,@PathVariable int deptId,@PathVariable int userId,Model model) {
		statusreportdao.getreport(complianceId,userId);
		comment.setDeptId(deptId);
		comment.setEmpId(userId);
		comment.setComplianceId(complianceId);
		comment.setDate(LocalDate.now().toString());
		statusreportdao.mergeReport(comment);
		model.addAttribute("user", new user());
		return "redirect:/";
	}
	@RequestMapping("/submit/{complianceId}/{userId}")
	public String add_Comment(@PathVariable int complianceId,@PathVariable int userId,Model model) {
		model.addAttribute("regulation",compliancedao.getCompliance(complianceId));
		model.addAttribute("userId", userId);
		model.addAttribute("newcomment",new statusreport());
		return "submit_comment";
	}
	@RequestMapping("/submit/{complianceId}/{deptId}/{userId}")
	public String submit_Comment(@Valid @ModelAttribute("newcomment")statusreport comment, BindingResult bindingResult,@PathVariable int complianceId,@PathVariable int deptId,@PathVariable int userId,Model model) {
		comment.setDeptId(deptId);
		comment.setEmpId(userId);
		comment.setComplianceId(complianceId);
		comment.setDate(LocalDate.now().toString());
		statusreportdao.addReport(comment);
		model.addAttribute("user", new user());
		return "redirect:/";
	}
	
}
