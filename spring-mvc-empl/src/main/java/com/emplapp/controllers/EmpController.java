package com.emplapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emplapp.model.Employee;

@Controller
public class EmpController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/showForm")
	public String ShowForm(ModelMap map){
		return "showEmpForm";
	}
	// Using RequestParam
	/*@RequestMapping("/addEmployee")
	public String addEmployee(
			@RequestParam("name") String name,
			@RequestParam("city") String city,
			@RequestParam("salary") Integer salary,
			ModelMap map){
		Employee employee = new Employee();
		employee.setName(name);
		employee.setCity(city);
		employee.setsalary(salary);
		map.addAttribute("employee",employee);
		System.out.println(employee);
		return "empsuccess";
	}*/
	
//	// Using @ModelAttribute
//	@RequestMapping("/addEmployee")
//	public String addEmployee(@ModelAttribute Employee employee){
//		System.out.println("emp: "+employee);
//		return "empsuccess";
//	}
	
	// Using Binding Result
		@RequestMapping("/addEmployee")
		public String addEmployee(@ModelAttribute Employee employee,
				BindingResult result){
			System.out.println(employee.getName());
			if(result.hasErrors()){
				System.out.println(result.getAllErrors());
				return "showEmpForm";
			}
			System.out.println("emp: "+employee);
			return "empsuccess";
		}
}












