package com.ssss.shareInfo.action;

import javax.annotation.Resource;

import org.apache.commons.io.input.SwappedDataInputStream;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.StudentService;

public class SaveBatchStudentAction extends ActionSupport{
	private String ids;
	private String name;
	private String password;
	private String claString;
	private String job;
	private String politicalStatu;

	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClaString() {
		return claString;
	}
	public void setClaString(String claString) {
		this.claString = claString;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPoliticalStatu() {
		return politicalStatu;
	}
	public void setPoliticalStatu(String politicalStatu) {
		this.politicalStatu = politicalStatu;
	}
	
	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	private ClanameService clanameService;	
	@Resource(name="clanameService")
	public void setClanameService(ClanameService clanameService) {
		this.clanameService = clanameService;
	}
	
	@Override
	public String execute() throws Exception {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Claname.class);
		detachedCriteria.add(Restrictions.eq("cname", claString));
		Claname cla=clanameService.findCla(detachedCriteria);
		System.out.println(cla.getCid()+"-------------"+cla.getCname());
		String namearray[]=name.split(",");
		
		
		String s1[]=ids.split(",");
		int[] idarray=new int[s1.length];
		for(int i=0;i<s1.length;i++){
			idarray[i]=Integer.parseInt(s1[i]);
			
			Student student=new Student();
			student.setId(idarray[i]);
			student.setName(namearray[i]);
			student.setPassword(password);
			student.setClaname(cla);
			student.setJob(job);
			student.setPoliticalStatus(politicalStatu);
			
			System.out.println("-------------------"+ids);
			
			studentService.addStudent(student);
		}

		System.out.println(password);
		System.out.println(claString);
		System.out.println(job);
		System.out.println(politicalStatu);
		return NONE;
	}
}
