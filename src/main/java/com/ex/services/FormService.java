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
	
	public List<Form> getEmpForm(String email) {
		return formdao.getFormByEmpId(email);
	}
	
	public List<Form> getManagerForms() {
		return formdao.getFormAllByEmpId();
	}
	
	public void UpdateFormStatus(Form form) {
		Form tempform = formdao.getFormByformid(form.getFormid());
		tempform.setStatus(form.getStatus());
		tempform.setResolvedate(form.getResolvedate());
		formdao.updateTable(tempform);
	}

}
