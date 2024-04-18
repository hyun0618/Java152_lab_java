package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbPublic;
	private JRadioButton rbProtected;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JTextArea textArea;
	
	private JRadioButton selectedRadioButton;
	private ArrayList<JCheckBox> selectedCheckBoxs = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		rbPrivate = new JRadioButton("private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 23));
		rbPrivate.setBounds(20, 20, 110, 50);
		frame.getContentPane().add(rbPrivate);

		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 23));
		rbPackage.setBounds(150, 20, 110, 50);
		frame.getContentPane().add(rbPackage);

		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener((e) -> handleRadioButtonClick(e)); // 람다 표현식으로 이벤트 등록.
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 23));
		rbProtected.setBounds(280, 20, 140, 50);
		frame.getContentPane().add(rbProtected);

		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(this::handleRadioButtonClick); // 간단한 람다 표현식. // "this" ->
																	// "AppMain06.this::handleRadioButtonClick"
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 23));
		rbPublic.setBounds(435, 20, 100, 50);
		frame.getContentPane().add(rbPublic);

		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);

			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 23));
		cbAbstract.setBounds(20, 80, 130, 50);
		frame.getContentPane().add(cbAbstract);

		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener((e) -> handleCheckBoxClick(e));
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 23));
		cbFinal.setBounds(170, 80, 90, 50);
		frame.getContentPane().add(cbFinal);

		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(this::handleCheckBoxClick);
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 23));
		cbStatic.setBounds(280, 80, 110, 50);
		frame.getContentPane().add(cbStatic);

		comboBox = new JComboBox<>(); // new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택된 이메일을 textArea에 입력하기. 
				handleComboBoxChange(e);
				
//				String choose = comboBox.getSelectedItem().toString();
//				textArea.setText(choose);
			}
		});
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 23));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "kakao.com", "yahoo.com"})); 
		final String[] emails = { "naver.com", "gmail.com", "kakao.com", "yahoo.com" };

		comboBox.setModel(new DefaultComboBoxModel<>(emails));
		comboBox.setBounds(40, 150, 261, 50);
		frame.getContentPane().add(comboBox);

		btnInfo = new JButton("확인");
//		btnInfo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnInfo.addActionListener((ActionEvent e) -> { // 람다 표현식 (파라미터 타입 선언할 필요 없다.)
//			handleButtonClick();
//		});
		btnInfo.addActionListener((ActionEvent e) -> 
			handleButtonClick()
		);
		
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 23));
		btnInfo.setBounds(320, 150, 120, 50);
		frame.getContentPane().add(btnInfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 230, 515, 157);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 23));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// JTextArea에 출력할 문자열들을 붙일(append) 문자열 버퍼.
		StringBuffer buffer = new StringBuffer();
		
		// 어떤 라디오버튼이 선택됐는지,
		buffer.append("라디오 버튼: ");
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		
		
		// 어떤 체크박스가 선택됐는지, // 체크박스는 동시 선택이 가능하므로 else if 를 하면 안 된다. 
		buffer.append("\n체크박스: ");
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		} 
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		
		
		// 콤보박스에서 무슨 아이템이 선택됐는지
		
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append("\n콤보박스: ").append(selectedItem);
		
		// 문자열 버퍼의 내용을 JTextArea에 씀.
		textArea.setText(buffer.toString());
		
	}

	private void handleComboBoxChange(ActionEvent e) {
//		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
//		JComboBox<String> combo = (JComboBox<String>) e.getSource();
//		
//		// ComboBox에서 선택된 item 찾기.
//		int index = combo.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스.
//		String item = (String) combo.getSelectedItem(); // 콤보박스에서 선택된 아이템. 
//		
//		// JTextArea에 정보 출력
//		textArea.setText("[" + index + "]: " + item);
		
		String choose = comboBox.getSelectedItem().toString();
		textArea.setText(choose);		
	}

	private void handleCheckBoxClick(ActionEvent e) {
		// 3개의 체크박스 중 무엇이 클릭됐는지 찾기 
		JCheckBox cb = (JCheckBox) e.getSource();
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text + ": " + selected);		
	}

	private void handleRadioButtonClick(ActionEvent e) {
		// 4개의 라디오버튼 중 무엇이 클릭됐는지 찾기.
		JRadioButton rb = (JRadioButton) e.getSource(); // 캐스팅 주의! / getSource가 Object를 리턴.
		String text = rb.getText(); // 이벤트가 발생한 라디오버튼의 텍스트.
		boolean selected = rb.isSelected(); // 이벤트가 발생한 라디오버튼의 선택 여부.
		textArea.setText(text + ": " + selected);
	}
}
