package com.ssss.shareInfo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;

//把这个类交给Spring管理，重新起个名字叫genericDAO
@Component("genericDAO")
public class GenericDAOImpl<T> implements GenericDAO<T>{

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

	public GenericDAOImpl() {
		super();
	}
	
	
	@Override
	public void save(T obj) {
		hibernateTemplate.save(obj);
	}

	@Override
	public void delecte(T obj) {
		hibernateTemplate.delete(obj);
	}

	@Override
	public void update(T obj) {
		hibernateTemplate.update(obj);
	}

	@Override
	public T findById(Class<T> domainClass, Serializable id) {
		return this.getHibernateTemplate().get(domainClass, id);
	}

	@Override
	public List<T> findAll(T obj) {
		return (List<T>) hibernateTemplate.find("from "+obj.getClass().getName());
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
	}

	@Override
	public List<T> findByNameQuery(String namedQuery,Object ...agrs) {
		return (List<T>) hibernateTemplate.findByNamedQuery(namedQuery,agrs);
	}	

	@Override
	public int findByTotalCount(T obj) {		
		List list=this.getHibernateTemplate().find("select count(*) from "+obj.getClass().getName());
		long temp = (Long) list.get(0);
		return (int)temp;
	}
	
}
