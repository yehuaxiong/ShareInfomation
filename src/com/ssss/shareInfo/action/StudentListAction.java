package com.ssss.shareInfo.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponseStudent;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.SpecialtyService;
import com.ssss.shareInfo.service.StudentService;

import flexjson.JSONSerializer;

public class StudentListAction extends ActionSupport implements ModelDriven<PageRequestBean>{
	private PageRequestBean pageRequestBean=new PageRequestBean();
	@Override
	public PageRequestBean getModel() {
		// TODO Auto-generated method stub
		return pageRequestBean;
	}

	private Student student=new Student();//������������һ��Student����
	
	private String department;
	private String specialty;
	private String claname;
	private String job;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getClaname() {
		return claname;
	}
	public void setClaname(String claname) {
		this.claname = claname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	private StudentService studentService;	
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	private ClanameService clanameService;
	@Resource(name="clanameService")
	public void setClanameService(ClanameService clanameService) {
		this.clanameService = clanameService;
	}
	
	private SpecialtyService specialtyService;
	@Resource(name="specialtyService")	
	public void setSpecialtyService(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	private DepartmentService departmentService;
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@Override
	public String execute() throws Exception {
		//��װ����
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Student.class);		
		
		if(department!=null && !department.equals("����ѧԺ")){
			DetachedCriteria deptCriteria=DetachedCriteria.forClass(Department.class);
			deptCriteria.add(Restrictions.eq("dname", department));
			Department dept=departmentService.findDept(deptCriteria);
			
			
			DetachedCriteria claCriteria=DetachedCriteria.forClass(Claname.class);
			claCriteria.add(Restrictions.in("specialty", dept.getSpecialties()));
			List<Claname> clas=clanameService.findClas(claCriteria);
			
			
			detachedCriteria.add(Restrictions.in("claname" , clas));
						
			System.out.println("-----------�Ѳ�ѯѧԺ------------");
		}
		
		if(specialty!=null && !specialty.equals("����רҵ")){
			DetachedCriteria specCriteria=DetachedCriteria.forClass(Specialty.class);
			specCriteria.add(Restrictions.eq("sname", specialty));
			Specialty spec=specialtyService.findSpec(specCriteria);
			System.out.println("--------"+spec.getSname()+"---------");
			
			
			detachedCriteria.add(Restrictions.in("claname" , spec.getClanames() ));
			
			System.out.println("-----------�Ѳ�ѯרҵ------------");
		}
		
		if(claname!=null && !claname.equals("���а༶")){
			DetachedCriteria criteria=DetachedCriteria.forClass(Claname.class);			
			criteria.add(Restrictions.eq("cname", claname));
			Claname cla=clanameService.findCla(criteria);
			
			detachedCriteria.add(Restrictions.eq("claname", cla));		
			System.out.println("-----------�Ѳ�ѯ�༶------------");
		}
		
		if(job!=null && !job.equals("����ְ��")){
			detachedCriteria.add(Restrictions.eq("job", job));
		}
		
		//ֻ��ѯ �ֶ�deletedSign��Ϊ1 �ļ�¼
		detachedCriteria.add(Restrictions.or(Restrictions.eq("deletedSign", false),Restrictions.isNull("deletedSign")));
				
		
		pageRequestBean.setDetachedCriteria(detachedCriteria);
		//��ѯ���
		PageResponseStudent pageResponseStudent=studentService.findPaginationData(student, pageRequestBean);

		
		//�����ת��Ϊjson
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(pageResponseStudent);
		
		//���ؿͻ���
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);
		return NONE;
	}
}
