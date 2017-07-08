package com.ssss.shareInfo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface GenericDAO<T> {
	//����
	public void save(T obj);
	//ɾ��
	public void delecte(T obj);
	//�޸�
	public void update(T obj);
	//��ѯ
	public T findById(Class<T> domainClass,Serializable id);
	public List<T> findAll(T obj);//��ѯ����
	public List<T> findByCriteria(DetachedCriteria criteria);//���ָ���������ѯ���������
	public List<T> findByCriteria(DetachedCriteria criteria,int firstResult,int maxResults);//��ҳ��ѯ
	public List<T> findByNameQuery(String namedQuery,Object ...agrs);//����������ѯ��ʹ��hql����ҵ������NamedQuery���ƾͿ�����
	//��ѯĿ��ļ�¼����
	public int findByTotalCount(T obj);
}
