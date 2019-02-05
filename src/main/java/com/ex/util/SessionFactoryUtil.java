package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil{
	
	private  SessionFactory sessFactory;
	
	public SessionFactoryUtil() {
		try {
			Class.forName("org.postgresql.Driver");
			StandardServiceRegistry standardRegistry =
			new StandardServiceRegistryBuilder().configure().build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			SessionFactory sessFactory = metaData.getSessionFactoryBuilder().build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Session getCurrentSession() {
		return sessFactory.openSession();
	}
	
}