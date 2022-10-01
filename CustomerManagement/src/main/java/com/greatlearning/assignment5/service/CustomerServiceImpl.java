package com.greatlearning.assignment5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.assignment5.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {
	
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		tx.commit();
		return customers;
	}

	@Transactional
	public Customer findById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Transactional
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}

	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
	}


}
