package com.ssi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ssi.entities.Vehicle;

@Component
public class VehicleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveVehicle(Vehicle vehicle){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(vehicle);
		transaction.commit();
		session.close();
	}
	public void updateVehicle(Vehicle vehicle){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(vehicle);
		transaction.commit();
		session.close();
	}
}
