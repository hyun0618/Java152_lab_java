package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {
	public interface Notifiable {
		public void notifyMessage(String msg);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btn;
	
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위한 필드.
	private Notifiable app; // notifyMessage(String msg) 메서드를 갖는 객체의 주소를 저장할 필드.

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parentComponent, Notifiable app) { // JFrame, JDialog 연결하기 위해서 Component 로 정의.
		/*
		 * Component
		 * |__ JFrame, JDialog
		 */
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame(parentComponent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame(Component parentComponent, Notifiable app) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}

	private void initialize() {
		// JFrame의 닫기 버튼의 기본 동작 설정:
		// (1) EXIT_ON_CLOSE: 메인 쓰레드까지 종료.
		// (2) DISPOSE_ON_CLOSE: 현재 JFrame만 종료.(메인 쓰레드는 계속 실행.)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			x = parentComponent.getX(); // 부모 컴포넌트의 x좌표
			y = parentComponent.getY(); // 부모 컴포넌트의 y좌표
		}
		setBounds(x, y, 450, 300);
		
		if (parentComponent == null) { // 부모 컴포넌트의 정보가 없을 때
			setLocationRelativeTo(null); // 화면 중앙에 위치시킴. 
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null); // absolute layout
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 23));
		textField.setBounds(12, 10, 410, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btn = new JButton("확인");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JTextField의 내용을 읽음. 
				String msg = textField.getText(); 
				app.notifyMessage(msg); // 인터페이스 타입으로 notifyMessage 메서드를 구현하고 있기 떄문.
			}
		});
		btn.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btn.setBounds(12, 70, 410, 50);
		contentPane.add(btn);
 	}
}
