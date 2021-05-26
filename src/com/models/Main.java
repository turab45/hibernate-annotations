package com.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	public static void main(String args[]) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Manufacturer manufacturer = session.get(Manufacturer.class, 1);
		
		
		
		//session.save(manufacturer);
		
		Product product = new Product();
		product.setProductName("HeadSet");
		product.setPrice(500);
		product.setManufacturer(manufacturer);
		
		
		//session.save(product);
		
		
		for(Product p: manufacturer.getProducts()) {
			System.out.println("Product: "+p.getProductName());
		}
		
		
		
		session.close();
		factory.close();

	}

}
