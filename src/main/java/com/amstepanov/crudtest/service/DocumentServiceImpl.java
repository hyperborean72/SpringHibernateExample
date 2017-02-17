package com.amstepanov.crudtest.service;

import com.amstepanov.crudtest.dao.DocumentDao;
import com.amstepanov.crudtest.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDao dao;
	
	public Document findById(int id) {
		return dao.findById(id);
	}

	public void saveDocument(Document document) {
		dao.saveDocument(document);
	}

	/*
	 * The method is running with Transaction, hence No need to call hibernate update explicitly.
	 */
	public void updateDocument(Document document) {
		Document entity = dao.findById(document.getId());
		if(entity!=null){
			entity.setName(document.getName());
			entity.setDate(document.getDate());
			entity.setCode(document.getCode());
		}
	}

	public void deleteDocumentByCode(String code) {
		dao.deleteDocumentByCode(code);
	}
	
	public List<Document> findAllDocuments() {
		return dao.findAllDocuments();
	}

	public Document findDocumentByCode(String code) {
		return dao.findDocumentByCode(code);
	}

	public boolean isDocumentCodeUnique(Integer id, String code) {
		Document document = findDocumentByCode(code);
		return ( document == null || ((id != null) && (document.getId() == id)));
	}
}