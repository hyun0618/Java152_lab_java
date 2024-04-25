package com.itwill.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// 반복문

		/*
		System.out.println("Java 1");
		System.out.println("Java 2");
		System.out.println("Java 3");
		System.out.println("Java 4");
		System.out.println("Java 5");
		System.out.println("Java 6");
		System.out.println("Java 7");
		*/
		
//		for (int i = 1; i <= 5; i++) { // for (변수선언(초기화식); 조건식; 증감식)
//			System.out.println("Java " + i); // ++: 1씩 증가, --: 1씩 감소
//		}
//		System.out.println("-----------------------");
		
		
//		int x = 1;
//		for (x = 1; x <= 5; x++) {
//			System.out.println("Java " + x);
//		}
		
		
		for (int x = 1; x <= 3; x++) { 
			System.out.println("Java " + x);
		}
		System.out.println("-----------------------");
		
		for (int x = 4; x <= 5; x++) {
			System.out.println("Java " + x);
		}
		System.out.println("-----------------------");
		
		// 지역 변수(local variable); 메서드 안에서 선언한 변수. 예) int,
		// 지역 변수의 사용 범위:
		// 지역 변수는 선언된 순간부터 변수가 포함된 블록({...}) 안에서만 사용 가능.
		// for 문장의 초기식에서 선언된 [지역]변수는 for 블록 안에서만 사용 가능.
		
		
		// 증감 연산자: ++(1 증가), --(1 감소)
		// 증감 연산자는 변수 이름 앞·뒤에서 사용이 가능. 예) i++, ++i
		
		int x = 1; // ********* 새로운 변수 선언 / 변수 변환 x (?)
		int y = x++ + 1; 
		// 변수++ : 다른 연산보다 나중에 (덧셈 먼저 계산하고 x값 1 증가)
		// -> y = x  + 1; x++;
		System.out.println("x = " + x + ", y = " + y);
		
		x = 1;
		y = ++x + 1; 
		// ++변수 : 다른 연산보다 먼저 (x값 1 증가 먼저 하고 덧셈 계산)
		// -> x++; y = x + 1;
		System.out.println("x = " + x + ", y = " + y);
		
		// int z = 1;
		// int w = z++ + 1 + ++z;
		// z = 3, w = 5
	
	}

}
