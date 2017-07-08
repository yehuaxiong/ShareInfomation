package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.StudentService;

public class SaveStudentAction extends ActionSupport implements ModelDriven<Student>{
	Student student=new Student();
	@Override
	public Student getModel() {
		return student;
	}
	
	private String bj;
	public String getBj() {
		return bj;
	}
	public void setBj(String bj) {
		this.bj = bj;
	}

	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	private ClanameService clanameService;	
	@Resource(name="clanameService")
	public void setClanameService(ClanameService clanameService) {
		this.clanameService = clanameService;
	}
	
	
	@Override
	public String execute() throws Exception {
		if(student.getId()!=null&&!student.getId().equals(0)){

			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Claname.class);
			detachedCriteria.add(Restrictions.eq("cname", bj));		
			student.setClaname(clanameService.findCla(detachedCriteria));		
			studentService.updateStudent(student);
		}		
		return SUCCESS;
	}
}
