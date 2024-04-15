package com.itwill.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

	public static void main(String[] args) {

		// 사원(Employee)들의 리스트
		List<Employee> employees = Arrays.asList(
				new Employee(101, "김지현", "개발1팀", "과장", 700),
				new Employee(102, "이동준", "개발2팀", "부장", 800), 
				new Employee(103, "이승행", "개발1팀", "대리", 500),
				new Employee(104, "정윤정", "개발2팀", "부장", 1_000), 
				new Employee(105, "김동환", "인사팀", "회장", 30_000),
				new Employee(106, "노형진", "인사팀", "차장", 900),
				new Employee(107, "오쌤", "총무", "대리", 300)
		);

		// Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		System.out.println("---------- 직원 정보 ----------");
		for (Employee e : employees) {
			System.out.println(e);
		}
		// 람다
		employees.forEach((x) -> System.out.println(x));
		employees.forEach(System.out::println);

		System.out.println("\n---------- 개발팀 급여 합계 및 평균 ----------");
		// Ex2 ~ Ex3. 개발팀(1, 2팀)에서 일하는 직원들의 급여 합계 및 평균.
		List<Employee> developer = employees.stream().filter((x) -> x.getDept().contains("개발")).toList();

		double wageDevelop = 0;
		for (Employee i : developer) {
			wageDevelop += i.getSalary();
		}
		System.out.println("개발팀 급여 합계 = " + wageDevelop);

		double meanDevelop;
		meanDevelop = wageDevelop / developer.size();
		System.out.println("개발팀 급여 평균 = " + meanDevelop);

		//
		double sum = 0.0; // 급여의 합계를 저장하기 위한 변수.
		int count = 0; // 개발팀 직원의 수를 저장하기 위한 변수.
		for (Employee e : employees) { // 리스트의 모든 직원들을 순서대로 반복.
			if (e.getDept().contains("개발")) { // 직원의 부서 이름에 개발 포함.
				sum += e.getSalary(); // 개발팀 직원의 급여 합계.
				count++; // 직원 수 증가.
			}
		}
		System.out.println("합계 = " + sum);
		System.out.println("평균 = " + sum / count);

		//
		sum = employees.stream()
						.filter((x) -> x.getDept().contains("개발"))
						.mapToDouble((x) -> x.getSalary()) // 직원이 들어오면 그 직원의 샐러리로 맵핑하겠다.
						.sum();																																																
		System.out.println("sum = " + sum);

		double mean = employees.stream().filter((x) -> x.getDept().contains("개발"))
//				.mapToDouble((x) -> x.getSalary()) // 직원이 들어오면 그 직원의 샐러리로 맵핑하겠다.
				.mapToDouble(Employee::getSalary).average() // 리턴 타입: OptionalDouble
				.orElseThrow(); // 평균을 계산할 수 있으면 double 값 리턴, 그렇지 않으면 예외를 발생.
		System.out.println("mean = " + mean);

		
		System.out.println("\n---------- Ex.4 ~ Ex.5 부장 급여 합계 및 평균 ----------");
		// Ex4 ~ Ex5. 직급이 부장인 직원들의 급여 합계 및 평균.

		List<Employee> bujang = employees.stream().filter((x) -> x.getJobTitle().equals("부장")).toList();

		int wageBujang = 0;
		for (Employee i : bujang) {
			wageBujang += (int) i.getSalary();
		}
		System.out.println("부장 급여 합계 = " + wageBujang);

		int meanBujang;
		meanBujang = wageBujang / bujang.size();
		System.out.println("부장 급여 평균 = " + meanBujang);

		//
		sum = 0.0;
		mean = 0.0;
		count = 0;
		for (Employee e : employees) {
			if (e.getJobTitle().equals("부장")) {
				sum += e.getSalary();
				count++;
			}
		}
		System.out.println("sum = " + sum);

		mean = sum / count;
		System.out.println("mean = " + mean);

		//
		sum = employees.stream().filter((x) -> x.getJobTitle().equals("부장")).mapToDouble((x) -> x.getSalary()).sum();
		System.out.println("sum = " + sum);

		mean = employees.stream().filter((x) -> x.getJobTitle().equals("부장")).mapToDouble((x) -> x.getSalary())
				.average().orElseThrow();

		System.out.println("mean = " + mean);

		
		
		System.out.println("\n----- 급여 1,000 이상 직원 정보 -----");
		// Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
		List<Employee> highWage = employees.stream().filter((x) -> x.getSalary() >= 1000).toList();
		for (Employee i : highWage) {
			System.out.println(i);
		}

		//
		employees.stream()
				.filter((x) -> x.getSalary() >= 1000)
				.forEach(System.out::println); // x -> System.out.println(x)

		
		
		System.out.println("\n----- 개발1팀 급여 10% 인상 후 평균 -----");
		// Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균.

//		List<Employee> incentive = employees.stream()
//											.filter((x) -> x.getDept().equals("개발1팀"))
//											.map((x) -> x.getSalary() * 1.1);

		//
		sum = 0.0;
		count = 0;
		for (Employee e : employees) {
			if (e.getDept().equals("개발1팀")) {
				sum += e.getSalary() * 1.1;
				count++;
			}

		}
		mean = sum / count;
		System.out.println("mean = " + mean);

		//
		mean = employees.stream().filter((x) -> x.getDept().equals("개발1팀")).mapToDouble((x) -> x.getSalary() * 1.1) //
				.average().orElseThrow();
		System.out.println("mean = " + mean);

		
		
		System.out.println("\n----- 대리 직원의 수  -----");
		// Ex8. 직원들 중에서 대리는 몇 명?

		count = 0;
		for (Employee e : employees) {
			if (e.getJobTitle().equals("대리")) {
				count++;
			}
		}
		System.out.println(count + "명");
		
		
		
		long daeri = employees.stream() // <= count가 long타입이므로 
				.filter(e -> e.getJobTitle().equals("대리"))
				.count();
		System.out.println(daeri + "명");

	}
}
