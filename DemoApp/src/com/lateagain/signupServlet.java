package com.lateagain;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signmeup")
public class signupServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String suname = request.getParameter("suname");
		String spass= request.getParameter("spass");
		
		signupDao sdao = new signupDao();
		HttpSession session = request.getSession();
		if(!suname.isEmpty() && !spass.isEmpty())
		{
			if(suname.length()<20 && spass.length()<20)
			{
				try {
					sdao.insert(suname, spass);
					if(sdao.counter==1)
					{
						session.invalidate();
						request.setAttribute("error",  "Username alreasy exists, try with a different one");
						RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
			            rd.forward(request, response);
					}
					else
					{
						session.setAttribute("username", suname);
						response.sendRedirect("welcome.jsp");
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		else
		{	session.invalidate();
			request.setAttribute("error",  "Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
            rd.forward(request, response);
		}
		
		
	}



}
