package demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestString {

	
	//@Test
	public void test(){
		System.out.println("하이");
		String s = "하이";
		System.out.println(s.hashCode());
		System.out.println("하이".equals(s));
		System.out.println(System.identityHashCode("하이"));
	}
	
	@Test
	public void testUser() throws Exception {
		TestUser testUser = new TestUser();
		System.out.println("테스트유저toString :: "+testUser + " , hex int :: "+testUser.hashCode());
		System.out.print("해쉬코드16진수변환 :: "+Integer.toHexString(testUser.hashCode()));
		System.out.println(" , Identity Hash :: " + System.identityHashCode(testUser));
		String hashString = testUser.toString();
		// hash코드 16진수 변환값과 toString해서 얻은 클래스 뒤의 16진수는 원래 같은 거다! 
		assertEquals(hashString.substring(hashString.indexOf("@")+1), Integer.toHexString(testUser.hashCode()));
		// hashCode()로 얻는 값과 System.identityHashCode가 같은 값이다.
		assertEquals(testUser.hashCode(), System.identityHashCode(testUser));
		
		System.out.println("================");
		TestUser testUser2 = new TestUser();
		System.out.println("테스트유저toString :: "+testUser2 + " , hex int :: "+testUser2.hashCode());
		System.out.print("해쉬코드16진수변환 :: "+Integer.toHexString(testUser2.hashCode()));
		System.out.println(" , Identity Hash :: " + System.identityHashCode(testUser2));
		hashString = testUser2.toString();
		assertEquals(hashString.substring(hashString.indexOf("@")+1), Integer.toHexString(testUser2.hashCode()));
		assertEquals(testUser2.hashCode(), System.identityHashCode(testUser2));
	}
}
