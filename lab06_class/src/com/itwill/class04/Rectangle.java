package com.itwill.class04;

public class Rectangle {
	// field
	double width; // 직사각형의 가로 길이
	double height; // 직사각형의 세로 길이
	
	// 생성자
	// (1) 기본 생성자
	public Rectangle() {} // => width = height = '0.0'으로 초기화
	
	// (2) 가로/세로를 아규먼트로 전달받아서 초기화하는 생성자
	public Rectangle(double width, double height) {
		this.width = width; // 'width, height' 값을 필드 'width, height'에 저장하겠다. 
		this.height = height;
	}
	
	// 메서드
	// (1) 넓이를 리턴
	public double area() { 
		return width * height; // return this.width * this.height;
	}
	// (2) 둘레길이를 리턴
	public double perimeter() {
		return 2 * (width + height);
	}

}
