package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import antlr.Lookahead;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.StudentService;

public class EditStudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student student=new Student();	
	@Override
	public Student getModel() {
		return student;
	}
	
	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@Override
	public String execute(){
		try{
			if(student.getId()!=null){
				student=studentService.findStudent(student.getId());
			}else{
				System.out.println("*************id为空*************");
			}			
		}catch(Exception exception){
			System.out.println("+++++++++++出现异常++++++++++");
		}
		
//		System.out.println("***********"+student+"************");
		return SUCCESS;
	}

	
}
