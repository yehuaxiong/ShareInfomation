package com.ssss.shareInfo.service;

import com.ssss.shareInfo.model.Admin;

public interface AdminService {
	public Admin login(Admin admin);
	public void editPassword(Admin admin);
	public void updateAdmin(Admin admin);
}
