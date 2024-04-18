package com.itwill.swing07;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	// 부모 컴포넌트를 저장하기 위한 필드.
	private Component parentComponent;

	/**
	 * Launch the application.
	 */
	public static void showMyDialog(Component parentComponent) { // "parentComponent"
		try {
			MyDialog dialog = new MyDialog(parentComponent); // 
			
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
//			dialog.setLocationRelativeTo(parentComponent); // 다이얼로그가 부모의 가운데에 위치하는 방법(2)
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyDialog(Component parentComponent) { // 생성자는 초기화작업을 진행.
		this.parentComponent = parentComponent;
		initialize();
	}

	private void initialize() {
		// 다이얼로그의 좌표(x, y)와 크기(width, height).
		setBounds(100, 100, 600, 400);
		
//		setLocationRelativeTo(null); // setBounds의 (x, y) 좌표를 무시하고 항상 스크린의 가운데에 위치.
		setLocationRelativeTo(parentComponent); // setBounds의 (x, y) 좌표를 무시하고 부모의 가운데에 위치.

		// 다이얼로그의 닫기 버튼[x]의 기본 동작 설정:
		// DISPOSE_ON_CLOSE: 현재 다이얼로그만 닫고, 메인 프로세스는 계속 실행.
		// EXIT_ON_CLOSE: 현재 다이얼로그와 함께 메인 프로세스까지 종료.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// getContentPane(): 컨텐트 영역 + 버튼 영역
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 150, 30);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textField.setBounds(10, 50, 150, 50);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 120, 150, 30);
		contentPanel.add(btnNewButton);

		// buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			
					cancelButton = new JButton("Cancel");
					cancelButton.setFont(new Font("D2Coding", Font.PLAIN, 23));
					cancelButton.setActionCommand("Cancel");
					buttonPanel.add(cancelButton);

			okButton = new JButton("OK");
			okButton.setFont(new Font("D2Coding", Font.PLAIN, 23));
			okButton.setActionCommand("OK");
			buttonPanel.add(okButton);
			getRootPane().setDefaultButton(okButton);

	} // end initialize()
	
}
