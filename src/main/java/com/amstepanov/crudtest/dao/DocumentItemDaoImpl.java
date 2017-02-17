package com.amstepanov.crudtest.dao;

import com.amstepanov.crudtest.model.DocumentItem;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DocumentItemDao")
public class DocumentItemDaoImpl extends AbstractDao<Integer, DocumentItem> implements DocumentItemDao {

	public DocumentItem findById(int id) {
		return getByKey(id);
	}

	public void saveDocumentItem(DocumentItem documentItem) {
		persist(documentItem);
	}

	public List<DocumentItem> findAllDocumentItems() {
		Criteria criteria = createEntityCriteria();
		return (List<DocumentItem>) criteria.list();
	}
}