package com.amstepanov.crudtest.dao;

import com.amstepanov.crudtest.model.Document;

import java.util.List;

public interface DocumentDao {

	Document findById(int id);

	void saveDocument(Document document);
	
	void deleteDocumentByCode(String code);
	
	List<Document> findAllDocuments();

	Document findDocumentByCode(String code);
}