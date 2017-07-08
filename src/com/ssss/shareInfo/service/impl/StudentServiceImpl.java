package com.ssss.shareInfo.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponseStudent;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.model.StudentShow;
import com.ssss.shareInfo.service.StudentService;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
	//-------用spring 将GenericDAO注入StudentServiceImpl中
	public GenericDAO<Student>  studentDao;		
	public GenericDAO<Student> getStudentDao() {
		return studentDao;
	}
	@Resource
	public void setStudentDao(GenericDAO<Student> studentDao) {
		this.studentDao = studentDao;
	}
	//-------
	
	@Override
	public Student login(Student student) {
		List<Student> students=studentDao.findByNameQuery("Student.login",student.getId(),student.getPassword());
		if(students.size()>0){
			return students.get(0);
		}
		return null;
	}

	@Override
	public void editPassword(Student student) {
		Student editStudent=studentDao.findById(Student.class, student.getId());
		editStudent.setPassword(student.getPassword());
	}

	@Override
	public void deleteBatch(String[] ids) {
		for(String idStr:ids){
//			Integer id=Integer.parseInt(idStr);
//			Student student=new Student();
//			student.setId(id);
//			
//			studentDao.delecte(student);
			
			Integer id=Integer.parseInt(idStr);
			Student student=studentDao.findById(Student.class, id);
			student.setId(id);
			student.setDeletedSign(true);
			
			studentDao.update(student);
		}
	}

	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	@Override
	public Student findStudent(int id) {
		return studentDao.findById(Student.class, id);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.update(student);
	}
	
	@Override
	public PageResponseStudent findPaginationData(Student student,
			PageRequestBean pageRequestBean) {
		int firstResult=(pageRequestBean.getPage()-1)*pageRequestBean.getRows();
		int maxResults=pageRequestBean.getRows();
		
//		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Student.class);
//		List<Student> students=studentDao.findByCriteria(detachedCriteria, firstResult, maxResults);
		
		List<Student> students=studentDao.findByCriteria(pageRequestBean.getDetachedCriteria(), firstResult, maxResults);
		StudentShow studentShow;
		List<StudentShow> studentShows=new ArrayList<StudentShow>();
		for(Student stu:students){
			studentShow=new StudentShow();
			
			studentShow.setId(stu.getId());
			studentShow.setName(stu.getName());
			studentShow.setSex(stu.getSex());
			studentShow.setPhone(stu.getPhone());
			studentShow.setEmail(stu.getEmail());
			
			studentShow.setDepartment(stu.getClaname().getSpecialty().getDepartment().getDname());
			studentShow.setSpecialty(stu.getClaname().getSpecialty().getSname());
			studentShow.setClaname(stu.getClaname().getCname());
			
			studentShow.setJob(stu.getJob());
			studentShow.setPoliticalStatus(stu.getPoliticalStatus());
			studentShow.setPassword(stu.getPassword());
			
			studentShows.add(studentShow);
		}
		
		
		PageResponseStudent pageResponseStudent=new PageResponseStudent();
		pageResponseStudent.setRows(studentShows);
		int total=studentDao.findByTotalCount(student);
		pageResponseStudent.setTotal(total);
		
		return pageResponseStudent;
	}
	
	@Override
	public void addBatch() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int findClaStudent(DetachedCriteria criteria) {
		return studentDao.findByCriteria(criteria).size();
	}
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		return studentDao.findAll(new Student());
	}

}
