package com.bookstoreweb.dao;

import java.util.List;

import com.bookstoreweb.entity.BookStoreAdmin;

public interface BookStoreWebDAOInterface {

	int createProfileDAO(BookStoreAdmin fb);

	boolean loginDAO(BookStoreAdmin fb);

	BookStoreAdmin viewProfileDAO(BookStoreAdmin fb);

	List<BookStoreAdmin> viewAllProfileDAO();

	int editProfileDAO(BookStoreAdmin fb);

	int deleteProfileDAO(BookStoreAdmin fb);
}
