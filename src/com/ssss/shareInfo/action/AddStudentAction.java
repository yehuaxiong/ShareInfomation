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

/**
 * 添加用户和修改用户都会执行该类
 * @author LEO
 *
 */
public class AddStudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student student=new Student();	
	@Override
	public Student getModel() {
		return student;
	}
	
	private String claString;		
	public String getClaString() {
		return claString;
	}
	public void setClaString(String claString) {
		this.claString = claString;
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
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Claname.class);
		detachedCriteria.add(Restrictions.eq("cname", claString));
		Claname cla=clanameService.findCla(detachedCriteria);
		
		if(cla!=null){
			DetachedCriteria stuCriteria=DetachedCriteria.forClass(Student.class);
			stuCriteria.add(Restrictions.eq("claname", cla));
			int count=studentService.findClaStudent(stuCriteria);		
			int studentNo=cla.getCid()*100+count+1;
			
			student.setId(studentNo);
			student.setClaname(cla);
		}
		
		studentService.addStudent(student);				
		return NONE;
	}
	
}
