package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.itwill.swing07.MyFrame.Notifiable;

public class AppMain07 implements Notifiable {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnMyFrame;

	@Override
	public void notifyMessage(String message) {
		btnMyFrame.setText(message);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메시지 다이얼로그 보여주기
				// JOptionPane.showMessageDialog(frame, "안녕하세요."); // JFrame을 parentComponent로 하겠다. 
				JOptionPane.showMessageDialog(
						frame,                            // 부모 컴포넌트 
						"안녕하세요, Swing!",             // 다이얼로그 메시지 
						"Message",                        // 다이얼로그 타이틀
						JOptionPane.INFORMATION_MESSAGE); // 메시지 타입 -> 메시지 아이콘
			}
		});
		btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnMsgDlg.setBounds(12, 10, 410, 49);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Confirm(확인) 다이얼로그 보여주기. 
				// int result = JOptionPane.showConfirmDialog(frame, "저장하시겠습니까?");
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴퍼넌트
						"삭제하시겠습니까?", // 메시지  
						"삭제 확인", // 타이틀
						JOptionPane.YES_NO_OPTION, // 옵션 타입(버트 종류, 개수)
						JOptionPane.QUESTION_MESSAGE); // 메시지 타입 
				btnConfirmDlg.setText("confirm=" + result); 
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnConfirmDlg.setBounds(12, 69, 410, 49);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 다이얼로그 보여주기. (showInputDialog)
//				String result = JOptionPane.showInputDialog(
//						frame, 
//						"검색어를 입력하세요.", 
//						"Search", 
//						JOptionPane.OK_CANCEL_OPTION);
				
				final String[] selections = {"인*", "얼굴장부", "X", "너튜브"};
				Object result = JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트 
						"검색어를 입력하세요.", // 메시지
						"Search", // 타이틀
						JOptionPane.INFORMATION_MESSAGE, // 메시지 타입
						null, // 아이콘 
						selections, // 선택할 값들
						selections[3]); // 초기 선택값
				
				btnInputDlg.setText("입력: " + result);				
			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnInputDlg.setBounds(12, 128, 410, 49);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 내가 만든 다이얼로그 보여주기. 
				MyDialog.showMyDialog(frame); // frame이 아니라 null을 입력하면 화면 중앙에 위치.
			}								  // frame을 입력하면, frame을 기준으로 상대적으로 위치. 
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnCustomDlg.setBounds(12, 187, 410, 49);
		frame.getContentPane().add(btnCustomDlg);
		
		btnMyFrame = new JButton("Custom Frame");
		btnMyFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JFrame을 상속받는 객체 보여주기
				MyFrame.showMyFrame(frame, AppMain07.this);
				// => 아규먼트 frame: MyFrame 클래스가 부모 컴포넌트(JFrame) 정보를 사용할 수 있도록.
				// => 아규먼트 AppMain07.this: AppMain07 타입으로 생성된 객체(의 주소). 현재 객체.
				// MyFrame 클래스에서 AppMain07 객체의 public 메서드를 호출할 수 있도록. 
			}
		});
		btnMyFrame.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnMyFrame.setBounds(12, 246, 410, 49);
		frame.getContentPane().add(btnMyFrame);
	}

}
