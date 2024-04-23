package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		
		return instance;
	}
	
//	private ArrayList<Contact> contacts = new ArrayList<>();
	private List<Contact> contacts = new ArrayList<>();  // ArrayList는 List이다. "다형성"
	
//	private int count = 0;  // 리스트를 사용할 때에는 카운드가 필요 없다.
	
	public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }
	
	@Override
	public int create(Contact contact) {
		
		// (1)
		contacts.add(contact);	
		// count++;  // 리스트는 size를 쓰면 되므로 count를 쓸 필요가 없다.
		return 1;
		
		// (2)
//		boolean result = contacts.add(contact);
//		if (result) {
//			return 1;
//		} else {
//			return 0;
//		}
		
		// (3)
//		try {
//			contacts.add(contact);
//			return 1;
//		} catch (Exception e) {
//			return 0;
//		}
	
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) {
			return contacts.get(index);  // 배열 contacts[index]
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index)) {         // 인덱스가 정확하다면,   
			contacts.set(index, contact);  // 그 인덱스의 객체에 다른 정보를 저장.
		
//			contacts.get(index).setName(contact.getName());  // NullPointer Exception 주의!!
//			contacts.get(index).setPhone(contact.getPhone());
//			contacts.get(index).setEmail(contact.getEmail());
			return 1;
		} else {
			return 0;
		}
		
		// try-catch
		
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index);
			return 1;
		} else {
			return 0;
		}
		
	}

	
}
