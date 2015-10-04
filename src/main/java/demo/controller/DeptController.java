package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.repository.DeptRepository;

@Controller
public class DeptController {
	
	@Autowired DeptRepository deptRepository;
	
	@RequestMapping("/dept")
	public String dept(Model model){
		model.addAttribute("depts", deptRepository.findAll());
		return "deptlist";
	}
	
}
