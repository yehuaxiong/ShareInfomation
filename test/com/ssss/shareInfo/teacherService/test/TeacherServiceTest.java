package com.ssss.shareInfo.teacherService.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.TeacherService;
import com.ssss.shareInfo.service.impl.TeacherServiceImpl;


public class TeacherServiceTest {

	@Test
	public void testLogin() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TeacherService teacherService=new TeacherServiceImpl();
		teacherService=(TeacherService) ac.getBean("teacherService");
		
		Teacher teacher=new Teacher();
		teacher.setId(53);
		teacher.setPassword("123456");
		
		System.out.println("-----------"+teacherService.login(teacher)+"----------");
	}

	@Test
	public void testEditPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTeacher() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TeacherService teacherService=new TeacherServiceImpl();
		teacherService=(TeacherService) ac.getBean("teacherService");
		
		Teacher teacher=new Teacher();
		teacher.setId(1410819001);
		teacher.setName("ÕÅÈý");
		teacher.setSex("ÄÐ");
		teacher.setPassword("123456");
		teacher.setPhone("13156894119");
		
		teacherService.addTeacher(teacher);
	}

	@Test
	public void testFindTeacher() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTeacher() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPaginationData() {
		fail("Not yet implemented");
	}

}
