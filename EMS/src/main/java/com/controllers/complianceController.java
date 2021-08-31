package com.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.HashMap;
import java.time.LocalDate;

import com.dao.complianceDao;
import com.bean.compliance;
import com.dao.employeeDao;
import com.bean.employee;
import com.dao.statusreportDao;
import com.bean.statusreport;
import com.bean.showregulation;
import com.bean.comments;
@Controller
@EnableWebMvc
public class complianceController {

	@Autowired
	complianceDao compliancedao;
	@Autowired
	employeeDao employeedao;
	@Autowired
	statusreportDao statusreportdao;
	
	@RequestMapping("/addRegulation")
	public String registerCompliance(Model model) {
		model.addAttribute("newRegulation",new compliance());
		return "addnewRegulation";
	}
	@RequestMapping("/addnewRegulation")
	public String addRegulation(@Valid @ModelAttribute("newRegulation")compliance Regulation, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "addnewRegulation";
		}
		Regulation.setDate(LocalDate.now().toString());
		compliancedao.addCompliance(Regulation);
		compliance lastcompliance=compliancedao.getlastCompliance();
		List<employee> employees= employeedao.getEmployee(lastcompliance.getDeptId());
		for(int i=0;i<employees.size();i++) {
			statusreport status = new statusreport();
			status.setComplianceId(lastcompliance.getComplianceId());
			status.setEmpId(employees.get(i).getEmpId());
			status.setDeptId(employees.get(i).getDeptId());
			status.setComment("1");
			status.setDate(LocalDate.now().toString());
			statusreportdao.addReport(status);
		}

			return "adminPage";
	}
	@RequestMapping("/viewRegulations")
	public String viewRegulations(Model model) {
		model.addAttribute("regulations",compliancedao.getCompliances());
		List<compliance> regulations=compliancedao.getCompliances();
		List<showregulation> regu_comm= new ArrayList<showregulation>();
		HashMap<Integer,String> usernames=new HashMap<Integer,String>();
		for(int i=0;i<regulations.size();i++) {
			showregulation temp = new showregulation();
			temp.setRegulation(regulations.get(i));
			List<statusreport> reports=statusreportdao.getReports(regulations.get(i).getComplianceId());
			List<comments> comments= new ArrayList<comments>();
			for(int j=0;j<reports.size();j++) {
				comments tempc=new comments();
				if(reports.get(i).getComment().equals("1")) {
					continue;
				}
				tempc.setComment(reports.get(i).getComment());
				tempc.setDate(reports.get(i).getDate());
				if(usernames.containsKey(reports.get(i).getEmpId())){
					tempc.setName(usernames.get(reports.get(i).getEmpId()));
				}
				else {
					usernames.put(reports.get(i).getEmpId(),employeedao.getName(reports.get(i).getEmpId()).getFirstname());
					tempc.setName(usernames.get(reports.get(i).getEmpId()));
				}
				comments.add(tempc);
			}
			temp.setComment(comments);
			regu_comm.add(temp);
		}
		model.addAttribute("regulations",regu_comm);
		return "viewRegulations";
	}
	
}
