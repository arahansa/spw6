package demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.controller.HelloController;
import demo.controller.HelloController.User;
import demo.domain.Dept;
import demo.domain.Emp;
import demo.repository.DeptRepository;
import demo.repository.EmpRepository;
import lombok.Data;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Springweb6pApplication.class)
@WebAppConfiguration
public class Springweb6pApplicationTests {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired 
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc;
	
	@Autowired DeptRepository deptRepository;
	@Autowired EmpRepository empRepository;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		empRepository.deleteAll();
    	deptRepository.deleteAll();
    	
        
        for(int i=1;i<=15;i++){
        	Dept d = new Dept();
        	d.setName("IT"+i);
        	deptRepository.save(d);
        	
        	Emp e = new Emp();
        	e.setName("직원"+ i);
        	e.setDept(d);
        	empRepository.save(e);
        }
	}
	
	@Test
	public void hello() throws Exception {
		mockMvc.perform(get("/hello?name=May"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("getMay"));
		
		mockMvc.perform(post("/hello").param("name", "May"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("postMay"));
		
		User user = new User();
		user.setName("May");
		user.setAge(10);
		
		mockMvc.perform(post("/helloUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)))
			.andDo(print())
			.andExpect(status().isOk())
			//.andExpect(header().string("authKey", "hm?"))
			//.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.name").value("May"))
			.andExpect(jsonPath("$.age").value(10))
			;
			//.andExpect(content().string("postMay"));
			
	}
	
	@Test
	public void depts() throws Exception {
		mockMvc.perform(get("/depts"))
			.andDo(print());
	}
	
	@Test
	public void emps() throws Exception {
		mockMvc.perform(get("/emps"))
			.andDo(print());
	}


}
