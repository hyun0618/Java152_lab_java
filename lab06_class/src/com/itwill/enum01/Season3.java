package com.itwill.enum01;

public enum Season3 {
	SPRING("봄"), // public static final Season3 SPRING = new Season3("봄");
	SUMMER("여름"), 
	FALL("가을"), 
	WINTER("겨울");
	
	private String name;

	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능.
	Season3(String name) { // <enum>의 생성자를 <public>으로 공개할 수 없다. => 이넘과 클래스의 차이점. 
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
