package com.amstepanov.crudtest.controller;

import com.amstepanov.crudtest.model.Document;
import com.amstepanov.crudtest.model.DocumentItem;
import com.amstepanov.crudtest.service.DocumentItemService;
import com.amstepanov.crudtest.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	DocumentService service;

	@Autowired
	DocumentItemService itemService;
	
	@Autowired
	MessageSource messageSource;


	/* Converter for Document drop-down on the new Item registration page */
	class DocumentEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String id)
		{
			this.setValue(service.findById(Integer.parseInt(id)));
		}
	}


	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listDocuments(ModelMap model) {

		List<Document> documents = service.findAllDocuments();
		model.addAttribute("documents", documents);
		return "alldocuments";
	}


	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newDocument(ModelMap model) {
		Document document = new Document();
		model.addAttribute("document", document);
		model.addAttribute("edit", false);
		return "registration";
	}


	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveDocument(@Valid Document document, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}


		if(!service.isDocumentCodeUnique(document.getId(), document.getCode())){
			FieldError codeError =new FieldError("document","code",messageSource.getMessage("non.unique.document.code", new String[]{document.getCode()}, Locale.getDefault()));
		    result.addError(codeError);
			return "registration";
		}
		
		service.saveDocument(document);

		model.addAttribute("success", "Document " + document.getName() + " uploaded successfully");
		return "success";
	}


	/*
	 * Move to form with editing capabilities for existing document
	 */
	@RequestMapping(value = { "/edit-{code}-document" }, method = RequestMethod.GET)
	public String editDocument(@PathVariable String code, ModelMap model) {
		Document document = service.findDocumentByCode(code);
		model.addAttribute("document", document);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * Method handling document form submission with input validation
	 */
	@RequestMapping(value = { "/edit-{code}-document" }, method = RequestMethod.POST)
	public String updateDocument(@Valid Document document, BindingResult result,
			ModelMap model, @PathVariable String code) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isDocumentCodeUnique(document.getId(), document.getCode())){
			FieldError codeError =new FieldError("document","code",messageSource.getMessage("non.unique.document.code", new String[]{document.getCode()}, Locale.getDefault()));
		    result.addError(codeError);
			return "registration";
		}

		service.updateDocument(document);

		model.addAttribute("success", "Document " + document.getName()	+ " updated successfully");
		return "success";
	}

	/*
	*  Delete existing document
	* */
	@RequestMapping(value = { "/delete-{code}-document" }, method = RequestMethod.GET)
	public String deleteDocument(@PathVariable String code) {
		service.deleteDocumentByCode(code);
		return "redirect:/list";
	}


	/* Part responsible for DocumentItem processing */

	@RequestMapping(value = { "/listItems" }, method = RequestMethod.GET)
	public String listDocumentItems(ModelMap model) {

		List<DocumentItem> documentItems = itemService.findAllDocumentItems();
		model.addAttribute("documentItems", documentItems);
		return "alldocumentitems";
	}


	@RequestMapping(value = { "/newItem" }, method = RequestMethod.GET)
	public String newDocumentItem(ModelMap model) {
		DocumentItem documentItem = new DocumentItem();
		model.addAttribute("documentItem", documentItem);
		List<Document> documents = service.findAllDocuments();
		model.addAttribute("documents", documents);
		model.addAttribute("edit", false);
		return "newItemRegistration";
	}


	/* Converter for Document drop-down on the new Item registration page */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Document.class, new DocumentEditor());
	}


	@RequestMapping(value = { "/newItem" }, method = RequestMethod.POST)
	public String saveDocumentItem(@Valid DocumentItem documentItem, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "newItemRegistration";
		}

		itemService.saveDocumentItem(documentItem);
		model.addAttribute("success", "Document Item: " + documentItem.getName() + " uploaded successfully");
		return "success";
	}
}