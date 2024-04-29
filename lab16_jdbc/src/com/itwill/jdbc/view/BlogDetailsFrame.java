package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailsFrame extends JFrame {
	
	public interface UpdateNotify {
		public void notifyUpdateSuccess();
	}

	private static final long serialVersionUID = 1L;
	
	private BlogDao dao = BlogDao.getInstance();
	private Component parent;
	private int blogId;
	private UpdateNotify app;
	
	private JPanel contentPane;
	private JLabel lblId;
	private JTextField textId;
	private JLabel lblTitle;
	private JTextField textTitle;
	private JLabel lblContent;
	private JScrollPane scrollPane;
	private JTextArea textContent;
	private JLabel lblWriter;
	private JTextField textWriter;
	private JLabel lblCreated;
	private JTextField textCreated;
	private JLabel lblModified;
	private JTextField textModified;
	private JButton btnUpdate;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void showBlogDetailsFrame(Component parent, int blogId, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogDetailsFrame frame = new BlogDetailsFrame(parent, blogId, app);
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
	public BlogDetailsFrame(Component parent, int blogId, UpdateNotify app) {
		this.parent = parent;
		this.blogId = blogId;
		this.app = app;
		
		initialize();
		initializeBlog();
	}

	public void initialize() {
		setTitle("블로그 상세보기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 450, 550);
		
		if (parent == null) {
			setLocationRelativeTo(null);
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null); // absolute layout
		
		lblId = new JLabel("번호");
		lblId.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblId.setBounds(12, 10, 57, 20);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textId.setBounds(81, 8, 120, 25);
		contentPane.add(textId);
		textId.setColumns(10);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblTitle.setBounds(12, 40, 57, 20);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textTitle.setColumns(10);
		textTitle.setBounds(81, 43, 320, 25);
		contentPane.add(textTitle);
		
		lblContent = new JLabel("내용");
		lblContent.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblContent.setBounds(12, 78, 57, 20);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 78, 320, 300);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 15));
		scrollPane.setViewportView(textContent);
		
		lblWriter = new JLabel("작성자");
		lblWriter.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblWriter.setBounds(12, 392, 57, 20);
		contentPane.add(lblWriter);
		
		textWriter = new JTextField();
		textWriter.setEditable(false);
		textWriter.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textWriter.setColumns(10);
		textWriter.setBounds(81, 392, 120, 25);
		contentPane.add(textWriter);
		
		lblCreated = new JLabel("작성시간");
		lblCreated.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblCreated.setBounds(13, 428, 60, 20);
		contentPane.add(lblCreated);
		
		textCreated = new JTextField();
		textCreated.setEditable(false);
		textCreated.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textCreated.setColumns(10);
		textCreated.setBounds(81, 427, 120, 25);
		contentPane.add(textCreated);
		
		lblModified = new JLabel("수정시간");
		lblModified.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblModified.setBounds(213, 429, 60, 20);
		contentPane.add(lblModified);
		
		textModified = new JTextField();
		textModified.setEditable(false);
		textModified.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textModified.setColumns(10);
		textModified.setBounds(281, 428, 120, 25);
		contentPane.add(textModified);
		
		btnUpdate = new JButton("업데이트");
		btnUpdate.addActionListener((e) -> updateBlog());
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnUpdate.setBounds(185, 471, 97, 30);
		contentPane.add(btnUpdate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnCancel.setBounds(303, 471, 97, 30);
		contentPane.add(btnCancel);
		
	}
	
	private void initializeBlog() {
		Blog blog = dao.read(blogId);
		if (blog == null) return; 
		
		textId.setText(blogId + "");
		textTitle.setText(blog.getTitle());
		textContent.setText(blog.getContent());
		textWriter.setText(blog.getWriter());
		textCreated.setText(blog.getCreateTime().toString());
		textModified.setText(blog.getModifiedTime().toString());
		
	}

	private void updateBlog() {
		String title = textTitle.getText();
		String content = textContent.getText();
		if (title.equals("") || content.equals("")) {
			JOptionPane.showMessageDialog(
					this, 
					"제목과 내용을 입력하세요.", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}	
		
		
		Blog blog = new Blog(blogId, title, content, null, null, null);
		int result = dao.update(blog);
		if (result == 1) {
			app.notifyUpdateSuccess();
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "업데이트 실패");
		}
		
		
	}
}
