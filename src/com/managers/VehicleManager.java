package com.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MySqlConnection;
import com.domains.Vehicle;
import com.interfaces.MyDao;

import oracle.jdbc.OracleTypes;

public class VehicleManager implements MyDao<Vehicle> {

	private Connection conn;

	/**
	 * @param conn
	 */
	public VehicleManager() throws NullPointerException {
		super();

		if ((this.conn = new MySqlConnection().getMyOracleConnection()) == null) {
			System.out.println(conn);
			throw new NullPointerException();
		}
	}

	
	@Override
	public int create(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vehicle find(String id, String... value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findAll() {
		List<Vehicle> vList = new ArrayList<Vehicle>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_Vehicles(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				Vehicle vehicle = new Vehicle();

				vehicle.setId(rs.getString(1));
				vehicle.setType(rs.getString(2));
				vehicle.setType_full(rs.getString(3));
				vehicle.setMinKm(rs.getDouble(4));
				vehicle.setAddCharge(rs.getDouble(5));
				vehicle.setWtgCharge(rs.getDouble(6));

				vList.add(vehicle);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vList;
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
