package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DBException;

public class FindOneUser {

	public static void handle(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT * FROM Users WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next() != false) {
				System.out.println("id: " + rs.getInt("id") + " Name: "+ rs.getString("name"));
			}
			else {
				System.out.println("User not found");
			}
		}
		catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
	}

}
