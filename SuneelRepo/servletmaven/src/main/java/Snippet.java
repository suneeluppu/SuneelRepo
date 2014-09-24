import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Snippet {
	public static void main(String[] argv) throws SQLException {
	 
			System.out.println("-------- Oracle JDBC Connection Testing ------");
	 
			try {
	 
				Class.forName("oracle.jdbc.driver.OracleDriver");
	 
			} catch (ClassNotFoundException e) {
	 
				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
				return;
	 
			}
	 
			System.out.println("Oracle JDBC Driver Registered!");
	 
			Connection connection = null;
	 
			try {
	 
				
				System.out.println("Snippet.main()");
				connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:suneel","suneel","tiger");
				
	 
			} catch (SQLException e) {
	 
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
	 
			}
	 
			if (connection != null) {
				connection.close();
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
		}
	 
	}