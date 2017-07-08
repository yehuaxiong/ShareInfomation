package com.ssss.shareInfo.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.OfficeService;
import com.ssss.shareInfo.service.TeacherService;

public class AddTeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	private Teacher teacher=new Teacher();
	private String _office;
	public String get_office() {
		return _office;
	}

	public void set_office(String _office) {
		this._office = _office;
	}

	@Override
	public Teacher getModel() {
		return teacher;
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
	public OfficeService getOfficeService() {
		return officeService;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("------"+_office+"---------");
		//≤È’“office¿‡
		DetachedCriteria criteria=DetachedCriteria.forClass(Office.class);
		criteria.add(Restrictions.eq("rname", _office));
		Office office=officeService.findOffice(criteria);
		
		if(office!=null){
			teacher.setOffice(office);
			criteria=DetachedCriteria.forClass(Teacher.class);
			criteria.add(Restrictions.eq("office",office));
			int k=teacherService.findTeacherCount(criteria);
			teacher.setId(office.getRid()*1000+k+1);
			System.out.println(office.getRname());
			teacherService.addTeacher(teacher);
			System.out.println("yes !!!!"+office.getRname());
		}	
		
		return NONE;
	}
}
