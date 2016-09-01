package com.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MySqlConnection;
import com.domains.CabAvailability;
import com.domains.Booking.BookingType;

import oracle.jdbc.OracleTypes;

public class CabBookingManagement {

	private Connection conn;

	/**
	 * @param conn
	 */
	public CabBookingManagement() throws NullPointerException {
		super();

		if ((this.conn = new MySqlConnection().getMyOracleConnection()) == null) {
			System.out.println(conn);
			throw new NullPointerException();
		}
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void bookCab(CabAvailability bookedCab){
		//Update cab
	}
	
	
	public List<CabAvailability> getAvailableCabs(String location){
		List<CabAvailability> cabList = new ArrayList<CabAvailability>();

		System.out.println(location);
		
		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call find_availableCabs(?,?)}");
			stmt.setString(1, location);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(2);

			while (rs.next()) {
				CabAvailability cab = new CabAvailability();

				cab.setId(rs.getString(1));
				cab.setCar_type(rs.getString(2));
				cab.setDriver_name(rs.getString(3));
				cab.setLocation(rs.getString(4));
				cab.setCar_id(rs.getString(5));

				cabList.add(cab);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return cabList;
		
	}
	
}
