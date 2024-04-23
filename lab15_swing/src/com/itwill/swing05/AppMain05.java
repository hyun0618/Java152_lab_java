package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JButton btnInput;
	private JScrollPane scrollPane;
	private JTextArea textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblName.setBounds(45, 40, 80, 30);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textName.setBounds(160, 40, 120, 30);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblPhone.setBounds(45, 80, 80, 30);
		frame.getContentPane().add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(160, 80, 120, 30);
		frame.getContentPane().add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEmail.setBounds(45, 120, 80, 30);
		frame.getContentPane().add(lblEmail);
			
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(160, 120, 120, 30);
		frame.getContentPane().add(textEmail);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() { // 익명 내부 클래스 
			@Override	
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInput.setBounds(325, 124, 110, 33);
		frame.getContentPane().add(btnInput);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 179, 390, 159);
		frame.getContentPane().add(scrollPane);
		
		textResult = new JTextArea();
		textResult.setFont(new Font("D2Coding", Font.PLAIN, 20));
		scrollPane.setViewportView(textResult);
	}
		
		private void handleInputButtonClick() {
			
			String name = textName.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			
			String msg = String.format("이름: %s, 전화번호: %s, 이메일: %s\n", name, phone, email);
			
			// JTextArea
//			textResult.setText(msg);
			textResult.append(msg);
				
			// JTextField에 입력된 내용 지우기.
			textName.setText("");
			textPhone.setText("");
			textEmail.setText("");
	}
}
