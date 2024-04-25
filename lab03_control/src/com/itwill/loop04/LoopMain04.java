package com.itwill.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
		
		  /* 369게임: 아래와 같이 출력하세요.
		        1   2   *   4   5   *   7   8   *   10
		        11  12  *   14  15  *   17  18  *   20
		        21  22  *   24  25  *   27  28  *   *
		        *   *   *   *   *   *   *   *   *   40
		        41  42  *   44  45  *   47  48  *   50
		        51  52  *   54  55  *   57  58  *   *
		        *   *   *   *   *   *   *   *   *   70
		        71  72  *   74  75  *   77  78  *   80
		        81  82  *   84  85  *   87  88  *   *
		        *   *   *   *   *   *   *   *   *   100
		    */
		
		for (int x = 1; x <= 100; x++) {
			
//			if (x % 10 == 3) {
//				System.out.printf("*\t", x);
//			} else if (x / 10 == 3) {
//				System.out.printf("*\t", x);
//			} else if (x % 10 == 6) {
//				System.out.printf("*\t", x);
//			} else if (x / 10 == 6) {
//				System.out.printf("*\t", x);
//			} else if (x % 10 == 9) {
//				System.out.printf("*\t", x);
//			} else if (x / 10 == 9) {
//				System.out.printf("*\t", x);
//			} else { 
//				System.out.printf("%d\t", x);
//			}
//			
			// print 사용하기. 
			
//				if (x % 10 == 3) {
//					System.out.print("*\t");
//				} else if (x / 10 == 3) {
//					System.out.print("*\t");
//				} else if (x % 10 == 6) {
//					System.out.print("*\t");
//				} else if (x / 10 == 6) {
//					System.out.print("*\t");
//				} else if (x % 10 == 9) {
//					System.out.print("*\t");
//				} else if (x / 10 == 9) {
//					System.out.print("*\t");
//				} else {
//					System.out.print(x + "\t");
//				}
			
			int y = x % 10; // x를 10으로 나눈 나머지 => 1의 자릿수
			int z = x / 10; // x를 10으로 나눈 몫 => 10의 자릿수
			boolean condition1 = (y == 3) || (y == 6) || (y == 9); // 1의 자릿수가 3, 6, 9
			boolean condition2 = (z == 3) || (z == 6) || (z == 9); // 10의 자릿수가 3, 6, 9
			
			if (condition1 && condition2) {
				System.out.print("**\t");
			}
			else if (condition1 || condition2) {				
//			if (y == 3 || y == 6 || y == 9 || z == 3 || z == 6 || z == 9) {
				System.out.print("*\t");
			} else {
				System.out.print(x + "\t");
			}
			
			// 10개씩 나열. 
			if (x % 10 == 0) {
				System.out.println();
			}
					
		}
			

	}

}
