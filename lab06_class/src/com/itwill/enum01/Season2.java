package com.itwill.enum01;

public class Season2 {
	
	public static final Season2 SPRING = new Season2("봄"); // 참조타입의 객체를 Method에 저장. (Stack, Heap, Method)
	public static final Season2 SUMMER = new Season2("여름");
	public static final Season2 FALL = new Season2("가을");
	public static final Season2 WINTER = new Season2("겨울");
	
	private String name;
	
	private Season2(String name) { // 같은 패키지 안에서 부를 수 있으므로 TestMain에서 호출할 수 있다. 
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
