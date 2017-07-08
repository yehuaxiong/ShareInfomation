package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.TeacherService;

public class EditTeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	private Teacher teacher=new Teacher();
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	private TeacherService teacherService;
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@Override
	public String execute() throws Exception {

		teacher=teacherService.findTeacher(teacher.getId());
		
		return SUCCESS;
	}

}
