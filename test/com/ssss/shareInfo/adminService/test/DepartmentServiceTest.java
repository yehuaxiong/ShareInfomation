package com.ssss.shareInfo.adminService.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.SpecialtyService;
import com.ssss.shareInfo.service.impl.DepartmentServiceImpl;

public class DepartmentServiceTest {

	@Test
	public void testFindAll() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		DepartmentService departmentService=new DepartmentServiceImpl();
		departmentService=(DepartmentService) ac.getBean("departmentService");
		
		System.out.println("--------"+departmentService.findAll()+"---------");
	}
	
	@Test
	public void testFindDept(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		DepartmentService departmentService=(DepartmentService) ac.getBean("departmentService");
		SpecialtyService specialtyService=(SpecialtyService) ac.getBean("specialtyService");
		ClanameService clanameService=(ClanameService) ac.getBean("clanameService");
		
		DetachedCriteria deptCriteria=DetachedCriteria.forClass(Department.class);
		deptCriteria.add(Restrictions.eq("dname", "外国语学院"));
		Department dept=departmentService.findDept(deptCriteria);
		
		DetachedCriteria specCriteria=DetachedCriteria.forClass(Specialty.class);
		specCriteria.add(Restrictions.eq("department", dept));
		List<Specialty> specs=specialtyService.findSpecs(specCriteria);
		for(Specialty spec:specs){
			System.out.println("++++++++++++spec="+spec.getSname());
		}
		
	}

}
