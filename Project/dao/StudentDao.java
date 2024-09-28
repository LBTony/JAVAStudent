package Project.dao;

import java.sql.ResultSet;

import Project.base.BaseDao;
import Project.domain.Student;

public interface StudentDao extends BaseDao<Student> {
	//student獨有功能
	public Student findById(int id);
	
	public ResultSet loadNo();
	
	public ResultSet searchAll();
	
	public ResultSet searchID(int id);
	
}
