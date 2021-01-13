package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class FindUser {
	public static void handle() {
		Connection conn = null;
		Statement st = null;
		ResultSet ps = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();

			ps = st.executeQuery("SELECT * FROM Users");

			while (ps.next()) {
				System.out.println("Id: " + ps.getInt("id") + " Name: " + ps.getString("name"));
			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
}
