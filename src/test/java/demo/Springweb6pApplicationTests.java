package demo;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Springweb6pApplicationTests {

	@Before
	public void setUp() {
		System.out.println("셋업");
	}
	
	@Test
	public void contextLoads() {
		System.out.println("3번째");
	}

	@Test
	public void b_test() {
		System.out.println("2번째");
	}

	@Test
	public void a_test(){
		System.out.println("1번째~ ");
	}
	@Test
	public void a_atest(){
		System.out.println("01번째~ ");
	}

}
