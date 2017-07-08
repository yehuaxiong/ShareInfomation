package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.service.DepartmentService;

import flexjson.JSONSerializer;

public class DeptOptionAction extends ActionSupport{
	private DepartmentService departmentService;
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@Override
	public String execute() throws Exception {
		
		//�����ת��Ϊjson
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(departmentService.findAll());
		
		//���ؿͻ���
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);		
		return NONE;
	}
}
