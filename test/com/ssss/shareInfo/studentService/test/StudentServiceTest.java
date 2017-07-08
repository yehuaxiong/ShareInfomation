package com.ssss.shareInfo.studentService.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponseStudent;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.model.StudentShow;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.SpecialtyService;
import com.ssss.shareInfo.service.StudentService;
import com.ssss.shareInfo.service.impl.StudentServiceImpl;

public class StudentServiceTest {

	@Test
	public void testLogin() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=new StudentServiceImpl();
		studentService=(StudentService) ac.getBean("studentService");
		
		Student student=new Student();
		student.setId(1410819001);
		student.setPassword("123456");
		
		System.out.println("-----------"+studentService.login(student)+"----------");
	}

	@Test
	public void testEditPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=(StudentService) ac.getBean("studentService");	
		
		String[] ids=new String[] {"1"};
		studentService.deleteBatch(ids);
	}

	@Test
	public void testAddStudent() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=(StudentService) ac.getBean("studentService");
		ClanameService clanameService=(ClanameService) ac.getBean("clanameService");
		DepartmentService departmentService=(DepartmentService) ac.getBean("departmentService");
		
		Student student=new Student();
//		student.setId(1410819001);
		student.setName("叶华雄");
		student.setSex("男");
		student.setPassword("123456");
		student.setPhone("13156894119");
		student.setJob("无");
		student.setEmail("734646564@qq.com");
		student.setPoliticalStatus("党员");
		
		String cname="14软件工程一班";
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Claname.class);
		detachedCriteria.add(Restrictions.eq("cname", cname));
		Claname cla=clanameService.findCla(detachedCriteria);
		
		if(cla!=null){
			DetachedCriteria stuCriteria=DetachedCriteria.forClass(Student.class);
			stuCriteria.add(Restrictions.eq("claname", cla));
			int count=studentService.findClaStudent(stuCriteria);		
			int studentNo=cla.getCid()*100+count+1;
			
			student.setId(studentNo);
			student.setClaname(cla);
		}	
		
		
		studentService.addStudent(student);
	}

	@Test
	public void testFindStudent() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=(StudentService) ac.getBean("studentService");
		
		Student student=studentService.findStudent(1410819001);
		System.out.println(student);
	}

	@Test
	public void testUpdateStudent() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=new StudentServiceImpl();
		studentService=(StudentService) ac.getBean("studentService");
		
		Student student=studentService.findStudent(1410819001);
		
		student.setName("张三");
//		student.setSex("男");
//		student.setPassword("123456");
//		student.setPhone("13156894119");
//		student.setJob("无");
//		student.setEmail("78231564@qq.com");
//		student.setPoliticalStatus("群众");
		
				
		studentService.updateStudent(student);
	}
	
	@Test
	public void testFindPagination(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=new StudentServiceImpl();
		studentService=(StudentService) ac.getBean("studentService");
		
		PageRequestBean pageRequestBean=new PageRequestBean();
		pageRequestBean.setPage(1);//设置要跳转到的页码
		pageRequestBean.setRows(3);//设置每页显示行数
		
		//student此处仅仅是用来在  findPaginationData(student, pageRequestBean)中传递类的类型
		Student student=new Student();
		StudentShow studentShow=new StudentShow();		
		PageResponseStudent pageResponseStudent=studentService.findPaginationData(student, pageRequestBean);
		
		for(StudentShow stu:pageResponseStudent.getRows()){
			System.out.println(stu);
		}
		
		
	}

}
