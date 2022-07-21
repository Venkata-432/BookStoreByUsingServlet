package com.bookstoreweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstoreweb.entity.BookStoreAdmin;
import com.bookstoreweb.service.BookStoreService;
import com.bookstoreweb.service.BookStoreServiceInterface;

public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");
		String password=request.getParameter("pass");
		
		BookStoreAdmin fb=new BookStoreAdmin();
		fb.setEmail(email);
		fb.setPassword(password);
		
		BookStoreServiceInterface fs= new BookStoreService();
		boolean b=fs.checkLoginService(fb);
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(b) {
				
				HttpSession ss=request.getSession(true);
				ss.setAttribute("userid", email);
				//ss.setMaxInactiveInterval(1);
				
				out.println("welcome "+email);
				out.println("<a href=ViewProfileServlet>view profile</a>");
				out.println("<a href=EditProfileServlet>edit profile</a>");
				out.println("<a href=SearchProfileServlet>search profile</a>");
				out.println("<a href=DeleteProfileServlet>delete profile</a>");
				out.println("<a href=ViewAllProfileServlet>view all profile</a>");
			}
			else {
				out.println("Invalid id and password <a href=login.html>login again</a>");
			}
		
		
	}

}