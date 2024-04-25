package com.itwill.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		
		// 5 4 3 2 1 
		for (int x = 5; x >= 1; x--) {
			System.out.print(x + " ");
		}
		System.out.println(); // 줄바꿈
		
		// 0 2 4 6 8 10
		for (int x = 0; x <= 10; x = x + 2) { // x += 2
			System.out.print(x + " ");
		}
		System.out.println(); // 줄바꿈
		for (int x = 0; x <= 10; x += 2) { 
			System.out.print(x + " ");
		}
		System.out.println(); // 줄바꿈
		for (int x = 0; x <= 5; x++) {
			System.out.print((x * 2) + " ");
		}
		System.out.println(); // 줄바꿈
		for (int x = 0; x <= 10; x++) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
		}	
		System.out.println(); // 줄바꿈
		
		// 10 8 6 4 2 0
		for (int x = 10; x >= 0; x -= 2) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (int x = 5; x >= 0; x--) {
			System.out.print((x * 2) + " ");
		}
		
	}

}
