package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.StudentService;

public class queryStudentPInfo extends ActionSupport implements ModelDriven<Student>{
	private Student student=new Student();	
	@Override
	public Student getModel() {
		return student;
	}
	
	private String s="11111";
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
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
				student=studentService.findStudent(id);
		//	}else{
				System.out.println(student.getName()+"id为空*************");
			//}			
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