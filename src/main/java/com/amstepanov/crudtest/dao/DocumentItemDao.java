package com.amstepanov.crudtest.dao;

import com.amstepanov.crudtest.model.DocumentItem;

import java.util.List;

public interface DocumentItemDao {

	DocumentItem findById(int id);

	void saveDocumentItem(DocumentItem documentItem);
	
	List<DocumentItem> findAllDocumentItems();
}