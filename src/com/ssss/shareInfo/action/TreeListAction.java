package com.ssss.shareInfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.model.Teacher;
import com.ssss.shareInfo.model.Tree;
import com.ssss.shareInfo.service.ClanameService;
import com.ssss.shareInfo.service.DepartmentService;
import com.ssss.shareInfo.service.OfficeService;
import com.ssss.shareInfo.service.SpecialtyService;
import com.ssss.shareInfo.service.StudentService;
import com.ssss.shareInfo.service.TeacherService;
import com.ssss.shareInfo.service.impl.TreeServiceImpl;

import flexjson.JSONSerializer;

public class TreeListAction extends ActionSupport{
	private TreeServiceImpl treeServiceImpl;
	@Resource(name="treeService")
	public void setTreeServiceImpl(TreeServiceImpl treeServiceImpl){
		this.treeServiceImpl = treeServiceImpl;
	}
	
	private DepartmentService departmentService;	
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	private SpecialtyService specialtyService;	
	@Resource(name="specialtyService")
	public void setSpecialtyService(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	private ClanameService clanameService;	
	@Resource(name="clanameService")
	public void setClanameService(ClanameService clanameService) {
		this.clanameService = clanameService;
	}

	private StudentService studentService;	
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
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
	@Override
	public String execute() throws Exception {		
		List<Department> departments=departmentService.findAll();
		List<Specialty> specialties=specialtyService.findAll();
		List<Claname> clanames=clanameService.findAll();
		List<Student> students=studentService.findAll();
		List<Teacher> teachers=teacherService.findAll();
		List<Office> offices=officeService.findAll();
		List<Tree> trees=new ArrayList<Tree>();
				
		for(Department department:departments){
			Tree tree=new Tree();
			tree.setId(department.getDid());
			tree.setpId(department.getPid());
			tree.setName(department.getDname());
			trees.add(tree);
		}
		for(Specialty specialty:specialties){
			Tree tree=new Tree();
			tree.setId(specialty.getSid());
			tree.setpId(specialty.getDepartment().getDid());
			tree.setName(specialty.getSname());
			trees.add(tree);
		}
		for(Claname claname:clanames){
			Tree tree=new Tree();
			tree.setId(claname.getCid());
			tree.setpId(claname.getSpecialty().getSid());
			tree.setName(claname.getCname());
			trees.add(tree);
		}
		for(Student student:students){
			Tree tree=new Tree();
			tree.setId(student.getId());
			tree.setpId(student.getClaname().getCid());
			tree.setName(student.getName());
			trees.add(tree);
		}
		
		for(Office office:offices){
			Tree tree=new Tree();
			tree.setId(office.getRid());
			tree.setpId(office.getDepartment().getDid());
			tree.setName(office.getRname());
			trees.add(tree);
		}
		
		for(Teacher teacher:teachers){
			Tree tree=new Tree();
			tree.setId(teacher.getId());
			tree.setpId(teacher.getOffice().getRid());
			tree.setName(teacher.getName());
			trees.add(tree);
		}
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(trees);
		
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);
		return NONE;
	}
}
