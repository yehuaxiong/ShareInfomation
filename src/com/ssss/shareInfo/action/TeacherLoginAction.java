package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.TeacherService;

public class TeacherLoginAction extends ActionSupport implements ModelDriven<Teacher>{
	private TeacherService teacherService;
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	private String checkcode;	
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	private Teacher teacher=new Teacher();
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	@Override
	public String execute() throws Exception {
		//判断验证码是否正确
		String checkcodeSession=(String)ServletActionContext.getRequest().getSession().getAttribute("key");
		if(checkcodeSession==null||!checkcodeSession.equals(checkcode)){
			this.addFieldError("checkcode", "验证码输入不正确！");
			return INPUT;
		}
		//判断登录是否成功
		Teacher existTeacher=teacherService.login(teacher);
		if(existTeacher==null){
			this.addActionError("用户名或者密码错误！");
			return INPUT; 
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existTeacher", existTeacher);
			ServletActionContext.getRequest().getSession().setAttribute("id", existTeacher.getId());
			ServletActionContext.getRequest().getSession().setAttribute("username", existTeacher.getName());
			ServletActionContext.getRequest().getSession().setAttribute("password", existTeacher.getPassword());
			
			return SUCCESS;
		}
		
	}

}
