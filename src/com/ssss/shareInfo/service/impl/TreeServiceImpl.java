package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Tree;

@Component("treeService")
public class TreeServiceImpl {	
	//-------用spring 将GenericDAO注入StudentServiceImpl中
		public GenericDAO<Tree>  treeDao;		
		public GenericDAO<Tree> getTreeDao() {
			return treeDao;
		}
		@Resource
		public void setTreeDao(GenericDAO<Tree> treeDao) {
			this.treeDao = treeDao;
		}
		//-------
	
		public List<Tree> findAll(){
			Tree tree=new Tree();
			return treeDao.findAll(tree);
		}
		
		
		
}
