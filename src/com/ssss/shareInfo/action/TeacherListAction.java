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

	private Teacher teacher=new Teacher();//仅仅用来传递一个Student类型
	
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
		//封装条件
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);
		
		if(department!=null && !department.equals("所有学院")){
			DetachedCriteria deptCriteria=DetachedCriteria.forClass(Department.class);
			System.out.println("***********可以执行 1");
			deptCriteria.add(Restrictions.eq("dname", department));
			System.out.println("***********可以执行2");
			Department dept=departmentService.findDept(deptCriteria);
			
			System.out.println("--------------学院编号："+dept.getDid());
			
			if(dept.getOffices().size()==0){
				detachedCriteria.add(Restrictions.eq("office",new Office(0,null,"无")));
			}else{
				detachedCriteria.add(Restrictions.in("office" , dept.getOffices()));
			}
			
			
//			detachedCriteria.add(Restrictions.in("office" , dept.getOffices() ));
		}
		
		if(office!=null && !office.equals("所有教研室")){
			DetachedCriteria officeCriteria=DetachedCriteria.forClass(Office.class);
			officeCriteria.add(Restrictions.eq("rname", office));		
			Office ofc=officeService.findOffice(officeCriteria);

			
			detachedCriteria.add(Restrictions.eq("office", ofc));
		}
		
		if(title!=null && !title.equals("所有职称")){
			detachedCriteria.add(Restrictions.eq("title", title));
		}
		
		//只查询 字段deletedSign不为1 的记录
		detachedCriteria.add(Restrictions.or(Restrictions.eq("deletedSign", false),Restrictions.isNull("deletedSign")));
		
		
		System.out.println("-----学院-----"+department+"------------");
		System.out.println("-----教研室-----"+office+"------------");
		System.out.println("-----职称-----"+title+"------------");
		
		
		pageRequestBean.setDetachedCriteria(detachedCriteria);
		//查询结果
		PageResponse<Teacher> pageResponse=teacherService.findPaginationData(teacher, pageRequestBean);
			
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(pageResponse);
		
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);
		ServletActionContext.getResponse().getWriter().close();
		return NONE;
	}
}
