package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

	public static void main(String[] args) {
		// Scanner 타입의 변수를 선언, 초기화.
		Scanner sc = new Scanner(System.in);
	
		// 콘솔 창에서 Java 과목 점수(0 ~ 100 사이의 정수)를 입력받고 저장.
		System.out.print("Java score를 입력하세요 > ");
		int java = sc.nextInt(); // 변수 이름은 가능한 한 소문자. 
		
		// 콘솔 창에서 SQL 과목 점수(정수)를 입력받고 저장.
		System.out.print("SQL score를 입력하세요 > ");
		int sql = sc.nextInt();
		
		// 콘솔 창에서 JavaScript 과목 점수(정수)를 입력받고 저장.
		System.out.print("JavaScript score를 입력하세요 > ");
		int javascript = sc.nextInt();
		

		System.out.println();
		

		// 세 과목의 점수 출력.
		System.out.print("▶ Java: " + java + "점");
		System.out.print(", SQL: " + sql + "점");
		System.out.println(", JavaScript: " + javascript + "점");
		

		// 세 과목의 총점(정수)을 계산하고 출력. 
		// System.out.println("▶ 총점 = " + (java + sql + javascript));
		int total = (java + sql + javascript); 
		System.out.println("▶ 총점 = " + total);
		

		// 세 과목의 평균(소수점까지 계산)을 계산하고 출력.
		// double mean = (total/3.0); // 3을 실수로 만들어 줌. 
		double mean = (double)total/3; // total을 double로 변환 가능. (타입 강제변환)
		System.out.println("▶ 평균 = " + mean);


		// 세 과목의 평균이 90점 이상이면, "A"
		// 세 과목의 평균이 80점 이상이면, "B"
		// 세 과목의 평균이 70점 이상이면, "C"
		// 세 과목의 평균이 70점 미만이면, "F" 라고 출력. 
		
		if (mean >= 90 ) {
			System.out.println("▶ 학점: A");
		} else if (mean >= 80 ) {
			System.out.println("▶ 학점: B");
		} else if (mean >= 70 ) {
			System.out.println("▶ 학점: C");
		} else {
			System.out.println("▶ 학점: F");	
		}
		
		sc.close();
	}
}