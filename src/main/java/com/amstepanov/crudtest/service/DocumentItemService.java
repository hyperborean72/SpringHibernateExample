package com.amstepanov.crudtest.service;

import com.amstepanov.crudtest.model.DocumentItem;

import java.util.List;

public interface DocumentItemService {

	DocumentItem findById(int id);
	
	void saveDocumentItem(DocumentItem documentItem);
	
	void updateDocumentItem(DocumentItem documentItem);

	List<DocumentItem> findAllDocumentItems();
}