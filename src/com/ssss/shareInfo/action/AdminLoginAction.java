package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Admin;
import com.ssss.shareInfo.service.AdminService;

public class AdminLoginAction extends ActionSupport implements ModelDriven<Admin>{
	private AdminService adminService;
	@Resource(name="adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	private String checkcode;	
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	private Admin admin=new Admin();
	@Override
	public Admin getModel() {
		return admin;
	}
	
	@Override
	public String execute() throws Exception {
		//�ж���֤���Ƿ���ȷ
		String checkcodeSession=(String)ServletActionContext.getRequest().getSession().getAttribute("key");
		if(checkcodeSession==null||!checkcodeSession.equals(checkcode)){
			this.addFieldError("checkcode", "��֤�����벻��ȷ��");
			return INPUT;
		}
		//�жϵ�¼�Ƿ�ɹ�
		Admin existAdmin=adminService.login(admin);
		if(existAdmin==null){
			this.addActionError("�û��������������");
			return INPUT; 
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existAdmin", existAdmin);

			ServletActionContext.getRequest().getSession().setAttribute("id", existAdmin.getId());
			ServletActionContext.getRequest().getSession().setAttribute("username", existAdmin.getName());
			ServletActionContext.getRequest().getSession().setAttribute("password", existAdmin.getPassword());
			
			return SUCCESS;
		}
		
	}

}
