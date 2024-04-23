package com.itwill.class05;

public class Subject {
	
	 // field
    int korean;
    int english;
    int math;
    int science;
    
    // 생성자: 
    // (1)기본 생성자. 
   public Subject() {}
    
    // (2)아규먼트를 갖는 생성자.
   public Subject(int korean, int english, int math, int science) {
	   this.korean = korean; // => 인스턴스 변수 = 지역 변수;
 	   this.english = english;
	   this.math = math;
	   this.science = science;
   }
    
    // 메서드: 
    // (1)총점 리턴. 
   public int getTotal() { // => 파라미터를 선언할 필요가 없다. 
	   return korean + english + math + science; // 필드 변수와 파라미터가 구분이 된다면 'this.' 생략 가능.
   }
    
    // (2) 평균 리턴.
    public double getMean() {
    	return (double) getTotal() / 4; // this.getTotal() => 메서드 앞에도 'this.' 붙일 수 있음. 
    }

    public void info() {
    	System.out.println("국어: " + this.korean);
    	System.out.println("영어: " + this.english);
    	System.out.println("수학: " + this.math);
    	System.out.println("과학: " + this.science);
    	System.out.println("총점: " + this.getTotal());
    	System.out.println("평균: " + this.getMean());
    	
    }

}
