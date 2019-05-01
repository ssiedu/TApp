package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Booking;

@Component
public class BookingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveBooking(Booking booking){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(booking);
		transaction.commit();
		session.close();
	}
	public void updatBooking(Booking booking){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(booking);
		transaction.commit();
		session.close();
	}
	public List<Booking> getAllBookingByTransporter(String email){
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Booking.class);
		Criterion crt=Restrictions.eq("vehicle.transporter.email", email);
		List<Booking> bookings=cr.list();
		session.close();
		return bookings;
	}
	
	
	
}
