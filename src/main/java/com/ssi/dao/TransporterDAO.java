package com.ssi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Customer;
import com.ssi.entities.Transporter;

@Component
public class TransporterDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Transporter getTransporterDetails(String email){
		Session session=sessionFactory.openSession();
		Transporter transporter=session.get(Transporter.class,email);
		session.close();
		return transporter;
	}
	
	public boolean verifyTransporter(Transporter transporter){
		Session session=sessionFactory.openSession();
		Transporter transporter1=session.get(Transporter.class, transporter.getEmail());
		if(transporter1==null){
			return false;
		}else{
			if(transporter.getPassword().equals(transporter1.getPassword())){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public void saveTransporter(Transporter transporter){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(transporter);
		transaction.commit();
		session.close();
	}
}
