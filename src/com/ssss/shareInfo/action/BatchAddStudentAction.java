package com.ssss.shareInfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.StudentService;

public class BatchAddStudentAction extends ActionSupport{
	private int number;
	private String password;
	private String claString;
	private String job;
	private String politicalStatu;
//	private int[] idArray=new int[60];
	private List<Integer> idArray=new ArrayList<Integer>();
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
//	public int[] getIdArray() {
//		return idArray;
//	}
//	public void setIdArray(int[] idArray) {
//		this.idArray = idArray;
//	}



	public List<Integer> getIdArray() {
		return idArray;
	}
	public void setIdArray(List<Integer> idArray) {
		this.idArray = idArray;
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
		System.out.println("###%#%#%#%#%#%#%#%#%#%##%claString:"+claString);
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Claname.class);
		detachedCriteria.add(Restrictions.eq("cname", claString));
		Claname cla=clanameService.findCla(detachedCriteria);
		
		//System.out.println("###%#%#%#%#%#%#%#%#%#%##%"+cla.getCid());
		
		if(cla!=null){
			DetachedCriteria stuCriteria=DetachedCriteria.forClass(Student.class);
			stuCriteria.add(Restrictions.eq("claname", cla));
			int count=studentService.findClaStudent(stuCriteria);		
			int studentNo=cla.getCid()*100+count+1;
			
			for(int i=0;i<number;i++){
				idArray.add(studentNo);
				studentNo++;

				System.out.println(studentNo);
			}
//			ServletActionContext.getRequest().getSession().setAttribute("idArray", idArray);
		}
		
		return super.execute();
	}
}
