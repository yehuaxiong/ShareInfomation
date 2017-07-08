package com.ssss.shareInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Admin;
import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponse;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.model.TeacherShow;
import com.ssss.shareInfo.service.TeacherService;

@Component("teacherService")
public class TeacherServiceImpl implements TeacherService {
	//-------用spring 将GenericDAO注入TeacherServiceImpl中
		public GenericDAO<Teacher>  teacherDao;		
		public GenericDAO<Teacher> getTeacherDao() {
			return teacherDao;
		}
		@Resource
		public void setTeacherDao(GenericDAO<Teacher> teacherDao) {
			this.teacherDao = teacherDao;
		}
	//-------
	
	@Override
	public Teacher login(Teacher teacher) {
		List<Teacher> teachers=teacherDao.findByNameQuery("Teacher.login",teacher.getId(),teacher.getPassword());
		if(teachers.size()>0){
			return teachers.get(0);
		}
		return null;
	}

	@Override
	public void editPassword(Teacher teacher) {
		Teacher editTeacher=teacherDao.findById(Teacher.class, teacher.getId());
		editTeacher.setPassword(teacher.getPassword());
	}

	@Override
	public void deleteBatch(String[] ids) {
		for(String idStr:ids){
			Integer id=Integer.parseInt(idStr);
			Teacher teacher=teacherDao.findById(Teacher.class, id);
			teacher.setId(id);
			teacher.setDeletedSign(true);
			
			teacherDao.update(teacher);
		}
	}

	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.save(teacher);
	}

	@Override
	public Teacher findTeacher(Integer id) {
		System.out.println("TeacherServiceimpl---"+id);
		return teacherDao.findById(Teacher.class, id);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDao.update(teacher);
	}
	@Override
	public PageResponse findPaginationData(Teacher teacher,
			PageRequestBean pageRequestBean) {
		int firstResult=(pageRequestBean.getPage()-1)*pageRequestBean.getRows();
		int maxResults=pageRequestBean.getRows();
		
		List<Teacher> teachers=teacherDao.findByCriteria(pageRequestBean.getDetachedCriteria(), firstResult, maxResults);

		TeacherShow teacherShow;
		List<TeacherShow> teacherShows=new ArrayList<TeacherShow>();
		for(Teacher t:teachers){
			teacherShow=new TeacherShow();
			
			teacherShow.setId(t.getId());
			teacherShow.setName(t.getName());
			teacherShow.setPassword(t.getPassword());
			teacherShow.setPhone(t.getPhone());
			teacherShow.setEmail(t.getEmail());
			teacherShow.setSex(t.getSex());
			teacherShow.setDepartment(t.getOffice().getDepartment().getDname());
			teacherShow.setOffice(t.getOffice().getRname());
			teacherShow.setTitle(t.getTitle());
			teacherShow.setPoliticalStatus(t.getPoliticalStatus());
			teacherShow.setImage(t.getImage());
			
			teacherShows.add(teacherShow);
		}
		
		
		PageResponse<TeacherShow> pageResponse=new PageResponse<TeacherShow>();
		pageResponse.setRows(teacherShows);
		int total=teacherDao.findByTotalCount(teacher);
		pageResponse.setTotal(total);
		
		return pageResponse;
	}
	@Override
	public int findTeacherCount(DetachedCriteria criteria) {
		return teacherDao.findByCriteria(criteria).size();
	}
	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return  teacherDao.findAll(new Teacher());
		
	}

}
