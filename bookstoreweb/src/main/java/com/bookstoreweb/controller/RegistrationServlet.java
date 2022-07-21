package com.bookstoreweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstoreweb.entity.BookStoreAdmin;
import com.bookstoreweb.service.BookStoreService;
import com.bookstoreweb.service.BookStoreServiceInterface;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		BookStoreAdmin fb=new BookStoreAdmin();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		BookStoreServiceInterface fs=new BookStoreService();
		int i=fs.createProfileService(fb);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println("Registration Success <a href=login.html>Sign In</a>");
			}
			else {
				out.println("Registration Fail");
			}
		out.println("</body></html>");
	}

}
