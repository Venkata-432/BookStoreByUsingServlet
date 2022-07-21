package com.bookstoreweb.service;

import java.util.List;

import com.bookstoreweb.entity.BookStoreAdmin;

public interface BookStoreServiceInterface {

	int createProfileService(BookStoreAdmin fb);

	boolean checkLoginService(BookStoreAdmin fb);

	BookStoreAdmin viewProfileService(BookStoreAdmin fb);

	List<BookStoreAdmin> viewAllProfileService();

	int editProfileService(BookStoreAdmin fb);

	int deleteProfileService(BookStoreAdmin fb);
}
