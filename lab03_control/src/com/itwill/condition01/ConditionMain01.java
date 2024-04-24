package com.itwill.condition01;

public class ConditionMain01 {

	public static void main(String[] args) {
		// 조건문(conditional statement)
		
		int number = 123;
		
		// 1. if 구문
		if (number > 0) {
			// {}: 조건식을 만족하는 경우에 실행할 코드 블록
			System.out.println("양의 정수");  // 실행할 수도 안할 수도 있음. 
		}
		
		// 2. if-else 구문
		number = 4;  // 선언된 변수값을 다른 값으로 변경
		if (number % 2 == 0) {  // %: 나머지값
			// (1) 조건식을 만족하는 경우 실행할 코드 블록 
			System.out.println("짝수");
		
		} else {
			// (2) 조건식을 만족하지 못하는 경우 실행할 코드 블록
			System.out.println("홀수");
			
		}
				
		System.out.println("=== 프로그램 종료 ===");

	}

}