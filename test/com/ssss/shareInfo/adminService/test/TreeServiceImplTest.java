package com.ssss.shareInfo.adminService.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.model.Tree;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.SpecialtyService;
import com.ssss.shareInfo.service.impl.ClanameServiceImpl;
import com.ssss.shareInfo.service.impl.DepartmentServiceImpl;
import com.ssss.shareInfo.service.impl.SpecialtyServiceImpl;
import com.ssss.shareInfo.service.impl.TreeServiceImpl;

import flexjson.JSONSerializer;

public class TreeServiceImplTest {

	@Test
	public void testFindAll() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TreeServiceImpl treeServiceImpl=new TreeServiceImpl();		
		treeServiceImpl=(TreeServiceImpl) ac.getBean("treeService");
		
		DepartmentService departmentService=(DepartmentService) ac.getBean("departmentService");
		SpecialtyService specialtyService=(SpecialtyService) ac.getBean("specialtyService");
		ClanameService clanameService=(ClanameService) ac.getBean("clanameService");
		List<Department> departments=departmentService.findAll();
		List<Specialty> specialties=specialtyService.findAll();
		List<Claname> clanames=clanameService.findAll();
		
		List<Tree> trees=new ArrayList<Tree>();
		
		for(Department department:departments){
			Tree tree=new Tree();
			tree.setId(department.getDid());
			tree.setpId(department.getPid());
			tree.setName(department.getDname());
			trees.add(tree);
		}
		for(Specialty specialty:specialties){
			Tree tree=new Tree();
			tree.setId(specialty.getSid());
			tree.setpId(specialty.getDepartment().getDid());
			tree.setName(specialty.getSname());
			trees.add(tree);
		}
		for(Claname claname:clanames){
			Tree tree=new Tree();
			tree.setId(claname.getCid());
			tree.setpId(claname.getSpecialty().getSid());
			tree.setName(claname.getCname());
			trees.add(tree);
		}
		
//		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
//		detachedCriteria.add(Restrictions.eq("dname", "外国语学院"));		
//		System.out.println("--------"+departmentService.findDept(detachedCriteria).getSpecialties()+"---------");
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Specialty.class);
		detachedCriteria.add(Restrictions.eq("sname", "软件工程"));
		System.out.println("--------"+specialtyService.findSpec(detachedCriteria).getClanames()+"---------");
				
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(trees);
		
		System.out.println("*********"+resultJson+"***********");
	}

}
