package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponseStudent;
import com.ssss.shareInfo.model.Student;

public interface StudentService {
	public Student login(Student student);//登录
	public void editPassword(Student student);//
	public void deleteBatch(String[] ids);//批量删除
	public void addStudent(Student student);//添加一个学生
	public void addBatch();//
	public Student findStudent(int id);//根据id查询
	public List<Student> findAll();//根据id查询
	public void updateStudent(Student student);//更改学生信息
	public int findClaStudent(DetachedCriteria criteria);
	public PageResponseStudent findPaginationData(Student student,PageRequestBean pageRequestBean);//使用分页查询
}
