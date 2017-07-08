package com.ssss.shareInfo.action;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.OfficeService;

import flexjson.JSONSerializer;

public class OfcOptionAction extends ActionSupport{
	private OfficeService officeService;
	@Resource
	public void setOfficeService(OfficeService officeService) {
		this.officeService = officeService;
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
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+dname);
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
		detachedCriteria.add(Restrictions.eq("dname", dname));		
		
		Set<Office> offices=departmentService.findDept(detachedCriteria).getOffices();
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@"+offices);
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(offices);
		
		
//		System.out.println("********"+resultJson+"********");
		
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);		
		return NONE;
	}
}
