package com.itwill.inner01;

import com.itwill.inner01.OuterCls.InnerCls;
import com.itwill.inner01.EnclosingCls.NestedCls;

/*
 * [변수를 선언할 수 있는 위치]:  
 * 	1. 필드: 
 * 	- 클래스의 멤버로 선언하는 변수. 접근 수식어(private, protected, public)를 사용할 수 있음.
 * 		(1) 인스턴스 필드: 
 * 			- static이 아닌 필드.
 * 			- 객체를 생성한 후에, 그 참조변수(인스턴스)로 참조해서 사용하는 필드. 
 * 		(2) static 필드: 
 * 			- static으로 선언한 필드.
 * 			- 프로그램 로딩 시점에 클래스 로더에 의해서 메모리에 로딩되는 변수.
 * 			- 객체를 생성하지 않고 클래스 이름을 접두사로 사용하는 필드. 
 *      
 * 	2. 지역변수: 
 * 	- 메서드 안에서 선언하는 변수. 접근 수식어를 사용할 수 없음.
 * 	- 선언된 위치에서부터 변수가 포함된 블록이 끝날 때까지 사용 가능.
 * 	- 메서드의 파라미터도 지역변수이다. 
 * 	- 지역변수에는 static을 사용할 수 없음.
 * 
 * 
 * [내부 클래스/인터페이스 (inner class/interface)]: 
 * 	- 다른 클래스/인터페이스 안에서 선언된 클래스/인터페이스.
 * 	- 내부 클래스를 선언할 수 있는 위치에 따라 멤버 내부 클래스, 지역 내부 클래스로 구분된다.
 * 	
 * 		1. 멤버 (내부) 클래스
 * 			(1) 인스턴스 내부 클래스: 
 * 			- static이 아닌 멤버 내부 클래스.
 * 			- 외부 클래스의 객체를 먼저 생성한 후에, 그 참조변수로 참조해서 객체를 생성하고 사용할 수 있는 멤버 내부 클래스.
 * 
 * 			(2) static 내부 클래스: 
 * 			- static으로 선언한 멤버 내부 클래스.
 * 			- 외부 클래스의 객체 생성 여부과 상관없이, 사용할 수 있는 멤버 내부 클래스.
 * 			- 중첩 클래스(nested class).
 * 			- 멤버 내부 인터페이스는 static이어야만 하고, 없다면 생략되어 있는 것이다. 		
 * 
 *		2. 지역 (내부) 클래스 - local class
 * 		- 메서드 안에서 선언된 내부 클래스. 
 * 		- "선언된 메서드 블록 안"에서만 객체를 생성하고 사용할 수 있는 클래스. 
 * 
 * 		3. 익명 클래스(anonymous class)
 *  	- 이름이 없는 클래스.
 * 	 	- 클래스 선언과 동시에 객체 생성까지 해야하는 클래스. => 람다 표현식(lambda expression).
 * 
 * 
 * [외부 클래스/인터페이스 (outer, enclosing class/interface)]
 * 	- 내부 클래스/인터페이스를 감싸고 있는 클래스/인터페이스.
 */

public class InnerMain01 {

	public static void main(String[] args) {
		// OuterCls
			// OuterCls 타입의 객체를 생성
			OuterCls outer1 = new OuterCls(1, 2, "Java");
			System.out.println(outer1);
			
		
		// InnerCls
			// (1) InnerCls 타입의 객체를 생성 (내부클래스 이름을 import 하지 않은 경우)
			OuterCls.InnerCls inner1 = outer1.new InnerCls(100); // 외부 클래스의 참조변수로 참조해서 객체 생성.
			inner1.info();
			// (2) InnerCls 타입의 객체를 생성 (내부 클래스 이름을 import 한 경우)
			InnerCls inner2 = outer1.new InnerCls(200);
			inner2.info();
			//
			InnerCls inner3 = new OuterCls(10, 20, "점심").new InnerCls(2323);
			inner3.info();
			
		
			
		// EnclosingCls
			// EnclosingCls의 static field
			System.out.println("\n--- EnclosingCls ---");
			System.out.println("EnclosingCls.var = " + EnclosingCls.var);
			
			// EnclosingCls의 static method
			EnclosingCls.test();
			
			// EnclosingCls 타입의 객체를 생성.
			EnclosingCls encl = new EnclosingCls(123);
			System.out.println(encl); // toString
			
			
		// NestedCls
			// NestedCls 타입 객체 생성 (NestedCls 이름을 import 하지 않은 경우)
			EnclosingCls.NestedCls nested1 = new EnclosingCls.NestedCls(7);
			nested1.info();
			
			// NestedCls 타입 객체 생성 (NestedCls 이름을 import 한 경우)
			NestedCls nested2 = new NestedCls(17);
			nested2.info();
			
		
	}

}
