package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponse;
import com.ssss.shareInfo.model.PageResponseStudent;
import com.ssss.shareInfo.model.Teacher;;

public interface TeacherService {
	public Teacher login(Teacher teacher);
	public void editPassword(Teacher teacher);
	public void deleteBatch(String[] ids);
	public void addTeacher(Teacher teacher);
	public Teacher findTeacher(Integer id);
	public int findTeacherCount(DetachedCriteria criteria);
	public List<Teacher> findAll();
	
	public void updateTeacher(Teacher teacher);
	public PageResponse findPaginationData(Teacher teacher,PageRequestBean pageRequestBean);//使用分页查询
}
