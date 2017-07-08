package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.PageRequestBean;
import com.ssss.shareInfo.model.PageResponseStudent;
import com.ssss.shareInfo.model.Student;

public interface StudentService {
	public Student login(Student student);//��¼
	public void editPassword(Student student);//
	public void deleteBatch(String[] ids);//����ɾ��
	public void addStudent(Student student);//���һ��ѧ��
	public void addBatch();//
	public Student findStudent(int id);//����id��ѯ
	public List<Student> findAll();//����id��ѯ
	public void updateStudent(Student student);//����ѧ����Ϣ
	public int findClaStudent(DetachedCriteria criteria);
	public PageResponseStudent findPaginationData(Student student,PageRequestBean pageRequestBean);//ʹ�÷�ҳ��ѯ
}
