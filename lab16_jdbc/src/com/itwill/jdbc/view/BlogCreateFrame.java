package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BlogCreateFrame extends JFrame {
	
	public interface CreateNotify {
		void notifyCreateSuccess();
	}

	private static final long serialVersionUID = 1L;
	
	private BlogDao dao = BlogDao.getInstance();
	private CreateNotify app;
	
	private JPanel contentPane;

	private Component parent;
	private JLabel lblTitle;
	private JTextField textTitle;
	private JScrollPane scrollPane;
	private JTextArea textContent;
	private JTextField textWriter;
	private JButton btnCancel;
	private JButton btnSave;
	private JLabel lblContent;
	
	/**
	 * Launch the application.
	 */
	public static void showBlogCreateFrame(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogCreateFrame frame = new BlogCreateFrame(parent, app);
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
	
	private BlogCreateFrame(Component parent, CreateNotify app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}
	
	public void initialize() {
		setTitle("새 블로그 작성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX(); // 부모 컴포넌트의 x 좌표
			y = parent.getY(); // 부모 컴포넌트의 y 좌표
 		}
		setBounds(x, y, 302, 395);
		
		if (parent == null) {
			setLocationRelativeTo(null); // 화명 중앙에 JFrame을 띄움.
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblTitle.setBounds(12, 10, 57, 15);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textTitle.setBounds(12, 35, 262, 20);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		lblContent = new JLabel("내용");
		lblContent.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblContent.setBounds(12, 66, 57, 15);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 262, 153);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		scrollPane.setViewportView(textContent);
		
		JLabel lblTitle_1 = new JLabel("작성자");
		lblTitle_1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblTitle_1.setBounds(12, 254, 57, 15);
		contentPane.add(lblTitle_1);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textWriter.setColumns(10);
		textWriter.setBounds(12, 279, 130, 20);
		contentPane.add(textWriter);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> createNewBlog());
		btnSave.setBounds(12, 323, 97, 23);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("취소");
//		btnCancel.addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setBounds(177, 323, 97, 23);
		contentPane.add(btnCancel);
	}

	private void createNewBlog() {
		// 제목, 내용, 작성자에 입력된 내용을 Blog 객체로 만들어서 
		// DAO 메서드를 사용해서 DB 테이블에 insert.
		String title = textTitle.getText();
		String content = textContent.getText();
		String writer = textWriter.getText();
		if (title.equals("") || content.equals("") || writer.equals("")) {
			JOptionPane.showMessageDialog(
					BlogCreateFrame.this, 
					"제목, 내용, 작성자는 반드시 입력해야 합니다.", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return; 
		}
		
		Blog blog = new Blog(0, title, content, writer, null, null);
		int result = dao.create(blog);
		if (result == 1) {
			// TODO: BlogMain 프레임에게 테이블 삽입 성공을 알려줌. 
			app.notifyCreateSuccess();	
			dispose(); // 현재 창 닫기.
		} else {
			JOptionPane.showMessageDialog(BlogCreateFrame.this, "INSERT 실패");
		}
	}
}
