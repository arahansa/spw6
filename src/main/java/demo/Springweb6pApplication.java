package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import demo.domain.Dept;
import demo.domain.Emp;
import demo.repository.DeptRepository;
import demo.repository.EmpRepository;

@SpringBootApplication
public class Springweb6pApplication {

    public static void main(String[] args) {
        
    	ConfigurableApplicationContext ac = SpringApplication.run(Springweb6pApplication.class, args);
        
    	DeptRepository dr = ac.getBean(DeptRepository.class);
    	EmpRepository er = ac.getBean(EmpRepository.class);
    	er.deleteAll();
    	dr.deleteAll();
        
        
        
        for(int i=1;i<=15;i++){
        	Dept d = new Dept();
        	d.setName("IT"+i);
        	dr.save(d);
        	
        	Emp e = new Emp();
        	e.setName("직원"+ i);
        	e.setDept(d);
        	er.save(e);
        }
        
       
        
    }
}
