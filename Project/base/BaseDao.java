package Project.base;

import java.sql.ResultSet;
import java.util.List;

import Project.domain.Student;
//所有程式相同功能
//第一層(最上層)
public interface BaseDao<T> {
	//新增抽象
	public void add(T t);
	
	//刪除
	public void delete(int t);
	
	//更新
	public void update(T t);
	
	//搜尋
	public List<T> search();
}
