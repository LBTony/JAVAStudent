package Project.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Project.dao.StudentDao;
import Project.dao.impl.StudentDaoimpl;
import Project.domain.Student;
import Project.utils.DBUtils;
import net.proteanit.sql.DbUtils;


import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class WinPage extends JFrame {

	private JPanel contentPane;
	private JTextField input_name;
	private JTextField input_age;
	private JTextField input_email;
	private JTextField input_address;
	private JPasswordField input_pass;
	private JTextField input_search;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinPage frame = new WinPage();
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
	public WinPage() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u65B0\u589E", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 22, 253, 285);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setBounds(20, 30, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setBounds(20, 61, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("年紀:");
		lblNewLabel_2.setBounds(20, 92, 46, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("郵件:");
		lblNewLabel_3.setBounds(20, 134, 46, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("地址:");
		lblNewLabel_4.setBounds(20, 184, 46, 15);
		panel.add(lblNewLabel_4);
		
		input_name = new JTextField();
		input_name.setBounds(56, 27, 185, 21);
		panel.add(input_name);
		input_name.setColumns(10);
		
		input_age = new JTextField();
		input_age.setBounds(56, 86, 66, 21);
		panel.add(input_age);
		input_age.setColumns(10);
		
		input_email = new JTextField();
		input_email.setBounds(56, 131, 185, 21);
		panel.add(input_email);
		input_email.setColumns(10);
		
		input_address = new JTextField();
		input_address.setBounds(56, 181, 185, 21);
		panel.add(input_address);
		input_address.setColumns(10);
		
		JButton btn_add = new JButton("新增");
		btn_add.setBounds(37, 243, 87, 23);
		panel.add(btn_add);
		
		
		input_pass = new JPasswordField();
		input_pass.setBounds(56, 55, 185, 21);
		panel.add(input_pass);
		
		JButton btn_update = new JButton("更新");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				StudentDao dao=new StudentDaoimpl();
				Student stu=new Student();
				stu.setNamed(input_name.getText());
				stu.setPass(input_pass.getText());
				stu.setAge(Integer.parseInt(input_age.getText()));
				stu.setEmail(input_email.getText());
				stu.setAddress(input_address.getText());
				stu.setId(Integer.parseInt(input_search.getText()));
				dao.update(stu);
				searchAll();
				
				 input_name.setText("");
		         input_pass.setText("");
		         input_age.setText("");
		         input_email.setText("");
		         input_address.setText("");
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "請輸入內容....");
				}
			}
		});
		btn_update.setBounds(20, 317, 87, 23);
		contentPane.add(btn_update);
		
		JButton btn_delect = new JButton("刪除");
		btn_delect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Integer.parseInt( input_search.getText());最簡單的寫法
				
				StudentDao dao=new StudentDaoimpl();
				dao.delete(Integer.parseInt( input_search.getText()));
				input_search.setText("");
				searchAll();
			}
		});
		btn_delect.setBounds(538, 35, 87, 23);
		contentPane.add(btn_delect);
		
		JButton btn_search = new JButton("搜尋");
		btn_search.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int searchID = Integer.parseInt(input_search.getText());
		        StudentDao dao = new StudentDaoimpl();
		        
		        // 查詢學生信息，返回結果集
		        ResultSet rs = dao.searchID(searchID);
		        
		        // 使用 DbUtils 將結果集轉換為 TableModel 並顯示在 JTable 中
		        table.setModel(DbUtils.resultSetToTableModel(rs));
		    }
		});
		/*btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			int searchID=Integer.parseInt(input_search.getText());
			StudentDao dao = new StudentDaoimpl();
			Student stu = dao.findById(searchID);
			table.setModel(DbUtils.resultSetToTableModel(stu));//錯誤解決處理
			
			}
		});*/

		btn_search.setBounds(441, 35, 87, 23);
		contentPane.add(btn_search);
		
		input_search = new JTextField();
		input_search.setBounds(273, 36, 158, 21);
		contentPane.add(input_search);
		input_search.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 67, 578, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//getJComboBox();
		searchAll();
		
		
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
					// TODO: handle exception
				
				StudentDao dao=new StudentDaoimpl();
				Student st=new Student();
				
				st.setNamed(input_name.getText());
				st.setPass(input_pass.getText());
				st.setAge(Integer.parseInt( input_age.getText()));//轉型
				st.setEmail(input_email.getText());
				st.setAddress(input_address.getText());
				//清除輸入框
				input_name.setText("");
				input_pass.setText("");
				input_age.setText("");
				input_email.setText("");
				input_address.setText("");
				dao.add(st);
				searchAll();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "請輸入內容....");
			}
		
			}	
		});
	}
	/*public void getJComboBox() {
		StudentDao dao=new StudentDaoimpl();
		ResultSet rs=dao.loadNo();
		try {
			while(rs.next()) {
				load.addItem(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	public void searchAll() {
		StudentDao dao=new StudentDaoimpl();
		ResultSet rs=dao.searchAll();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
}
