package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;

@Controller
public class HelloController {
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody
	public String helloGet(String name){
		return "get"+name;
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	@ResponseBody
	public String helloPost(String name){
		return "post"+name;
	}
	
	@RequestMapping(value="/helloUser", method=RequestMethod.POST)
	@ResponseBody
	public User helloPost(@RequestBody User user){
		return user;
	}
	
	@Data
	public static class  User{
		String name;
		int age;
	}
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}

}
