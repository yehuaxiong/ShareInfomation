package com.ssss.shareInfo.action;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.New;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponse;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.OfficeService;
import com.ssss.shareInfo.service.TeacherService;

import flexjson.JSONSerializer;

public class TeacherListAction extends ActionSupport implements ModelDriven<PageRequestBean>{
	private PageRequestBean pageRequestBean=new PageRequestBean();
	@Override
	public PageRequestBean getModel() {
		// TODO Auto-generated method stub
		return pageRequestBean;
	}

	private Teacher teacher=new Teacher();//������������һ��Student����
	
	private String department;
	private String office;
	private String title;
			
	public String getDepartment() {
		return department;
	}

	public String getOffice() {
		return office;
	}

	public String getTitle() {
		return title;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private TeacherService teacherService;	
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	private OfficeService officeService;
	@Resource(name="officeService")
	public void setOfficeService(OfficeService officeService) {
		this.officeService = officeService;
	}
	
	private DepartmentService departmentService;
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public String execute() throws Exception {
		//��װ����
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);
		
		if(department!=null && !department.equals("����ѧԺ")){
			DetachedCriteria deptCriteria=DetachedCriteria.forClass(Department.class);
			System.out.println("***********����ִ�� 1");
			deptCriteria.add(Restrictions.eq("dname", department));
			System.out.println("***********����ִ��2");
			Department dept=departmentService.findDept(deptCriteria);
			
			System.out.println("--------------ѧԺ��ţ�"+dept.getDid());
			
			if(dept.getOffices().size()==0){
				detachedCriteria.add(Restrictions.eq("office",new Office(0,null,"��")));
			}else{
				detachedCriteria.add(Restrictions.in("office" , dept.getOffices()));
			}
			
			
//			detachedCriteria.add(Restrictions.in("office" , dept.getOffices() ));
		}
		
		if(office!=null && !office.equals("���н�����")){
			DetachedCriteria officeCriteria=DetachedCriteria.forClass(Office.class);
			officeCriteria.add(Restrictions.eq("rname", office));		
			Office ofc=officeService.findOffice(officeCriteria);

			
			detachedCriteria.add(Restrictions.eq("office", ofc));
		}
		
		if(title!=null && !title.equals("����ְ��")){
			detachedCriteria.add(Restrictions.eq("title", title));
		}
		
		//ֻ��ѯ �ֶ�deletedSign��Ϊ1 �ļ�¼
		detachedCriteria.add(Restrictions.or(Restrictions.eq("deletedSign", false),Restrictions.isNull("deletedSign")));
		
		
		System.out.println("-----ѧԺ-----"+department+"------------");
		System.out.println("-----������-----"+office+"------------");
		System.out.println("-----ְ��-----"+title+"------------");
		
		
		pageRequestBean.setDetachedCriteria(detachedCriteria);
		//��ѯ���
		PageResponse<Teacher> pageResponse=teacherService.findPaginationData(teacher, pageRequestBean);
			
		
		//�����ת��Ϊjson
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(pageResponse);
		
		//���ؿͻ���
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);
		ServletActionContext.getResponse().getWriter().close();
		return NONE;
	}
}
