package com.ssss.shareInfo.adminService.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssss.shareInfo.model.Admin;
import com.ssss.shareInfo.service.AdminService;
import com.ssss.shareInfo.service.impl.AdminServiceImpl;

public class AdminServiceTest {

	@Test
	public void testLogin() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		AdminService adminService=new AdminServiceImpl();
		adminService=(AdminService) ac.getBean("adminService");
		
		Admin admin=new Admin();
		admin.setId(10001);
		admin.setPassword("123456");
		
		System.out.println("-----------"+adminService.login(admin)+"----------");
	}

	@Test
	public void testEditPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAdmin() {
		fail("Not yet implemented");
	}

}
