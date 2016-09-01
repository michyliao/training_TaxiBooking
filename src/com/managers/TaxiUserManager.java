package com.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.connections.MySqlConnection;
import com.domains.TaxiUser;
import com.interfaces.MyDao;

import oracle.jdbc.OracleTypes;

public class TaxiUserManager implements MyDao<TaxiUser> {

	private Connection conn;

	/**
	 * @param conn
	 */
	public TaxiUserManager() throws NullPointerException {
		super();

		if ((this.conn = new MySqlConnection().getMyOracleConnection()) == null) {
			System.out.println(conn);
			throw new NullPointerException();
		}
	}

	@Override
	public int create(TaxiUser user) {
		try {
			CallableStatement stmt = conn.prepareCall("{call create_TaxiUser(?,?,?,?,?) }");

			stmt.setString(1, user.getId());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setLong(4, user.getPhonenumber());
			stmt.setString(5, user.getCity());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(TaxiUser user) {
		try {
			CallableStatement stmt = conn.prepareCall("{call update_TaxiUser(?,?,?,?,?) }");

			stmt.setString(1, user.getId());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setLong(4, user.getPhonenumber());
			stmt.setString(5, user.getCity());

			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(TaxiUser user) {
		try {
			CallableStatement stmt = conn.prepareCall("{call delete_TaxiUser(?)}");

			stmt.setString(1, user.getId());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public TaxiUser find(String id, String... value) {
		TaxiUser user = null;
		try {
			CallableStatement stmt = conn.prepareCall("{call find_TaxiUser(?,?,?) }");

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
				user = new TaxiUser();

				user.setId(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhonenumber(rs.getLong(4));
				user.setCity(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<TaxiUser> findAll() {
		List<TaxiUser> userList = new ArrayList<TaxiUser>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_TaxiUser(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				TaxiUser user = new TaxiUser();

				user.setId(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhonenumber(rs.getLong(4));
				user.setCity(rs.getString(5));

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
