package Project.dao;

import java.sql.ResultSet;

import Project.base.BaseDao;
import Project.domain.Teacher;

public interface TeacherDao extends BaseDao<Teacher>{
	//Teacher獨有功能
	public Teacher findById(int id);
	
	public ResultSet loadNo();
}
