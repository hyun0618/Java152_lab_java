package com.itwill.class02;

// 클래스(class): 객체 설계도. 데이터(필드) + 생성자 + 기능(메서드) => 변수 타입.
public class Score {
	// 필드(field, 멤버 변수) '파란색'
	int java;
	int sql;
	int javascript;
	
	// 생성자(constructor)
	//
	// 객체를 생성하고, 객체의 필드들을 초기화하는 역할.
	// 생성자의 이름은 받드시 클래스의 이름과 같아야 함. 
	// 생성자를 작성하는 방법은 메서드 작성방법과 비슷하지만, <<< 리턴 타입이 없음 >>>. 
	//
	// 클래스를 선언할 때 생성자를 하나도 정의하지 않으면,
	// 자바 컴파일러가 "기본 생성자"를 자동으로 작성해 줌.
	//
	// 클래스를 선언할 때 생성자를 직접 정의한 경우에는, 
	// 자바 컴파일러가 기본 생성자를 자동으로 만들어 주지 않음.
	//
	// 생성자 오버로딩: 파라미터가 다른 생성자를 여러개 만들 수 있음. 
	
	
	// 아규먼트를 갖지 않는 생성자. => 기본 생성자(default constructor) 
	public Score() { // 생성자의 이름은 클래스의 이름과 동일해야 함.
		// 아무런 코드를 작성하지 않아도 됨.
		// 코드가 없어도 모든 필드를 타입의 기본값으로 초기화 해줌.
	}
	
	// 아규먼트를 갖는 생성자.
	public Score(int java, int sql, int js) { // 파라미터 'int java, int sql, int js' => 지역변수(갈색) 
		this.java = java; // this. => 필드, 스코어 객체가 갖고 있는 변수
		this.sql = sql;
		this.javascript = js;		
	}	
	
	// 메서드(method)
	public int getTotal() { // 클래스가 가지고 있는 필드를 이용할 수 있음. 
		return java + sql + javascript; 
	}
	
	public double getMean() {
		return (double) getTotal() / 3;
	}
	
}
