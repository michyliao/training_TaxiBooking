package com.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MySqlConnection;
import com.domains.Booking;
import com.domains.Booking.BookingType;
import com.interfaces.MyDao;

import oracle.jdbc.OracleTypes;

public class BookingManager implements MyDao<Booking> {
	
	private Connection conn;

	/**
	 * @param conn
	 */
	public BookingManager() throws NullPointerException {
		super();

		if ((this.conn = new MySqlConnection().getMyOracleConnection()) == null) {
			System.out.println(conn);
			throw new NullPointerException();
		}
	}


	@Override
	public int create(Booking booking) {
		try {
			CallableStatement stmt = conn.prepareCall("{call create_Booking(?,?,?,?,?,?,?) }");

			stmt.setString(1, booking.getId());
			stmt.setString(2, booking.getEmail());
			stmt.setLong(3, booking.getPhone());
			stmt.setString(4, booking.getBookingType().toString());
			stmt.setString(5, booking.getPickupPlace());
			stmt.setString(6, booking.getDropoffPlace());
			stmt.setDate(7, (Date)booking.getPickupTime());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(Booking booking) {
		try {
			CallableStatement stmt = conn.prepareCall("{call update_Booking(?,?,?,?,?,?,?) }");

			stmt.setString(1, booking.getId());
			stmt.setString(2, booking.getEmail());
			stmt.setLong(3, booking.getPhone());
			stmt.setString(4, booking.getBookingType().toString());
			stmt.setString(5, booking.getPickupPlace());
			stmt.setString(6, booking.getDropoffPlace());
			stmt.setDate(7, booking.getPickupTime());
			
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(Booking booking) {
		try {
			CallableStatement stmt = conn.prepareCall("{call delete_Booking(?)}");

			stmt.setString(1, booking.getId());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Booking find(String id, String... value) {
		Booking booking = null;
		try {
			CallableStatement stmt = conn.prepareCall("{call find_Booking(?,?,?) }");

			if (!id.equals(null)) {
				stmt.setString(1, id);
			} else {
				stmt.setString(1, "");
			}

			if (value.length > 0) {
				stmt.setString(2, value[0]);
			} else {
				stmt.setString(2, "");
			}

			stmt.registerOutParameter(3, OracleTypes.CURSOR);

			stmt.executeQuery();

			ResultSet rs = (ResultSet) stmt.getObject(3);

			
			while (rs.next()) {
				booking = new Booking();

				booking.setId(rs.getString(1));
				booking.setEmail(rs.getString(2));
				booking.setPhone(rs.getLong(3));
				booking.setBookingType(BookingType.valueOf(rs.getString(4)));
				booking.setPickupPlace(rs.getString(5));
				booking.setDropoffPlace(rs.getString(6));
				booking.setPickupTime(rs.getDate(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;
	}

	@Override
	public List<Booking> findAll() {
		List<Booking> bookingList = new ArrayList<Booking>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_Bookings(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				Booking booking = new Booking();

				booking.setId(rs.getString(1));
				booking.setEmail(rs.getString(2));
				booking.setPhone(rs.getLong(3));
				booking.setBookingType(BookingType.valueOf(rs.getString(4)));
				booking.setPickupPlace(rs.getString(5));
				booking.setDropoffPlace(rs.getString(6));
				booking.setPickupTime(rs.getDate(7));

				bookingList.add(booking);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookingList;
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
