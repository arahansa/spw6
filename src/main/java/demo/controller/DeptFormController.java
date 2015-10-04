package demo.controller;

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
import demo.domain.Level;
import demo.repository.DeptRepository;

@Controller
@RequestMapping("/dept")
public class DeptFormController {

	@Autowired DeptRepository deptRepository;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("dept", new Dept());
		// model.addAttribute("levels", Level.values()); 
		// 여러 군데에서 동시 필요로 할 경우가 있으므로, 모델어트리뷰트로 뺀다. 
		return "deptadd";
	}
	
	@ModelAttribute("levels")
	public Level[] levels(){
		return Level.values();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSubmit(@ModelAttribute @Valid Dept dept, BindingResult errors){
		if(dept.getName()!=null && dept.getName().length() < 2 ){
			errors.rejectValue("name", null, "필수항목입니다.");
		}
		if(errors.hasErrors()) return "deptadd";
		deptRepository.save(dept);
		return "redirect:../dept"; //신기함
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String editForm(@PathVariable Long id, Model model){
		Dept d  = deptRepository.findOne(id);
		model.addAttribute("dept", d);
		return "deptedit";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String editSubmit(@PathVariable Long id, 
							@ModelAttribute @Valid Dept dept, BindingResult errors ){
		
		if(dept.getName()!=null && dept.getName().length() < 2 ){
			errors.rejectValue("name", null, "필수항목입니다.");
		}
		if(errors.hasErrors()) return "deptedit";
		deptRepository.save(dept);
		return "redirect:../../dept";
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable Long id){
		deptRepository.delete(id);
		return "redirect:../../dept";
	}
	
	
	
}
