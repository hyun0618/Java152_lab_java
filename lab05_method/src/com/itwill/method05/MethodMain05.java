package com.itwill.method05;

import java.util.Random;

public class MethodMain05 {

	public static void main(String[] args) {
		// TODO 메서드 호출, 그 결과를 출력:
		
	// sum 메서드 호출. 결과 출력.
	
//	 int[] array = {1, 2, 3, 4, 5};
	
	 Random random = new Random();		
	 int[] array = new int[3];
	 for (int i = 0; i < array.length; i++) {
		 array[i] = random.nextInt(11);
	 }
	 for (int x : array) {
		 System.out.print(x + " ");
	 }
	 System.out.println();
	 

	 
	 int total = sum(array);
	 System.out.println("total = " + total);
	
	 // mean 메서드 호출, 결과 출력.
 	 double average = mean(array);
	 System.out.println("average = " + average);
	 
	// max 메서드 호출, 결과 출력.
	 System.out.println("max = " + max(array));
	 
	// min 메서드 호출, 결과 출력.
	 System.out.println("min = " + min(array));

	}
	
	/**
	 * sum.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array의 모든 원소들의 합. 
	 */
	public static int sum(int[] array) { // sum : 메서드 이름
//		int sum = 0; // sum : 지역변수
		
		
//		for(int i = 0; i < array.length; i++) {
//			result += array[i];
//		}
		int result = 0;
		for (int x : array) {
			result += x;
		}
		
		return result;
	}
	
	/**
	 * mean.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 평균을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들의 평균을 double 타입으로 리턴. 
	 */
	public static double mean(int[] array) {
		double result = (double) sum(array) / array.length; // sum 메서드 이용.
		return result;
	}	
		
//		int sum = 0;
//		for (int x : array) {
//			sum += x;
//		}
//		double result = (double) sum / array.length;
//		
//		return result;
	
	
	/**
	 * max.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 원소들 중 최댓값을 리턴.
	 * @param array 정수들의 1차원 배열. 
	 * @return array 원소들 중 최댓값.
	 */
	public static int max(int[] array) {
		 int result = array[0];
		 
//		 for (int i = 0; i < array.length; i++) {
//			 if (result < array[i]) {
//				 result = array[i];
//			 }
//		 }
		 
		 for (int x : array) {
			 if (x > result) {
				 result = x;
			 }
		 }
		 
		 return result;
	}
	
	/**
	 * min. 
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 원소들 중 최솟값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최솟값.
	 */
	public static int min(int[] array) {
		 int result = array[0];
//		 for (int i = 0; i < array.length; i++) {
//			 if (result > array[i]) {
//				 result = array[i];
//			 }
//		 }
		 for (int x : array) {
			 if (x < result) {
				 result = x;
			 }
		 }
		 
		 return result;
	}

}
