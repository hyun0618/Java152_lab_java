package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AppMain04 {

	private JFrame frame;
	private JButton btnPlus;
	private JButton btnMinus;
	private JLabel label2;
	private JLabel label1;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextArea textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 344, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label1 = new JLabel("Number1");
		label1.setBounds(12, 24, 57, 15);
		frame.getContentPane().add(label1);
		
		textNumber1 = new JTextField();
		textNumber1.setBounds(81, 16, 188, 32);
		frame.getContentPane().add(textNumber1);
		textNumber1.setColumns(10);
		
		label2 = new JLabel("Number2");
		label2.setBounds(12, 66, 57, 15);
		frame.getContentPane().add(label2);
		
		textNumber2 = new JTextField();
		textNumber2.setColumns(10);
		textNumber2.setBounds(81, 58, 188, 32);
		frame.getContentPane().add(textNumber2);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnPlus.setBounds(12, 101, 45, 45);
		frame.getContentPane().add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnMinus.setBounds(69, 101, 45, 45);
		frame.getContentPane().add(btnMinus);
		
		btnMultiply = new JButton("x");
		btnMultiply.addActionListener((e) -> handleButtonClick(e));
		btnMultiply.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnMultiply.setBounds(126, 100, 45, 45);
		frame.getContentPane().add(btnMultiply);
		
		btnDivide = new JButton("/");
		btnDivide.addActionListener(this::handleButtonClick);
		btnDivide.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnDivide.setBounds(192, 100, 45, 45);
		frame.getContentPane().add(btnDivide);
		
		textResult = new JTextArea();
		textResult.setBounds(12, 166, 300, 101);
		frame.getContentPane().add(textResult);
	}
		
	
	private void handleButtonClick(ActionEvent event) {
		// JTextField에 입력된 문자열을 숫자(double)로 변환 
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(textNumber1.getText());
			y = Double.parseDouble(textNumber2.getText());
		} catch (NumberFormatException e) {
			textResult.setText("Number1과 Number2에는 숫자를 입력하세요.");
			return;
		}
		
		double result = 0; // 사칙연산 결과 변수
		String operator = ""; // 사칙연산 기호(+, -, x, /)를 저장할 변수 
			
		Object source = event.getSource(); // 이벤트가 발생한 소스(UI 컴포넌트)
		if (source == btnPlus) {
			result = x + y;
			operator = "+";
		} else if (source == btnMinus) {
			result = x - y;
			operator = "-";
		} else if (source == btnMultiply) {
			result = x * y;
			operator = "x";
		} else if (source == btnDivide) {
			result = x / y;
			operator = "/";
		}
		
		// 결과창에 보여줄 문자열 
		String msg = String.format("%f %s %f = %f", x, operator, y, result);
		textResult.setText(msg);
	}
	
}
