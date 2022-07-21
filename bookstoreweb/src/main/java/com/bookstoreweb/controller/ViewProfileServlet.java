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

/**
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		Object oo=ss.getAttribute("userid");
		String email=oo.toString();
		
		BookStoreAdmin fb=new BookStoreAdmin();
		fb.setEmail(email);
		
		
		BookStoreServiceInterface fs= new BookStoreService();
		BookStoreAdmin ff=fs.viewProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
			if(ff!=null) {
				out.println("<font color=red size=5>User Detail is below</font>");
				out.println("<br>Name is "+ff.getName());
				out.println("<br>Password is "+ff.getPassword());
				out.println("<br>Email is "+ff.getEmail());
				out.println("<br>Address is "+ff.getAddress());
			}
			else {
				out.println("profile not found");
			}
		out.println("</center></body></html>");
	}

}
