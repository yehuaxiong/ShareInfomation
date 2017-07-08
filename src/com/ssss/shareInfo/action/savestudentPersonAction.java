package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.StudentService;

public class savestudentPersonAction extends ActionSupport implements ModelDriven<Student>{
	private Student student=new Student();	
	@Override
	public Student getModel() {
		return student;
	}
	
	private String _claname;

	public String get_claname() {
		return _claname;
	}

	public void set_claname(String _claname) {
		this._claname = _claname;
	}

	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@Override
	public String execute(){
		System.out.println("---------------1---------------");
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		try{
			//if(id!=0){
			Student	student1=studentService.findStudent(id);
		//	}else{
			student1.setPhone(student.getPhone());
			student1.setJob(student.getJob());
			student1.setEmail(student.getEmail());
			student1.setSex(student.getSex());
			student1.setPoliticalStatus(student.getPoliticalStatus());
			
				System.out.println(student1.getName()+"id为空*************");
			//}	
			studentService.updateStudent(student1);
		}catch(Exception exception){
			System.out.println("+++++++++++出现异常++++++++++");
		}
		
//		System.out.println("***********"+student+"************");
		return SUCCESS;
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	
	
}
