package com.itwill.enum01;

public class TestMain {

	public static void main(String[] args) {

//		int season = Season.SPRING;
//		switch (season) {
//		case Season.SPRING:
//			System.out.println("봄");
//			break;
//		case Season.SUMMER:
//			System.out.println("여름");
//			break;
//		case Season.FALL:
//			System.out.println("가을");
//			break;
//		case Season.WINTER:
//			System.out.println("겨울");
//			break;
//		default:
//				System.out.println("이상기후");
//		}

		int season = 5;
		switch (season) {
		case 0:
			System.out.println("봄");
			break;
		case 1:
			System.out.println("여름");
			break;
		case 2:
			System.out.println("가을");
			break;
		case 3:
			System.out.println("겨울");
			break;
		default:
			System.out.println("이상기후");
		}

		Season2 season2 = Season2.SPRING;
		if (season2 == Season2.SPRING) {
			System.out.println("봄");
		} else if (season2 == Season2.SUMMER) {
			System.out.println("여름");
		} else {
			System.out.println("the others");
		}

//		Season3 season3 = new Season3(""); 이넘이므로 호출 불가능. (생성자가 <private>이기 때문에) 
		Season3 season3 = Season3.SPRING;
		System.out.println(season3);
		System.out.println(season3.getName());
		
		String s = new String("a");
		System.out.println(s);
		
	}

}
