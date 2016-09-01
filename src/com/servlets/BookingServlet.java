package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domains.Booking;
import com.domains.CabAvailability;
import com.domains.Booking.BookingType;
import com.managers.BookingManager;
import com.managers.CabBookingManagement;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		String url = "homepage.jsp";

		String email = request.getParameter("email");
		String phoneStr = request.getParameter("phone");
		String bookingTypeStr = request.getParameter("bookingType");
		String pickup = request.getParameter("pickupPlace");
		String dropoff = request.getParameter("dropoffPlace");

		Long phone = Long.parseLong(phoneStr);
		BookingType bookingType = BookingType.valueOf(bookingTypeStr);

		BookingManager manager = new BookingManager();
		
		Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

		// Sanity Check
		if (loggedIn) {

			if ("/CreateBooking".equalsIgnoreCase(servletPath)) {
				String action = request.getParameter("action");
				Booking tempBooking = new Booking(email, phone, bookingType, pickup, dropoff);
				
				if ("bookNow".equalsIgnoreCase(action)) {
					manager.create(tempBooking);
									
					//Get Available Cabs at that location
					CabBookingManagement cabManager = new CabBookingManagement();
					List<CabAvailability> cabList = cabManager.getAvailableCabs(pickup);
					
					System.out.println("IN HERE");
					System.out.println(cabList);
					
					request.setAttribute("availCabs", cabList);
					url = "availableCabs.jsp";
					
				} else if ("bookLater".equalsIgnoreCase(action)) {
					// TODO: Take them to the next page && take the information from here to the next page as well
					url = "delayBooking.jsp";
					request.setAttribute("tempBooking", tempBooking);
				}
			} else if ("/DelayBooking".equalsIgnoreCase(servletPath)) {
				// Get the date input

			} else if ("/ConfirmPage".equalsIgnoreCase(servletPath)){
				url="confirmation.html";
			}
		} else {
			url = "index.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}
}
