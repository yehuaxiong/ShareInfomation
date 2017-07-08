package com.ssss.shareInfo.action;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.SpecialtyService;

import flexjson.JSONSerializer;

public class ClaOptionAction extends ActionSupport{
	private ClanameService clanameService;
	@Resource
	public void setClanameService(ClanameService clanameService) {
		this.clanameService = clanameService;
	}
	
	private SpecialtyService specialtyService;
	@Resource
	public void setSpecialtyService(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	private String sname;		
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}



	@Override
	public String execute() throws Exception {
				
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Specialty.class);
		detachedCriteria.add(Restrictions.eq("sname", sname));
		System.out.println("--------"+specialtyService.findSpec(detachedCriteria).getClanames()+"---------");
		Set<Claname> clanames=specialtyService.findSpec(detachedCriteria).getClanames();
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(clanames);
		
		
//		System.out.println("********"+resultJson+"********");
		
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);		
		return NONE;
	}
}
