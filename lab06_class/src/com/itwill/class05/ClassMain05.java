package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// Subject, Student 클래스 객체 생성과 메서드 호출(invoke) 결과 테스트.
			
		// (1-1) 기본생성자를 사용해서 Subject 타입의 객체 생성:
		Subject sub1 = new Subject(); // => 'Subject': 변수타입, 'sub2': 인스턴스 
		sub1.info();
//		System.out.println("국어: " + sub1.korean);
//		System.out.println("영어: " + sub1.english);
//		System.out.println("수학: " + sub1.math);
//		System.out.println("과학: " + sub1.science); // science: 필드
//		System.out.println("총점: " + sub1.getTotal()); // getTotal(): 메서드
//		System.out.println("평균: " + sub1.getMean());	
	
		System.out.println();
		
		// (1-2) 아규먼트를 갖는 생성자를 사용해서 Subject 타입의 객체 생성:
		Subject sub2 = new Subject(90, 100, 85, 100); //																	
		sub2.info();
//		System.out.println("국어: " + sub2.korean);
//		System.out.println("영어: " + sub2.english);
//		System.out.println("수학: " + sub2.math);
//		System.out.println("과학: " + sub2.science);
//		System.out.println("총점: " + sub2.getTotal()); 
//		System.out.println("평균: " + sub2.getMean());		
		
		System.out.println();
		
		// (2-1) 기본생성자를 사용해서 Student 타입의 객체 생성:
		Student stu1 = new Student();
		stu1.id = 7;
		stu1.name = "지현";
		stu1.subject = sub2; //																																		
		stu1.info();
		
		System.out.println();
		
		// (2-2) 아규먼트를 갖는 생성자를 사용해서 Student 타입의 객체 생성:
		Student stu2 = new Student(1, "홍길동", sub1);
		stu2.info();		
		
		System.out.println();
		
		// (2-3)
		
	}

}
