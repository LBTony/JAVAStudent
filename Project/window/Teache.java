package Project.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Project.dao.TeacherDao;
import Project.dao.impl.TeacherDaoImpl;
import Project.domain.Teacher;
import javax.swing.JComboBox;

public class Teache extends JFrame {

	private JPanel contentPane;
	private JTextField input_name;
	private JTextField input_teach;
	private JPanel panel;
	private JButton btn_update;
	private JTextField input_search;
	private JComboBox load;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teache frame = new Teache();
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
	public Teache() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "\u65B0\u589E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 40, 211, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		input_name = new JTextField();
		input_name.setBounds(92, 26, 96, 21);
		panel.add(input_name);
		input_name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setBounds(36, 29, 46, 15);
		panel.add(lblNewLabel);
		
		input_teach = new JTextField();
		input_teach.setBounds(92, 57, 96, 21);
		panel.add(input_teach);
		input_teach.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("班級:");
		lblNewLabel_1.setBounds(36, 60, 46, 15);
		panel.add(lblNewLabel_1);
		//------------------------------------------------
		JButton btn_add = new JButton("新增");
		btn_add.setBounds(36, 108, 87, 23);
		panel.add(btn_add);
		
		btn_update = new JButton("更新");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				TeacherDao dao=new TeacherDaoImpl();
				Teacher t=new Teacher();
				t.setName("Tony");
				t.setTeach("1-2");
				t.setId(2);
				dao.update(t);
				
			}
		});
		btn_update.setBounds(10, 218, 87, 23);
		contentPane.add(btn_update);
		
		input_search = new JTextField();
		input_search.setBounds(244, 65, 96, 21);
		contentPane.add(input_search);
		input_search.setColumns(10);
		
		JButton btn_search = new JButton("搜尋");
		
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherDao dao=new TeacherDaoImpl();
				List<Teacher> list=dao.search();
				for(Teacher her:list) {
				System.out.println(her);
				}
				
				
			}
		});
		btn_search.setBounds(349, 64, 87, 23);
		contentPane.add(btn_search);
		
		JButton btn_delect = new JButton("刪除");
		btn_delect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherDao dao=new TeacherDaoImpl();
				dao.delete(Integer.parseInt( input_search.getText()));
				input_search.setText("");
				
				
			}
		});
		btn_delect.setBounds(349, 104, 87, 23);
		contentPane.add(btn_delect);
		
		load = new JComboBox();
		load.setBounds(244, 104, 96, 23);
		contentPane.add(load);
		getJComoboBox();
		
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherDao dao=new TeacherDaoImpl();
				Teacher te=new Teacher();
				
				te.setName(input_name.getText());
				te.setTeach(input_teach.getText());
				//清除輸入框
				input_name.setText("");
				input_teach.setText("");
				dao.add(te);
				
				
			}
		});
	}
	public void getJComoboBox() {
		TeacherDao dao=new TeacherDaoImpl();
		ResultSet rs=dao.loadNo();
		
		try {
			while(rs.next()) {
				load.addItem(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
