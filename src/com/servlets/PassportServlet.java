package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domains.TaxiUser;
import com.services.Passport;

/**
 * Servlet implementation class PassportServices
 */
public class PassportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PassportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		HttpSession session = request.getSession();
		Passport passport = new Passport();
		String url = "index.jsp"; //Default value

		if ("/Login".equalsIgnoreCase(servletPath)) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String city = request.getParameter("city");

			if (passport.validate(email, password, city) && session.isNew()) {
				session.setAttribute("currentUser", passport.getUser(email));
				session.setAttribute("loggedIn", true);
				url = "homepage.jsp";
			}

		} else if ("/SignUp".equalsIgnoreCase(servletPath)) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String city = request.getParameter("city");
			String phoneStr = request.getParameter("phone");
			
			Long phone = Long.parseLong(phoneStr);

			System.out.println(passport.validate(email, password, city));
			System.out.println(session.isNew());
			
			if (!passport.validate(email, password, city) && session.isNew()) {
				TaxiUser newUser = passport.createUser(email, password, phone, city);
				session.setAttribute("currentUser", newUser);
				session.setAttribute("loggedIn", true);
				url = "homepage.jsp";
			}
		} else if ("/Logout".equalsIgnoreCase(servletPath)){
			session.invalidate();
		}

		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
