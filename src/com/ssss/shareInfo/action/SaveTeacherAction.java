package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.OfficeService;
import com.ssss.shareInfo.service.TeacherService;

public class SaveTeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	private Teacher teacher=new Teacher();
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	private String jys;
	public String getJys() {
		return jys;
	}
	public void setJys(String jys) {
		this.jys = jys;
	}
	
	private TeacherService teacherService;
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	private OfficeService officeService;
	@Resource(name="officeService")
	public void setOfficeService(OfficeService officeService) {
		this.officeService = officeService;
	}
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("*+*+*+*+*+*+"+teacher.getId());
		if(teacher.getId()!=null&&!teacher.getId().equals(0)){	
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Office.class);
			detachedCriteria.add(Restrictions.eq("rname", jys));			
			Office office=officeService.findOffice(detachedCriteria);		

			teacher.setOffice(office);

			teacherService.updateTeacher(teacher);
		}
			
		
		return SUCCESS;
	}
	
}
