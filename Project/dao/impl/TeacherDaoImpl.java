package Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Project.dao.TeacherDao;
import Project.domain.Teacher;
import Project.utils.DBUtils;

public class TeacherDaoImpl implements TeacherDao{
	//新增
	@Override
	public void add(Teacher teacher) {
		Connection conn=DBUtils.getDB().getCnn();
		String addSQL="insert into teacher(id,name,teach)values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(addSQL);
			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getName());
			ps.setString(3, teacher.getTeach());
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	//刪除
	@Override
	public void delete(int i) {
		Connection conn=DBUtils.getDB().getCnn();
		String deleteSQL="delete from teacher where id=?";
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
	public void update(Teacher t) {
		Connection conn=DBUtils.getDB().getCnn();
		String UpdateSQL="Update teacher set name=?,teach=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(UpdateSQL);
			ps.setString(1, t.getName());
			ps.setString(2, t.getTeach());
			ps.setInt(3, t.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//搜尋
	@Override
	public List<Teacher> search() {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select name,teach from teacher";
		List<Teacher> list=new ArrayList<Teacher>();
		try {
			ResultSet rs=null;
			PreparedStatement ps=conn.prepareStatement(searchSQL);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Teacher her=new Teacher();
				her.setName(rs.getString(1));
				her.setTeach(rs.getString(2));

				list.add(her);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//id搜尋
	@Override
	public Teacher findById(int id) {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select id,name,teach from teacher where id=?";
		ResultSet rs=null;
		PreparedStatement ps;
		Teacher teach=null;
		try {
			ps=conn.prepareStatement(searchSQL);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				teach=new Teacher();
				teach.setId(id);
				teach.setId(rs.getInt(1));
				teach.setName(rs.getString(2));
				teach.setTeach(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teach;
	}


	@Override
	public ResultSet loadNo() {
		Connection conn=DBUtils.getDB().getCnn();
		String searchSQL="select * from teacher";
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

}
