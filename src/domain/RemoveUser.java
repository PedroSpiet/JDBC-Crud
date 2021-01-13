package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DBException;

public class RemoveUser {

	public static void handle(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("DELETE FROM Users WHERE id = ?");
			ps.setInt(1, id);
			
			int RowsAffected = ps.executeUpdate();
			
			System.out.println("Done! rows affected: "+ RowsAffected);
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

}
