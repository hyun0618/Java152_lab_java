package com.itwill.swing08;

public class Score {
	private int korean;
	private int enlish;
	private int math;
	
	public Score() {}

	public Score(int korean, int enlish, int math) {
		this.korean = korean;
		this.enlish = enlish;
		this.math = math;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnlish() {
		return enlish;
	}

	public void setEnlish(int enlish) {
		this.enlish = enlish;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal() {
		return korean + enlish + math;
	}
	
	public double getMean() {
		return (double) getTotal() / 3;
	}

	@Override
	public String toString() {
		return "Score [korean=" + korean + ", enlish=" + enlish + ", math=" + math + "]";
	}
	
	

}
