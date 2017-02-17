package com.amstepanov.crudtest.service;

import com.amstepanov.crudtest.dao.DocumentItemDao;
import com.amstepanov.crudtest.model.DocumentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("documentItemService")
@Transactional
public class DocumentItemServiceImpl implements DocumentItemService {

	@Autowired
	private DocumentItemDao dao;
	
	public DocumentItem findById(int id) {
		return dao.findById(id);
	}

	public void saveDocumentItem(DocumentItem documentItem) {
		dao.saveDocumentItem(documentItem);
	}


	public void updateDocumentItem(DocumentItem documentItem) {
		DocumentItem entity = dao.findById(documentItem.getId());
		if(entity!=null){
			entity.setName(documentItem.getName());
			entity.setPrice(documentItem.getPrice());
			entity.setDocument(documentItem.getDocument());
		}
	}


	public List<DocumentItem> findAllDocumentItems() {
		return dao.findAllDocumentItems();
	}
}