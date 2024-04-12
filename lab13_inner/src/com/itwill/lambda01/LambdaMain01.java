package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		// Calculator 타입의 객체를 생성.
		Calculator calc = new Calculator(1, 2);
		
		
		// ----- 별도 파일에 작성된 클래스 'Adder' 사용:
		// Calculable을 구현하는 객체를 생성
		Calculable adder = new Adder(); // Adder adder = new Adder();
		
		// Calculator 객체의 메서드 호출.
		double result = calc.calculate(adder);
		System.out.println("addition = " + result);
		
		
		// ----- 지역 클래스 'Subtracter' 사용:
		class Subtracter implements Calculable {
			@Override
			public double calculate(double x, double y) {
				return x - y;
			}
		}
		result = calc.calculate(new Subtracter());
		System.out.println("subtraction = " + result);

		
		// ----- 익명 클래스 사용:
		result = calc.calculate(new Calculable() {
			@Override
			public double calculate(double x, double y) {
				return x * y;
			}
		});
		System.out.println("multiplication = " + result);
		
		
		// ----- 람다 표현식 사용: (파라미터 선언 -> 리턴 값)
//		calc.calculate((double x, double y) -> { return x / y; });
		result = calc.calculate((x,y) -> x / y);
		System.out.println("division = " + result);
		
		/*
		 * 람다 표현식(lambda expression):
		 *   - 익명 클래스의 객체를 간단히 작성하기 위한 문법.
		 *   - 함수형 인터페이스(추상 메서드가 오직 1개인 인터페이스)만 람다 표현식을 사용할 수 있다. 
		 *    
		 *   - 람다 표현식 문법: (파라미터 선언, ...) -> { 코드; }
		 *       - 파라미터 선언에서 변수 타입은 생략이 가능하다.  
		 *       - 람다 표현식 바디({})에 한 문장만 있는 경우에는 중괄호와 코드 뒤의 세미콜론을 같이 생략할 수 있다. (동시에 생략해야 한다.)
		 *       - 람다 표현식 바디에 return 문장만 있는 경우에는 return 값만 남긴다. (예). (x, y) -> {x / y;}
		 *       - 람다 표현식에서 파라미터의 개수가 1개인 경우에는 ()를 생략할 수 있다. (예). x -> 2 * x
		 *       - 람다 표현식에서 파라미터가 없는 경우에는 ()를 생략할 수 없다. (예). () -> "hello" 
		 */
		
		
		
	}

}
