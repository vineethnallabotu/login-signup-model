package com.lateagain;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String uname = request.getParameter("uname");
		String pass= request.getParameter("pass");
		
		loginDao dao = new loginDao();
		HttpSession session = request.getSession();
		if(dao.check(uname, pass)) 
		{
			
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
		}
		else
		{	session.invalidate();
			request.setAttribute("errorMessage", "Invalid Username or Password");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
			
		}
	}
}
