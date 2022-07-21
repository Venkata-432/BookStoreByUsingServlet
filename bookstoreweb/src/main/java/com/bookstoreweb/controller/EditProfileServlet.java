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
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
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
			out.println("<p>Edit profile</p>");
			out.println("<form method=post action=EditProfileServlet1");
			out.println("<table border=25>");
			out.println("<tr><td>Name </td><td><input type=text name=nm value="+ff.getName()+"></td></tr>");
			out.println("<tr><td>Password </td><td><input type=text name=pass value="+ff.getPassword()+"></td></tr>");
			out.println("<tr><td>Email </td><td><input type=text name=em value="+ff.getEmail()+" ></td></tr>");
			out.println("<tr><td>Address </td><td><input type=text name=ad value="+ff.getAddress()+"></td></tr>");
			out.println("<tr><td><input type=submit value=edit> </td><td><input type=reset></td></tr>");
			out.println("</table>");
			out.println("</form>");
		out.println("</center></body></html>");
	}
}
