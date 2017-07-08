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
		//�ж���֤���Ƿ���ȷ
		String checkcodeSession=(String)ServletActionContext.getRequest().getSession().getAttribute("key");
		if(checkcodeSession==null||!checkcodeSession.equals(checkcode)){
			this.addFieldError("checkcode", "��֤�����벻��ȷ��");
			return INPUT;
		}
		//�жϵ�¼�Ƿ�ɹ�
		Teacher existTeacher=teacherService.login(teacher);
		if(existTeacher==null){
			this.addActionError("�û��������������");
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
