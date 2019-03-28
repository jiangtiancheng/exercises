package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl1";
	public static final String DriverName = "oracle.jdbc.driver.OracleDriver";
	public static final String NAME = "scott";
	public static final String PASSWORD = "tiger";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName(DriverName);
		con = DriverManager.getConnection(URL, NAME, PASSWORD);
		return con;
	}
	public static void close(Connection con,PreparedStatement ps,ResultSet resultSet) throws SQLException {
		if(resultSet!=null) {
			resultSet.close();
		}
		if(ps!=null) {
			ps.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	
	public static void close(Connection con,PreparedStatement ps) throws SQLException {
		if(ps!=null) {
			ps.close();
		}
		if(con!=null) {
			con.close();
		}
	}
}
