package Project.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import Project.dao.TeacherDao;
import Project.dao.impl.TeacherDaoImpl;
import Project.domain.Teacher;

public class Demo02 {
	
	@Test
	public void test06() {
		TeacherDao dao=new TeacherDaoImpl();
		dao.loadNo();
		
		
	}
	
	
	
	//id搜尋
	@Test
	public void test05() {
		TeacherDao dao=new TeacherDaoImpl();
		Teacher teach=dao.findById(2);
		System.out.println(teach);
	}
	
	
	
	
	//刪除
	@Test
	public void test04() {
		TeacherDao dao=new TeacherDaoImpl();
		dao.delete(3);
		
	}
	
	//更新
	@Test
	public void test03() {
		TeacherDao dao=new TeacherDaoImpl();
		Teacher t=new Teacher();
		t.setId(3);
		t.setName("Tony");
		t.setTeach("1-2");
		t.setId(2);
		dao.update(t);
	}
	
	//搜尋
	@Test
	public void test02() {
		TeacherDao dao=new TeacherDaoImpl();
		List<Teacher> list=dao.search();
		for(Teacher her:list) {
		System.out.println(her);
		}
	}
		
	//新增
	@Test
	public void test01() {
	TeacherDao dao=new TeacherDaoImpl();
	Teacher te=new Teacher();
	te.setId(2);
	te.setName("Tony");
	te.setTeach("1-3");
	
	dao.add(te);
	}
}
