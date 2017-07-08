package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Admin;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.AdminService;
import com.ssss.shareInfo.service.StudentService;
import com.ssss.shareInfo.service.TeacherService;

import freemarker.template.utility.Execute;

public class EditPwdAction extends ActionSupport{
	private String password;
	private String id;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	private AdminService adminservice;
	@Resource(name="adminService")
	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}
	
	private TeacherService teacherService;
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("************"+password);
		System.out.println("************"+id);
		
		if(id.length()==5){
			Admin admin=new Admin();
			admin.setId(Integer.valueOf(id));
			admin.setPassword(password);
			adminservice.editPassword(admin);
			ServletActionContext.getRequest().getSession().setAttribute("password", password);
		}else if(id.length()==10){
			Student student=new Student();
			student.setId(Integer.valueOf(id));
			student.setPassword(password);
			studentService.editPassword(student);
			ServletActionContext.getRequest().getSession().setAttribute("password", password);
		}else{
			Teacher teacher=new Teacher();
			teacher.setId(Integer.valueOf(id));
			teacher.setPassword(password);
			teacherService.editPassword(teacher);
			ServletActionContext.getRequest().getSession().setAttribute("password", password);
		}
		
		return NONE;
	}
}
