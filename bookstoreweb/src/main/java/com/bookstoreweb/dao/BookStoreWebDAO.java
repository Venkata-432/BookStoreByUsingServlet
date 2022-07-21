package com.bookstoreweb.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bookstoreweb.entity.BookStoreAdmin;

public class BookStoreWebDAO implements BookStoreWebDAOInterface{

	public int createProfileDAO(BookStoreAdmin fb) {
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
			s.save(fb);
		et.commit();
		i=1;
		return i;
	}

	public boolean loginDAO(BookStoreAdmin fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.bookstoreweb.entity.BookStoreAdmin f where email=:em and password=:pw");
		q.setParameter("em", fb.getEmail());
		q.setParameter("pw", fb.getPassword());
		
		List<BookStoreAdmin> ll=q.getResultList();
		if(ll.size()>0) {
			return true;
		}
		return false;
	}

	public BookStoreAdmin viewProfileDAO(BookStoreAdmin fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.bookstoreweb.entity.BookStoreAdmin f where email=:em");
		q.setParameter("em", fb.getEmail());
		
		BookStoreAdmin f1=null;
		List<BookStoreAdmin> ll=q.getResultList();
		if(ll.size()>0) {
			for(BookStoreAdmin s1:ll) {
				f1=s1;
			}
		}
		return f1;
	}

	public List<BookStoreAdmin> viewAllProfileDAO() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.bookstoreweb.entity.BookStoreAdmin f");
		
		List<BookStoreAdmin> ll=q.getResultList();
		return ll;
	}

	public int editProfileDAO(BookStoreAdmin fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("update com.bookstoreweb.entity.BookStoreAdmin f set f.name=:nm, f.password=:pw, f.address=:ad where f.email=:em");
		q.setParameter("nm", fb.getName());
		q.setParameter("pw", fb.getPassword());
		q.setParameter("ad", fb.getAddress());
		q.setParameter("em", fb.getEmail());
		EntityTransaction et=s.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}

	public int deleteProfileDAO(BookStoreAdmin fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("delete from com.bookstoreweb.entity.BookStoreAdmin f where f.email=:em");
		q.setParameter("em", fb.getEmail());
		EntityTransaction et=s.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}
}
