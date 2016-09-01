package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domains.Vehicle;
import com.managers.VehicleManager;

/**
 * Servlet implementation class RoutingServlet
 */
public class RoutingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoutingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String servletPath = request.getServletPath();
		String url = "homepage.jsp";
		
		if ("/CabBooking".equalsIgnoreCase(servletPath)){
			url = "homepage.jsp";
		} else if ("/MyTrips".equalsIgnoreCase(servletPath)){
			url = "MyTrips.jsp";
		} else if ("/RateCard".equalsIgnoreCase(servletPath)){
			url = "RateCard.jsp";
			
			VehicleManager vManager = new VehicleManager();
			List<Vehicle> vList = vManager.findAll();
			
			request.setAttribute("vList", vList);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			
			dispatcher.forward(request, response);
			
		} else if ("/CustCare".equalsIgnoreCase(servletPath)){
			url = "CustomerCare.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
