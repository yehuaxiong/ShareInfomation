package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.service.StudentService;

public class DeleteStudentAction extends ActionSupport{
	private String ids;

	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@Override
	public String execute() throws Exception {
		studentService.deleteBatch(ids.split(","));
		return NONE;
	}
}
