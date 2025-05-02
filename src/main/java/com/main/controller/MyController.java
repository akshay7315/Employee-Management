package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Employee;
import com.main.service.EmployeeService;


@Controller
public class MyController {
	
	@Autowired
	private EmployeeService s1;
	
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("employee",new Employee());
		return "Home";
	}
	
	@GetMapping("/add")
	public Employee addpage(Employee e) {
		return s1.add(e);
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Employee e) {
		 s1.add(e);
		 return "redirect:/Savemsg";
	}
	
	@GetMapping("/Savemsg")
	public String savemsg() {
		return "Savemsg";
	}
	//------------------add end ------------------
	@GetMapping("/View")
	public String viewall(Model model)
	{
		List<Employee> employee = s1.viewall();
		model.addAttribute("employee",employee);
		return "View";
	}

	//-------------fetch end  -----------------------
	@GetMapping("/update")
	public String updatefrom(Model model) {
		model.addAttribute("employee",new Employee());
		return "update";
	}
	
	@PostMapping("/update1")
	public String update(Employee e) {
		s1.update(e);
		 return "redirect:/View";
	}
	
	@GetMapping("/delete")
	public String deletefrom(Model model)
	{
		List<Employee> employee = s1.viewall();
		model.addAttribute("employee",employee);
		return "delete";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
	 s1.delete(id);
	 return "msg";
		
	}
	
	@GetMapping("/company")
	public String company(Model model) {
		model.addAttribute(model);
		return "company";
	}
	
	@GetMapping("/report")
	public String ProjectReport(Model model) {
		model.addAttribute(model);
		return "Report";
	}
	
	
	

}
