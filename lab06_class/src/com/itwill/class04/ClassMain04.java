package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// Rectangle 객체 생성, 메서드 호출
		
		// (1) 기본생성자를 사용:		
		Rectangle rect1 = new Rectangle (); // 클래스 이름이 변수타입 => Rectangle
		
		System.out.println("rect1 넓이: " + rect1.area()); // "."누르고 나오는 옵션만 사용 가능.
 		System.out.println("rect1 둘레: " + rect1.perimeter());
		
 		System.out.println();
 		
 		// 아규먼트를 갖는 생성자를 사용:
 		Rectangle rect2 = new Rectangle(3, 4);
 		System.out.println("rect2: " + rect2);
 			
		System.out.println("rect2 넓이: " + rect2.area()); 
 		System.out.println("rect2 둘레: " + rect2.perimeter());
		
 		rect2 = new Rectangle(4, 3);
 		System.out.println("rect2: " + rect2);
 		

	}

}
