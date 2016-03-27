package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.domain.MultipleParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/multiple")
public class MultipleParameterTestController {
	
	@RequestMapping("/test")
	public String multipleParameterTest(@ModelAttribute MultipleParam multipleParam){
		log.info("multiple Param : {} ", multipleParam);
		log.info("list : {} ", multipleParam.getMyLineList());
		return "/multiple/test";
	}
	

}
