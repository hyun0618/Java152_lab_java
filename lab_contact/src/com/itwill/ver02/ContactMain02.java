package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

public class ContactMain02 {  // MVC 아키텍처에서 View 역할

	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");

		ContactMain02 app = new ContactMain02();

		boolean run = true;
		while (run) {
			int menu = app.selectMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
//			case 4:
//				app.updateContact();
//				break;
			default:
				System.out.println("\n 메뉴 번호를 확인하세요.");
			}
		}

		// [0]종료
		System.out.println("*** 프로그램 종료 ***");
	}

	// [1]저장
	private void saveNewContact() {
		System.out.println("--- 새 연락처 저장 ---");

//		if (((ContactDaoImpl) dao).isMemoryFull()) {
//			System.out.println("연락처를 저장할 공간이 부족합니다.");
//			return; // 메서드 종료
//		}
		ContactDaoImpl daoImpl = (ContactDaoImpl) dao;
		if (daoImpl.isMemoryFull()) {
			System.out.println("연락처를 저장할 공간이 부족합니다.");
			return;
		}

		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);
		int result = dao.create(contact);
		if (result == 1) {
			System.out.println(">> 연락처를 저장하였습니다.");
		} else {
			System.out.println(">> 연락처를 저장하지 못했습니다.");
		}

	}

	// [2]목록
	private void readAllContacts() {
		System.out.println("--- 연락처 목록 ---");

		Contact[] contacts = dao.read();
		int index = 0;
		for (Contact c : contacts) {
			if (c != null) {
				System.out.println("[" + index + "]" + c);
				index++;
			}
		}
	}

	// [3]인덱스검색
	private void readContactByIndex() {
		System.out.println("--- 인덱스 검색 ---");
		System.out.print("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

//		Contact contact = dao.read(index);
//		if (contact != null) {
//			System.out.println(contact);
//		} else {
//			System.out.println("해당 인덱스에는 저장된 연락처가 없습니다.");
//		}

	}

	// [4]수정
//	private void updateContact() {
//		System.out.println("--- 연락처 수정 ---");
//		
//		  System.out.print("인덱스 입력>> ");
//	        int index = inputInteger();
//	        
//	        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
//	            System.out.println("해당 인덱스에는 수정할 정보가 없습니다.");
//	            return;
//	        }
//	        
//	        Contact old = dao.read(index);
//	        System.out.println("수정전: " + old);
//	        
//	        System.out.print("이름 수정>> ");
//	        String name = scanner.nextLine();
//	        
//	        System.out.print("전화번호 수정>> ");
//	        String phone = scanner.nextLine();
//	        
//	        System.out.print("이메일 수정>> ");
//	        String email = scanner.nextLine();
//	        
//	        Contact updated = new Contact(name, phone, email);
//	        
//	        int result = dao.update(index, updated); // 업데이트 결과를 result에 줌.
//	        if (result == 1) {
//	            System.out.println(">>> 연락처를 수정하였습니다.");
//	        } else {
//	            System.out.println(">>> 연락처를 수정하지 못했습니다.");
//	        }
//		
//
//	}

	
	// 시작화면
	private int selectMainMenu() {
		System.out.println("\n----------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("선택>> ");

		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}
	
//	private int inputInteger() {
//		int result = 0;
//		
//		while(true) { 
//			try {
//				
//			}
//		}
//		
//		reuturn result;
//	}
	
	

}
