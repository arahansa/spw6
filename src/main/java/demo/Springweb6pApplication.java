package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springweb6pApplication {

    public static void main(String[] args) {
        
    	ConfigurableApplicationContext ac = SpringApplication.run(Springweb6pApplication.class, args);
        DeptRepository dr = ac.getBean(DeptRepository.class);
        dr.deleteAll();
        for(int i=1;i<=15;i++){
        	Dept d = new Dept();
        	d.setName("IT"+i);
        	dr.save(d);
        }
    }
}
