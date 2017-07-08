package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;

public interface DepartmentService {
	public List<Department> findAll();
	public Department findDept(DetachedCriteria criteria);
}
