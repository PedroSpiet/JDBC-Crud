package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class CreateUser {

	public static void handle(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement("INSERT INTO Users (name)"
					+ "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, name);
			
			int AffectedRows = st.executeUpdate();
			
			if (AffectedRows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					System.out.println(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		
	}

}
