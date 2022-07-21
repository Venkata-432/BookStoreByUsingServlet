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
 * Servlet implementation class DeleteProfileServlet
 */
public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		Object oo=ss.getAttribute("userid");
		String email=oo.toString();
		BookStoreAdmin fb=new BookStoreAdmin();
		fb.setEmail(email);
		
		
		BookStoreServiceInterface fs= new BookStoreService();
		int ff=fs.deleteProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
			if(ff>0) {
				out.println("<font color=red size=5>User Detail is below</font>");
				out.println("<br>profile deleted ");
				
			}
			else {
				out.println("could not delete profile ");
			}
		out.println("</center></body></html>");
	}

}
