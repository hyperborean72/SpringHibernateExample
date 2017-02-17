package com.amstepanov.crudtest.service;

import com.amstepanov.crudtest.model.Document;

import java.util.List;

public interface DocumentService {

	Document findById(int id);
	
	void saveDocument(Document document);
	
	void updateDocument(Document document);
	
	void deleteDocumentByCode(String code);

	List<Document> findAllDocuments(); 
	
	Document findDocumentByCode(String code);

	boolean isDocumentCodeUnique(Integer id, String code);
}