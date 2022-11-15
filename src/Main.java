import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ConnectionPoolException, SQLException {

		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initPoolData();

		Connection con = pool.takeConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM users.user");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3) + " (Email: "
					+ rs.getString(4) + ")");
		}

		pool.dispose();

	}

}
