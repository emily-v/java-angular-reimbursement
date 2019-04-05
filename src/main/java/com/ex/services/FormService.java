package com.ex.services;

import java.util.List;
import com.ex.dao.FormDao;
import com.ex.model.Form;

public class FormService {
	
	private FormDao formdao;
	
	public FormService() {
		this.formdao = new FormDao();
	}
	
	public boolean formInsert(Form f) {
		formdao.insertIntoTable(f);
		return true;
	}
	
	public List<Form> getEmpForm(int userId) {
		return formdao.getFormByEmpId(userId);
	}
	
	public List<Form> getManagerForms() {
		return formdao.getAllForms();
	}

	public Form getForm(int formId) { return formdao.getFormById(formId); }
	
	public void updateForm(Form form) {
		Form tempForm = formdao.getFormById(form.getFormId());
//		tempform.setStatus(form.getStatus());
//		tempform.setResolveDate(form.getResolveDate());
		formdao.updateTable(tempForm);
	}

}
