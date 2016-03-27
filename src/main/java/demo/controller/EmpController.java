package demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.controller.DeptController.DeptView;
import demo.repository.EmpRepository;
import lombok.Data;

@Controller
public class EmpController {

	@Autowired
	EmpRepository empRepository;

	@RequestMapping("/emp")
	public String dept(Model model) {
		model.addAttribute("emps", empRepository.findAll());
		return "emplist";
	}
	
	@RequestMapping("/emps")
	@ResponseBody
	public List<EmpView> emps(){
		return empRepository.findAll()
				.stream().map(e -> mapper.map(e, EmpView.class))
				.collect(Collectors.toList());
	}

	ModelMapper mapper = new ModelMapper();

	@Data
	public static class EmpView {
		Long id;
		String name;
		//String deptName; // dept.name
		DeptView dept; // "dept":{"id":337,"name":"IT1"}
		public int getLength(){
			return name.length(); // "length":3
		}
		public String getName2(){
			return "<div>"+name+"</div>";
		}
	}
}
