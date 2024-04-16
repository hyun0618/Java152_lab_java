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

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextArea textResult;
	private JButton btnInput;

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
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblPhone.setBounds(45, 80, 80, 30);
		frame.getContentPane().add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEmail.setBounds(45, 120, 80, 30);
		frame.getContentPane().add(lblEmail);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textName.setBounds(160, 40, 120, 30);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(160, 80, 120, 30);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(160, 120, 120, 30);
		frame.getContentPane().add(textEmail);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String phone = textPhone.getText();
				String email = textEmail.getText();
				
				String msg = String.format("%s : %s : %s", name, phone, email);
				textResult.setText(msg);
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInput.setBounds(325, 124, 110, 33);
		frame.getContentPane().add(btnInput);
		
		textResult = new JTextArea();
		textResult.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textResult.setBounds(44, 180, 391, 146);
		frame.getContentPane().add(textResult);
		
		
		
		
	}

}
