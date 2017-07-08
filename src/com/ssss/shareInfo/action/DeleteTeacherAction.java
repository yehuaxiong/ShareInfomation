package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.service.TeacherService;

public class DeleteTeacherAction extends ActionSupport{
	private String ids;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	private TeacherService teacherService;
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@Override
	public String execute() throws Exception {
		teacherService.deleteBatch(ids.split(","));
		return NONE;
	}
}
