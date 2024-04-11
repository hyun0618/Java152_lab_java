package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

	public static void main(String[] args) {
		// 1. Student 1,000,000개를 저장하는 더미 데이터(ArrayList) 만들기. 
		ArrayList<Student> list = new ArrayList<Student>();
		
		
		Random rand = new Random(); // score를 난수로 생성.
		for (int i = 0; i < 1_000_000; i++) {
			
			Score score = new Score(rand.nextInt(101), rand.nextInt(101), rand.nextInt(101));
			Student student = new Student(i, "Name_" + i, score);
			list.add(student);
		}	
		System.out.println("list_first: " + list.getFirst());
		System.out.println("list_last: " + list.getLast());
		
		final String fileName = "data/student_list.dat";
		
		// 2. 더미 데이터를 파일에 쓰고 걸린 시간 측정.
		try (
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bos);	 	
		) {
			long start = System.currentTimeMillis();
			oos.writeObject(list); // 파일 쓰기
			long end= System.currentTimeMillis();
			
			System.out.println("write_time: " + (end - start) + "ms");
			
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		// 3. 파일에서 데이터를 읽고 걸린 시간 측정.  
		
		try (
			FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(in);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
		) { 
			long start = System.currentTimeMillis();
			ArrayList<Student> data = (ArrayList<Student>) ois.readObject(); // 파일 읽기. data: 파일에서 읽은 내용.
			long end = System.currentTimeMillis();
			
			System.out.println("read_time: " + (end - start) + "ms");
			System.out.println("size: " + data.size());
			System.out.println("data_first: " + data.getFirst());
			System.out.println("data_last: " + data.getLast());
		
		}	catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
