package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.service.DepartmentService;

@Component("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	public GenericDAO<Department>  departmentDao;			
	public GenericDAO<Department> getDepartmentDao() {
		return departmentDao;
	}
	@Resource
	public void setDepartmentDao(GenericDAO<Department> departmentDao) {
		this.departmentDao = departmentDao;
	}
	@Override
	public List<Department> findAll() {
		Department department=new Department();
		return departmentDao.findAll(department);
	}

	@Override
	public Department findDept(DetachedCriteria criteria) {
		List<Department> departments=departmentDao.findByCriteria(criteria);
		if(departments.size()>0){
			return departments.get(0);
		}
		return null;
	}

}
