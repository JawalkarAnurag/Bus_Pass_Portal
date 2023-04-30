package connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

static Connection con;
	
	public static Connection getConnection() {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "Anurag1726218";

		try {
			System.out.println("in try");
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
