package com.amstepanov.crudtest.dao;

import com.amstepanov.crudtest.model.Document;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DocumentDao")
public class DocumentDaoImpl extends AbstractDao<Integer, Document> implements DocumentDao {

	public Document findById(int id) {
		return getByKey(id);
	}

	public void saveDocument(Document document) {
		persist(document);
	}

	public void deleteDocumentByCode(String code) {
		Query query = getSession().createSQLQuery("delete from Document where code = :code");
		query.setString("code", code);
		query.executeUpdate();
	}

	public List<Document> findAllDocuments() {
		Criteria criteria = createEntityCriteria();
		return (List<Document>) criteria.list();
	}

	public Document findDocumentByCode(String code) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("code", code));
		return (Document) criteria.uniqueResult();
	}
}