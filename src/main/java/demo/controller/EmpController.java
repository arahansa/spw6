package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.repository.EmpRepository;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired EmpRepository empRepository;

	@RequestMapping()
	public String dept(Model model){
		model.addAttribute("emps", empRepository.findAll());
		return "emplist";
	}
}
