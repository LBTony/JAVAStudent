package Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Project.dao.StudentDao;
import Project.domain.Student;
import Project.utils.DBUtils;

public class StudentDaoimpl implements StudentDao{
//新增
	@Override
	public void add(Student student) {
		Connection conn=DBUtils.getDB().getCnn();
		String addSQL="insert into student(id,named,pass,age,email,address)values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(addSQL);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getNamed());
			ps.setString(3 , student.getPass());
			ps.setInt(4, student.getAge());
			ps.setString(5 , student.getEmail());
			ps.setString(6, student.getAddress());
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
//刪除
	@Override
	public void delete(int i) {
		Connection conn=DBUtils.getDB().getCnn();
		String deleteSQL="delete from student where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(deleteSQL);
			ps.setInt(1, i);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//更新
	@Override
	public void update(Student stu) {
		Connection conn=DBUtils.getDB().getCnn();
		String updateSQL="update student set named=? ,pass=? ,age=? ,email=? ,address=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(updateSQL);
			ps.setString(1, stu.getNamed());
			ps.setString(2 , stu.getPass());
			ps.setInt(3, stu.getAge());
			ps.setString(4 , stu.getEmail());
			ps.setString(5, stu.getAddress());
			ps.setInt(6, stu.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//搜尋
	@Override
	public List<Student> search() {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select named,pass,age,email,address from student";
		List<Student> list=new ArrayList<Student>();
		try {
			ResultSet rs=null;
			PreparedStatement ps=conn.prepareStatement(searchSQL);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Student stu=new Student();
				stu.setNamed(rs.getString(1));
				stu.setPass(rs.getString(2));
				stu.setAge(rs.getInt(3));
				stu.setEmail(rs.getString(4));
				stu.setAddress(rs.getString(5));
				list.add(stu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//id搜尋
	@Override
	public Student findById(int id) {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select id,named,pass,age,email,address from student where id=?";
		ResultSet rs =null;
		PreparedStatement ps;
		Student stu=null;
		try {
			ps=conn.prepareStatement(searchSQL);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				stu=new Student();
				stu.setId(id);
				stu.setId(rs.getInt(1));
				stu.setNamed(rs.getString(2));
				stu.setPass(rs.getString(3));
				stu.setAge(rs.getInt(4));
				stu.setEmail(rs.getString(5));
				stu.setAddress(rs.getNString(6));
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return stu;
	}
	@Override
	public ResultSet loadNo() {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select * from student";
		ResultSet rs=null;
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(searchSQL);
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ResultSet searchAll() {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select id as 編號,named as 姓名,age as 年紀,email as 信箱,address as 地址 from student";
		ResultSet rs =null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(searchSQL);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ResultSet searchID(int id) {
	    Connection conn = DBUtils.getDB().getCnn();
	    String searchSQL = "SELECT id AS 編號, named AS 姓名, age AS 年紀, email AS 信箱, address AS 地址 FROM student WHERE id = ?";
	    ResultSet rs = null;
	    PreparedStatement ps;
	    
	    try {
	        ps = conn.prepareStatement(searchSQL);
	        ps.setInt(1, id);  // 設置查詢的 id 參數
	        rs = ps.executeQuery();  // 執行查詢，返回結果集
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return rs;  // 返回查詢結果
	}
}
