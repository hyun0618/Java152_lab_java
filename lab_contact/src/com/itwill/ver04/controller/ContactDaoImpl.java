package com.itwill.ver04.controller;

import java.util.List;

import com.itwill.ver04.model.Contact;
import com.itwill.ver04.util.FileUtil;

// import static 문장: 클래스에서 public static으로 선언된 멤버(필드, 메서드)의 이름을 가져옴. 
// import static com.itwill.ver04.util.FileUtil.initializeData;
import static com.itwill.ver04.util.FileUtil.*;

// MVC 아키텍처에서 Controller 역할 담당 클래스. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {
	// --- singleton
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {
		FileUtil.initializeDataDir();
		contacts = FileUtil.initializeData();
	}
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// --- singleton
	
	private List<Contact> contacts; 
	
	
	@Override
	public int create(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact read(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int index, Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

}
