package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.ex.model.User;

public class UserDao{
	
	private Transaction transaction;
	public static Session session;

	public UserDao() {
		try {
			
			Class.forName("org.postgresql.Driver");
		
			StandardServiceRegistry standardRegistry =
			new StandardServiceRegistryBuilder().configure().build();
			
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			
			SessionFactory sessFactory = metaData.getSessionFactoryBuilder().build();
		
			session = sessFactory.openSession();
			transaction = session.getTransaction();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}

	// this method is creating the table for users in the database
	public String createTable()	{
		transaction.begin();
		session.createSQLQuery("create table if not exists ersuser(user_id int, email varchar primary key, password varchar, first_name varchar, last_name varchar, role varchar)").executeUpdate();
		transaction.commit();
		return null;
	}
	
	// this method allows a new user to be saved into the users table
	public String insertIntoTable(User user) {
		transaction.begin();
		session.save(user);
		transaction.commit();
		return null;
	}
	
	// this method is to update a user in the user table
	public String updateTable(User user) {
		transaction.begin();
		session.update(user);
		transaction.commit();
		return null;		
	}
	
	// this method will delete a user from the user table (but is not being used)
	public String deleteFromTable(User user) {
		transaction.begin();
		session.delete(user);
		transaction.commit();
		return null;	
	}
	
	// this method is selecting a user from the user table by their email
	public User getUserById(String id) {
		transaction.begin();
		User user =	session.get(User.class, id);
		transaction.commit();
		return user;
	}
	
	// this method is selecting a user from the user table by their role (employee/manager)
	public User getUserByRole(boolean role) {
		transaction.begin();
		User user = (User) session.createQuery("from ersuser where role='"+role+"'");
		transaction.commit();
		return user;	
	}

}