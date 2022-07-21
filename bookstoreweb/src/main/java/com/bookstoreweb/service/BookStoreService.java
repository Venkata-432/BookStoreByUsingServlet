package com.bookstoreweb.service;

import java.util.List;

import com.bookstoreweb.dao.BookStoreWebDAO;
import com.bookstoreweb.dao.BookStoreWebDAOInterface;
import com.bookstoreweb.entity.BookStoreAdmin;

public class BookStoreService implements BookStoreServiceInterface{

	@Override
	public int createProfileService(BookStoreAdmin fb) {
		BookStoreWebDAOInterface fd=new BookStoreWebDAO();
		return fd.createProfileDAO(fb);
	}

	@Override
	public boolean checkLoginService(BookStoreAdmin fb) {
		BookStoreWebDAOInterface fd=new BookStoreWebDAO();
		return fd.loginDAO(fb);
	}

	@Override
	public BookStoreAdmin viewProfileService(BookStoreAdmin fb) {
		BookStoreWebDAOInterface fd=new BookStoreWebDAO();
		return fd.viewProfileDAO(fb);
	}

	@Override
	public List<BookStoreAdmin> viewAllProfileService() {
		BookStoreWebDAOInterface fd=new BookStoreWebDAO();
		return fd.viewAllProfileDAO();
	}

	@Override
	public int editProfileService(BookStoreAdmin fb) {
		BookStoreWebDAOInterface fd=new BookStoreWebDAO();
		return fd.editProfileDAO(fb);
	}

	@Override
	public int deleteProfileService(BookStoreAdmin fb) {
		BookStoreWebDAOInterface fd=new BookStoreWebDAO();
		return fd.deleteProfileDAO(fb);
	}
}
