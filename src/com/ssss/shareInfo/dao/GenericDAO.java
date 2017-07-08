package com.ssss.shareInfo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface GenericDAO<T> {
	//增加
	public void save(T obj);
	//删除
	public void delecte(T obj);
	//修改
	public void update(T obj);
	//查询
	public T findById(Class<T> domainClass,Serializable id);
	public List<T> findAll(T obj);//查询所有
	public List<T> findByCriteria(DetachedCriteria criteria);//各种各样条件查询，添加排序
	public List<T> findByCriteria(DetachedCriteria criteria,int firstResult,int maxResults);//分页查询
	public List<T> findByNameQuery(String namedQuery,Object ...agrs);//进行条件查询，使用hql，在业务层调用NamedQuery名称就可以了
	//查询目标的记录总数
	public int findByTotalCount(T obj);
}
