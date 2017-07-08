package com.ssss.shareInfo.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.SpecialtyService;

import flexjson.JSONSerializer;

public class SpecOptionAction extends ActionSupport{
	private SpecialtyService specialtyService;
	@Resource
	public void setSpecialtyService(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	private DepartmentService departmentService;
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	private String dname;
		
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}


	@Override
	public String execute() throws Exception {
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
		detachedCriteria.add(Restrictions.eq("dname", dname));		
//		System.out.println("--------"+departmentService.findDept(detachedCriteria).getSpecialties()+"---------");
		Set<Specialty> specialties=departmentService.findDept(detachedCriteria).getSpecialties();
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(specialties);
		
//		if(dname==null){
//			System.out.println("-------null为空--------");
//		}else{
//			System.out.println("-------"+dname+"--------");
//		}
		
		
//		System.out.println("********"+resultJson+"********");
		
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);		
		return NONE;
	}
}
