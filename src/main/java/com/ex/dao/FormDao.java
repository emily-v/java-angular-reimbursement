package com.ex.dao;

import java.util.List;
import org.hibernate.Transaction;
import com.ex.model.Form;

public class FormDao {
	
	private Transaction transaction;
	
	public FormDao() {
	
	}
	
	// this method is creating the table for reimbursements in the database 
	public String createTable()	{
		UserDao.session.beginTransaction();
		UserDao.session.createSQLQuery("create table if not exists ersform(form_id int primary key, form_type varchar, form_status varchar, form_amount varchar, form_notes varchar)").executeUpdate();
		UserDao.session.getTransaction().commit();
		return null;
	}
	
	// this method lets the user save a new form into the reimbursement table
	public void insertIntoTable(Form form) {
		UserDao.session.beginTransaction();
		UserDao.session.save(form);
		UserDao.session.getTransaction().commit();
	}
	
	// this method is to update a forms in the reimbursement table 
	public String updateTable(Form form) {
		UserDao.session.beginTransaction();
		UserDao.session.update(form);
		UserDao.session.getTransaction().commit();
		return null;
	}
	
	// this method lets the user delete from the reimbursement table (but is not being used)
	public String deleteFromTable(Form form) {
		UserDao.session.beginTransaction();
		UserDao.session.delete(form);
		UserDao.session.getTransaction().commit(); 
		return null;
	}
	
	// this method is selecting the form from the reimbursement table by status (approved/pending/denied) 
	public Form getFormByStatus(Form status) {
		UserDao.session.beginTransaction();		
		Form form = (Form) UserDao.session.createQuery("from ersform where status='"+status+"'");
		UserDao.session.getTransaction().commit();	
		return form;
	}
	
	// this method is selecting the form from the reimbursement table by type (food/travel/lodging/other) 	
	public Form getFormByType(Form type) {
		UserDao.session.beginTransaction();		
		Form form = (Form) UserDao.session.createQuery("from ersform where type='"+type+"'");
		UserDao.session.getTransaction().commit();	
		return form;
	}
	
	// this method is selecting a form from the reimbursement table by the employee id
	public List<Form> getFormByEmpId(int userId){
		UserDao.session.beginTransaction();
		List<Form> form = (List<Form>)UserDao.session.createQuery("from Form where userId = '"+userId+"'").list();
		UserDao.session.getTransaction().commit();
		return form;
	}
	
	// this method is selecting all forms from the reimbursement table by the employee id	
	public List<Form>getAllForms(){
		UserDao.session.beginTransaction();
		List<Form> form = (List<Form>)UserDao.session.createQuery("from Form").list();
		UserDao.session.getTransaction().commit();
		return form;
	 }

	public Form getFormById(int formId) {
		UserDao.session.beginTransaction();
		Form form =	UserDao.session.get(Form.class, formId);
		UserDao.session.getTransaction().commit();
		return form;
	}
	
}