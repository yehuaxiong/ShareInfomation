package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Admin;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.AdminService;

@Component("adminService")
public class AdminServiceImpl implements AdminService {
	//-------用spring 将GenericDAO注入AdminServiceImpl中
		public GenericDAO<Admin>  adminDao;		
		public GenericDAO<Admin> getAdminDao() {
			return adminDao;
		}
		@Resource
		public void setAdminDao(GenericDAO<Admin> adminDao) {
			this.adminDao = adminDao;
		}
	//-------
	
	
	@Override
	public Admin login(Admin admin) {
		List<Admin> admins=adminDao.findByNameQuery("Admin.login",admin.getId(),admin.getPassword());
		if(admins.size()>0){
			return admins.get(0);
		}
		return null;
	}

	@Override
	public void editPassword(Admin admin) {
		Admin editAdmin=adminDao.findById(Admin.class, admin.getId());
		
		editAdmin.setPassword(admin.getPassword());
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub

	}

}
