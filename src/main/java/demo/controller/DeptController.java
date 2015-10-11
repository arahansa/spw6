package demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.domain.Dept;
import demo.repository.DeptRepository;
import lombok.Data;

@Controller
public class DeptController {
	
	@Autowired DeptRepository deptRepository;
	
	@RequestMapping("/dept")
	public String dept(Model model){
		model.addAttribute("depts", deptRepository.findAll());
		return "deptlist";
	}
	
	@RequestMapping("/depts")
	@ResponseBody
	public List<DeptView> depts(){
		List<Dept> depts = deptRepository.findAll();
		
		/*List<DeptView> deptViews = depts.stream().map(d -> {
		
		 * 	DeptView dv = new DeptView();
			dv.setId(d.getId());
			dv.setName(d.getName());
			return dv;
			DeptView dv = mapper.map(d, DeptView.class);
			return dv;
		}).collect(Collectors.toList());*/
		List<DeptView> deptViews = 
				depts.stream().map(d->mapper.map(d, DeptView.class))
				.collect(Collectors.toList());
		return deptViews;
	}
	
	ModelMapper mapper = new ModelMapper();
	
	@Data
	public static class DeptView{
		Long id;
		String name;
	}
	
}
