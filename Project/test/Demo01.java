package Project.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import Project.dao.StudentDao;
import Project.dao.impl.StudentDaoimpl;
import Project.domain.Student;

public class Demo01 {
	
	
	@Test
	public void test06(){
		StudentDao dao= new StudentDaoimpl();
		dao.loadNo();
	}
	
	
	//id搜尋
	@Test
	public void test05() {
		StudentDao dao=new StudentDaoimpl();
		Student stu=dao.findById(1);
		System.out.println(stu);
	}
	
	
	
	
	
	//刪除
	@Test
	public void test04(){
		StudentDao dao=new StudentDaoimpl();
		dao.delete(37);
		
		
	}
	//更新
	@Test
	public void test03() {
		StudentDao dao=new StudentDaoimpl();
		Student stu=new Student();
		stu.setNamed("Tony");
		stu.setPass("12316");
		stu.setAge(23);
		stu.setEmail("Tony@gmail.com");
		stu.setAddress("Taiwan");
		stu.setId(4);
		dao.update(stu);
		
		
	}
	//搜尋
	@Test
	public void test02() {
		StudentDao dao=new StudentDaoimpl();
		List<Student> list=dao.search();
		for(Student stu:list) {
		System.out.println(stu);
		}
		}

	//新增
	@Test
	public void test01() {
		
		
		StudentDao dao=new StudentDaoimpl();
		Student st=new Student();
		st.setId(4);
		st.setNamed("Tony");
		st.setPass("16");
		st.setAge(35);
		st.setEmail("Tony@gmail.com");
		st.setAddress("Taiwan");
		
		
		dao.add(st);
	}
}
