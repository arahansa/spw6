package demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dept")
public class DeptFormController {

	@Autowired DeptRepository deptRepository;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(@ModelAttribute Dept dept){
		return "deptadd";
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
