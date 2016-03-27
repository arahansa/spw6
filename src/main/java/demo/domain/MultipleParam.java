package demo.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import lombok.Data;

@Data
public class MultipleParam {

	String myline;
	String test;
	
	
	public List<String> getMyLineList(){
		List<String> list = new LinkedList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(myline, "|&*");
		if(myline!=null){
			while(stringTokenizer.hasMoreTokens()){
				list.add(stringTokenizer.nextToken());
			}
		}
		return list;
	}
}
