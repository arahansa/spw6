package demo.domain;

public enum Level {
	GOLD("골드"), SILVER("실버"), BRONZE("브론즈");
	
	String level;
	
	Level(String descr){
		this.level  = descr;
	}
	public String getLabel(){
		return this.level;
	}
	
	public String getValue(){
		return this.name();  // 네임이 이 값을 돌려주는 것인가?
	}
}
