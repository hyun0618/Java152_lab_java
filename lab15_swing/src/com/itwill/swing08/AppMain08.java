package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

	private JFrame frame;
	private JLabel lblKorean;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JScrollPane scrollPane;
	private JButton btnEnter;
	private JLabel lblMath;
	private JLabel lblEnglish;
	private JTable table;
	
	private DefaultTableModel model;
	private JButton btnDelete;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();
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
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 23));
		lblKorean.setBounds(30, 10, 50, 50);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 23));
		textKorean.setBounds(88, 10, 130, 50);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 23));
		lblEnglish.setBounds(30, 70, 70, 50);
		frame.getContentPane().add(lblEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 23));
		textEnglish.setColumns(10);
		textEnglish.setBounds(88, 70, 130, 50);
		frame.getContentPane().add(textEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setFont(new Font("D2Coding", Font.PLAIN, 23));
		lblMath.setBounds(30, 130, 70, 50);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setFont(new Font("D2Coding", Font.PLAIN, 23));
		textMath.setColumns(10);
		textMath.setBounds(88, 130, 130, 50);
		frame.getContentPane().add(textMath);
		
		btnEnter = new JButton("입력");
		btnEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputScoreTo();
			}
		});
		btnEnter.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnEnter.setBounds(230, 130, 90, 50);
		frame.getContentPane().add(btnEnter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 190, 401, 231);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setFont(new Font("D2Coding", Font.PLAIN, 15));
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteScoreFrom();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnDelete.setBounds(332, 130, 90, 50);
		frame.getContentPane().add(btnDelete);
	}

	protected void deleteScoreFrom() {
		// 성적 테이블에서 선택한 행 삭제 하기. 
		// JTable에서 선택된 행의 인덱스를 찾음. 
		int index = table.getSelectedRow();
		
		if (index == -1) { // 테이블에서 선택된 행이 없을 때
			JOptionPane.showMessageDialog(
					frame, 
					"삭제할 행을 선택하세요."
					, "Error", 
					JOptionPane.WARNING_MESSAGE);
			return;	
		}
		
 		// 삭제 여부 확인
		int confirm = JOptionPane.showConfirmDialog(
				frame,
				"삭제하시겠습니까?",
				"Delete.",
				JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_NO_OPTION) {
			model.removeRow(index); // 테이블 (모델)에서 해당 인덱스의 행을 삭제.
			
		}
	}

	private void inputScoreTo() {
		// 1. JTtextField에서 3과목의 점수를 읽음. 
		int korean = 0;
		int english = 0;
		int math = 0;
		try {
			korean = Integer.parseInt(textKorean.getText());
			english = Integer.parseInt(textEnglish.getText());
			math = Integer.parseInt(textMath.getText());
		} catch (NumberFormatException e) {
			// 메시지 다이얼로그 띄우기.
			JOptionPane.showMessageDialog(
					frame,
					"정수로 입력하세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return; // "inputScoreTo()" 메서드 종료. => 에러발생시 아래 코드를 진행하지 않음. 
		}
		
		// 2. Score 타입의 객체를 생성.
		Score score = new Score(korean, english, math);
		
		// 3. JTable에 행(row)을 추가.
		Object[] row = {
				score.getKorean(),
				score.getEnlish(),
				score.getMath(),
				score.getTotal(),
				score.getMean()
		};
		model.addRow(row);

		
		// 4. JTextField의 내용을 모두 지움.
		clearAllTextFields();
		
	}
	
	private void clearAllTextFields() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
}
