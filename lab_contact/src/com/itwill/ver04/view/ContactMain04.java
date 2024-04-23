package com.itwill.ver04.view;

import java.util.List;
import java.util.Scanner;


import com.itwill.ver04.controller.ContactDao;
import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;

// View
public class ContactMain04 {  

	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.4 ***");

		ContactMain04 app = new ContactMain04();

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
			case 4:
				app.updateContactByIndex();
				break;
			case 5:
				app.deleteContactByIndex();			
				break;
			default:
				System.out.println("\n 메뉴 번호를 다시 확인하세요.");
			}
		}

	// [0]종료
		System.out.println("*** 프로그램 종료 ***");
	}

	// [1]저장
	private void saveNewContact() {
		System.out.println("--- 새 연락처 저장 ---");

		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(0, name, phone, email);
		int result = dao.create(contact);  // 메인이 다오한테 연락처를 넘겨 줌.(=> DTO)
		if (result == 1) {
			System.out.println(">> 연락처를 저장하였습니다.");
		} else {
			System.out.println(">> 연락처 저장에 실패하였습니다.");
		}

	}

	// [2]목록
	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");

		List<Contact> contacts = dao.read();
		int index = 0;
		for (Contact c : contacts) {
//			if (c != null) {  // v0.3에서는 null을 검사할 필요가 없다.
				System.out.println("[" + index + "]" + c);
				index++;
//			}
		}
	}

	// [3]인덱스검색
	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");
		
		System.out.print("인덱스 입력>> ");
		int index = inputInteger();
	        
	    if (!((ContactDaoImpl) dao).isValidIndex(index)) {  
	    	// 변수 다오를 다오임플로 캐스팅 => 다오를 선언할 때 다오임플 타입으로 하지 않았기 때문에
	    	System.out.println(">> 해당 인덱스에는 연락처 정보가 없습니다.");
	        return;
	    }

		Contact contact = dao.read(index);
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println(">> 해당 인덱스에는 저장된 연락처가 없습니다.");
		}

	}

	// [4]수정
	private void updateContactByIndex() {
		System.out.println("\n--- 연락처 수정 ---");
		
		  System.out.print("인덱스 입력>> ");
	        int index = inputInteger();
	        
	        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
	            System.out.println(">> 해당 인덱스에는 수정할 정보가 없습니다.");
	            return;
	        }
	        
	        Contact old = dao.read(index);
	        System.out.println("변경 전: " + old);
	        
	        System.out.print("이름 변경>> ");
	        String name = scanner.nextLine();
	        
	        System.out.print("전화번호 변경>> ");
	        String phone = scanner.nextLine();
	        
	        System.out.print("이메일 변경>> ");
	        String email = scanner.nextLine();
	        
	        Contact updated = new Contact(0, name, phone, email);
	        
	        int result = dao.update(index, updated); // 업데이트 결과를 result에 줌.
	        if (result == 1) {
	            System.out.println(">> 연락처를 수정하였습니다.");
	        } else {
	            System.out.println(">> 연락처 수정에 실패하였습니다.");
	        }
	        
	}
	
	// [5] 삭제
	private void deleteContactByIndex() {
		System.out.println("\n--- 연락처 삭제 ---");
		
		System.out.println("삭제할 인덱스>> ");
		int index = inputInteger();
		
		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
	            System.out.println(">> 해당 인덱스에는 삭제할 정보가 없습니다.");
	            return;
		}	
		 
		int result= dao.delete(index);
		if (result == 1) {
			System.out.println("연락처를 삭제하였습니다.");
		} else {
			System.out.println("연락처 삭제에 실패하였습니다.");
		}
	}

	
	// 시작화면
	private int selectMainMenu() {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5]삭제");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택>> ");

		int menu = inputInteger();  // 정수를 입력받아서,
		return menu;  // => 리턴한다. 
	}
	
	   private int inputInteger() {
	        int result = 0;
	        
	        while(true) {
	            try {
	                result = Integer.parseInt(scanner.nextLine());
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("입력값은 정수여야 합니다.");
	                System.out.print("정수 입력>> ");
	            }
	        }       
	        return result;
	    }
	
}
