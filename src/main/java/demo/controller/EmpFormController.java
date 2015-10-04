package demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.domain.Dept;
import demo.domain.Emp;
import demo.repository.DeptRepository;
import demo.repository.EmpRepository;

@Controller
@RequestMapping("/emp")
public class EmpFormController {
	
	@Autowired EmpRepository empRepository;
	@Autowired DeptRepository deptRepository;
	
	@ModelAttribute("depts")
	public List<Dept> getDepts(){
		return deptRepository.findAll();
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(@ModelAttribute Emp emp){
		return "empadd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSubmit(@ModelAttribute @Valid Emp emp, BindingResult errors){
		if(emp.getName()!=null && emp.getName().length() < 2 ){
			errors.rejectValue("name", null, "필수항목입니다.");
		}
		if(errors.hasErrors()) return "empadd";
		System.out.println("직원 정보 "+emp);
		empRepository.save(emp);
		return "redirect:../emp"; //신기함
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String editForm(@PathVariable Long id, Model model){
		Emp d  = empRepository.findOne(id);
		model.addAttribute("emp", d);
		return "empedit";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String editSubmit(@PathVariable Long id, 
							@ModelAttribute @Valid Emp emp, BindingResult errors ){
		
		if(emp.getName()!=null && emp.getName().length() < 2 ){
			errors.rejectValue("name", null, "필수항목입니다.");
		}
		if(errors.hasErrors()) return "empedit";
		empRepository.save(emp);
		return "redirect:../../emp";
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable Long id){
		empRepository.delete(id);
		return "redirect:../../emp";
	}

}
