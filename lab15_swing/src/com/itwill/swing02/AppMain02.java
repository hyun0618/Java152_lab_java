package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JLabel lblMessage;
	private JTextField textInput;
	private JButton btnInput; // local <-> field 설정 가능. 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute layout
		
		JLabel lblMessage = new JLabel("메시지를 입력하세요.");
		lblMessage.setFont(new Font("D2Coding", Font.PLAIN, 23));
		lblMessage.setBounds(54, 50, 457, 46);
		frame.getContentPane().add(lblMessage);
		
		textInput = new JTextField(); // textInput: 멤버변수
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 23));
		textInput.setBounds(54, 120, 459, 46);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		btnInput = new JButton("입력"); // JButton 객체 생성 // btnInput: 지역변수
		
		// 버튼에 ActionListener 이벤트 핸들러(리스너)를 설정(등록)
		btnInput.addActionListener(new ActionListener() {
			@Override // 버튼이 클릭됐을 때 할 일을 작성.
			public void actionPerformed(ActionEvent e) {
				// (지역) 내부 클래스에서는 외부 클래스의 메서드를 사용할 수 있음. 
				handleInputButtonClick();
			}
		});
		
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnInput.setBounds(233, 188, 97, 30);
		frame.getContentPane().add(btnInput);
	}

	private void handleInputButtonClick() {	
		// 1) JTextField에 입력된 문자열을 읽음. 
		String msg = textInput.getText();
		
		// 2) 1)에서 읽은 내용을 JLabel에 씀
		lblMessage.setText(msg);
		
		// 3) JTextField를 비움(JTextField에 입력된 내용을 지움).
		textInput.setText("");
		
	}
}
