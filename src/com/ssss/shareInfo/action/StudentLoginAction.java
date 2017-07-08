package com.ssss.shareInfo.action;

import javax.annotation.Resource;
import javax.mail.Session;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.StudentService;

public class StudentLoginAction extends ActionSupport implements ModelDriven<Student>{
	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	private String checkcode;	
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	private Student student=new Student();
	@Override
	public Student getModel() {
		return student;
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
		Student existStudent=studentService.login(student);
		if(existStudent==null){
			this.addActionError("�û��������������");
			return INPUT; 
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existStudent", existStudent);
			ServletActionContext.getRequest().getSession().setAttribute("id", existStudent.getId());
			ServletActionContext.getRequest().getSession().setAttribute("username", existStudent.getName());
			ServletActionContext.getRequest().getSession().setAttribute("password", existStudent.getPassword());
			
			return SUCCESS;
		}
		
	}

}
